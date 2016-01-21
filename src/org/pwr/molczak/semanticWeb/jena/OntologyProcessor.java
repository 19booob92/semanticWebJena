package org.pwr.molczak.semanticWeb.jena;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.pwr.molczak.semanticWeb.utils.StringUtils;
import org.pwr.molczak.semanticWeb.utils.Tuple;

public class OntologyProcessor {

	private OntModel model;
	private RunJena runJena;

	public OntologyProcessor() {
		runJena = new RunJena();
		model = runJena.getModel();
	}

	public Tuple<String, Long> listAllClasses() {
		StringBuilder classesNames = new StringBuilder();

		Long amount = 0L;

		ExtendedIterator<OntClass> classes = model.listClasses();

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();

			String localName = ontClass.getLocalName();
			if (localName != null) {
				String className = localName.toString();
				classesNames.append(className);
				classesNames.append(", \n");
				amount++;
			}
		}

		String allClasses = StringUtils.removeLastComma(classesNames);
		return new Tuple<String, Long>(allClasses, amount);
	}

	public Tuple<String, Long> listAllInstances() {
		StringBuilder individualsNames = new StringBuilder();

		Long amount = 0L;

		ExtendedIterator<Individual> individuals = model.listIndividuals();

		while (individuals.hasNext()) {
			Individual ontIndividuals = individuals.next();

			String localName = ontIndividuals.getLocalName();
			if (localName != null) {
				String indicidualName = localName.toString();
				individualsNames.append(indicidualName);
				individualsNames.append(", \n");
				amount++;
			}
		}

		String allProperties = StringUtils.removeLastComma(individualsNames);
		return new Tuple<String, Long>(allProperties, amount);

	}

	public Tuple<String, Long> listAllProperties() {
		StringBuilder propertesNames = new StringBuilder();

		Long amount = 0L;

		ExtendedIterator<OntProperty> properties = model.listAllOntProperties();

		while (properties.hasNext()) {
			OntProperty ontProperty = properties.next();

			String localName = ontProperty.getLocalName();
			if (localName != null) {
				String propertyName = localName.toString();
				propertesNames.append(propertyName);
				propertesNames.append(", \n");
				amount++;
			}
		}

		String allClasses = StringUtils.removeLastComma(propertesNames);
		return new Tuple<String, Long>(allClasses, amount);
	}

	public String listClassesWithIndividuals() {
		ExtendedIterator<OntClass> classes = model.listClasses();
		StringBuilder result = new StringBuilder();

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();

			String localName = ontClass.getLocalName();
			ExtendedIterator<? extends OntResource> classInstances = ontClass.listInstances();

			if (localName != null && classInstances != null && classInstances.hasNext()) {

				String className = localName.toString();
				result.append(className);
				result.append("\n\t");

				while (classInstances.hasNext()) {
					OntResource instance = classInstances.next();
					result.append(instance.getLocalName());
					result.append("\n");
					if (classInstances.hasNext()) {
						result.append("\t");
					}
				}
			}
		}
		return result.toString();
	}

	// TODO Zrobić rekurencyjne zapytanie dla całego drzewa
	public String listClassesWithSubClasses() {
		ExtendedIterator<OntClass> classes = model.listClasses();

		StringBuilder result = new StringBuilder();

		while (classes.hasNext()) {
			OntClass ontClass = classes.next();

			String localName = ontClass.getLocalName();
			ExtendedIterator<? extends OntResource> subClasses = ontClass.listSubClasses();

			if (localName != null && subClasses != null && subClasses.hasNext()) {

				String className = localName.toString();
				result.append(className);
				result.append("\n\t");

				while (subClasses.hasNext()) {
					OntResource instance = subClasses.next();
					result.append(instance.getLocalName());
					result.append("\n");
					if (subClasses.hasNext()) {
						result.append("\t");
					}
				}
			}
		}
		return result.toString();
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
				System.err.println(ontClass.getLocalName());
			}

			while (subClasses.hasNext()) {
				OntClass nextValue = (OntClass) subClasses.next();
				if (nextValue.hasSubClass()) {
					System.err.print("\t");
					System.err.println(nextValue.getLocalName());
					findChildren(nextValue, indent + 1, false);
				} else {
					for (int i = 0; i < indent; i++) {
						System.err.print("\t");
					}
					System.err.println(nextValue.getLocalName());
				}
			}
		}
	}

	public String listPropertiesWithRangeAndDomain() {
		StringBuilder result = new StringBuilder();
		ExtendedIterator<OntProperty> properties = model.listAllOntProperties();
		OntResource domain;
		OntResource range;

		while (properties.hasNext()) {
			OntProperty property = properties.next();
			domain = property.getDomain();
			range = property.getRange();

			result.append(property.getLocalName());
			if (domain != null) {
				result.append("\n\t");
				result.append("domena : ");
				result.append(domain.getLocalName());
			}
			if (range != null) {
				result.append("\n\t");
				result.append("zakres : ");
				result.append(range.getLocalName());
			}
			result.append("\n");
		}

		return result.toString();
	}

	public String printResult(Tuple<String, Long> result, String kind) {

		return result.getValues() + " Ontologia zawiera " + result.getAmount() + kind;
	}

}
