package org.pwr.molczak.semanticWeb.jena;

import java.io.InputStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.JenaException;
import org.apache.jena.util.FileManager;

public class ModelCreator {

	private OntModel ontModel;

	public ModelCreator() {
		ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

		try {
			InputStream inputStream = FileManager.get().open("/home/booob/Pobrane/gra_export.rdf");

			try {
				ontModel.read(inputStream, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (JenaException e) {
			e.printStackTrace();
		}
	}

	public OntModel getModel() {
		return ontModel;
	}

}
