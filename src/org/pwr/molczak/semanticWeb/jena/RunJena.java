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

		try {
			InputStream file = FileUtils.readOwlFile();
			model.read(file, null);
		} catch (JenaException exception) {
			exception.printStackTrace();
		}

	}

	public OntModel getModel() {
		return model;
	}

}
