package org.pwr.molczak.semanticWeb.jena;

import java.io.InputStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.JenaException;
import org.pwr.molczak.semanticWeb.utils.FileUtils;

public class RunJena {

	private OntModel model;

	public RunJena() {
		init();

	}

	private void init() {
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
	}

	public OntModel getModel() {
		try {
			InputStream file = FileUtils.readOwlFile();
			try {
				model.read(file, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (JenaException exception) {
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}

		return model;
	}

}
