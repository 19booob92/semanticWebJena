package org.pwr.molczak.semanticWeb.jena;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.pwr.molczak.semanticWeb.utils.StringUtils;

public class Ontology {

	private OntModel model;
	private ModelCreator modelCreator;

	public Ontology() {
		modelCreator = new ModelCreator();
		model = modelCreator.getModel();
	}

	public void printClasses() {
		ExtendedIterator<OntClass> classes = model.listClasses();

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();

			String localName = ontClass.getLocalName();
			if (localName != null) {
				String className = localName.toString();
				if (className != null && !className.equals("")) {
					System.out.println(className);
				}
			}
		}

	}

	public void printInstances() {
		ExtendedIterator<Individual> individuals = model.listIndividuals();

		while (individuals.hasNext()) {
			Individual ontIndividuals = individuals.next();

			String localName = ontIndividuals.getLocalName();
			if (localName != null) {
				String indivitualName = localName.toString();
				if (indivitualName != null && !indivitualName.equals("")) {
					System.out.println(indivitualName);
				}
			}
		}
	}

	public void printProperties() {
		ExtendedIterator<OntProperty> properties = model.listAllOntProperties();

		while (properties.hasNext()) {
			OntProperty ontProperty = properties.next();

			String localName = ontProperty.getLocalName();
			if (localName != null) {
				String propertyName = localName.toString();
				if (propertyName != null && !propertyName.equals("")) {
					System.out.println(propertyName);
				}
			}
		}
	}

	public void printClassesWithIndividuals() {
		ExtendedIterator<OntClass> classes = model.listClasses();

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();

			String localName = ontClass.getLocalName();
			ExtendedIterator<? extends OntResource> classInstances = ontClass.listInstances();

			if (localName != null && classInstances != null && classInstances.hasNext()) {

				String className = localName.toString();
				System.out.print(className + "\n\t");

				while (classInstances.hasNext()) {
					OntResource instance = classInstances.next();
					System.out.print(instance.getLocalName());
					if (classInstances.hasNext()) {
						System.out.print("\n\t");
					}
				}
				System.out.println();
			}
		}
	}

	public void printClassesWithSubClasses() {
		ExtendedIterator<OntClass> classes = model.listClasses();

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();

			String localName = ontClass.getLocalName();
			ExtendedIterator<? extends OntResource> subClasses = ontClass.listSubClasses();

			if (localName != null && subClasses != null && subClasses.hasNext()) {

				String className = localName.toString();
				System.out.println(className + "\n\t");

				while (subClasses.hasNext()) {
					OntResource instance = subClasses.next();
					System.out.print(instance.getLocalName());
					if (subClasses.hasNext()) {
						System.out.print("\n\t");
					}
				}
			}
		}
	}

	public void listClassHierarchy() {
		ExtendedIterator<OntClass> classes = model.listClasses();
		int result = 0;

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();
			result = 1;
			findChildren(ontClass, result, true);
		}
	}

	private void findChildren(OntResource parent, int indent, boolean printSuper) {
		OntClass ontClass = (OntClass) parent;
		ExtendedIterator<? extends OntResource> subClasses = ontClass.listSubClasses();

		if (ontClass.getLocalName() != null) {

			if (ontClass.hasSubClass() && printSuper) {
				System.out.println(ontClass.getLocalName());
			}

			while (subClasses.hasNext()) {
				OntClass nextValue = (OntClass) subClasses.next();
				if (nextValue.hasSubClass()) {
					System.out.print("\t");
					System.out.println(nextValue.getLocalName());
					findChildren(nextValue, indent + 1, false);
				} else {
					for (int i = 0; i < indent; i++) {
						System.out.print("\t");
					}
					System.out.println(nextValue.getLocalName());
				}
			}
		}
	}

	public void listPropertiesWithRangeAndDomain() {
		ExtendedIterator<OntProperty> properties = model.listAllOntProperties();
		OntResource domain;
		OntResource range;

		while (properties.hasNext()) {
			OntProperty property = properties.next();
			domain = property.getDomain();
			range = property.getRange();
			
			System.out.print(property.getLocalName());

			if (domain != null) {
				System.out.print("\n\t");
				System.out.print("domena : ");
				System.out.print(domain.getLocalName());
			}
			if (range != null) {
				System.out.print("\n\t");
				System.out.print("zakres : ");
				System.out.println(range.getLocalName());
			} else {
				System.out.println();
			}
		}
	}

}
