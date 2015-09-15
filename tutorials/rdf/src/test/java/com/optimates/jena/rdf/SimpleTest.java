package com.optimates.jena.rdf;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void addPropertyToResource() throws Exception {
        final String personUri = "http://somewhere/JohnSmith";
        final String fullName = "John Smith";

        final Model model = ModelFactory.createDefaultModel();
        final Resource johnSmith = model.createResource(personUri)
                .addProperty(VCARD.FN, fullName);

        assertThat(johnSmith.getURI()).isEqualTo(personUri);
    }

    @Test
    public void addSeveralPropertiesWithCascadingStyle() throws Exception {
        final String personUri = "http://somewhere/JohnSmith";
        final String givenName = "John";
        final String familyName = "Smith";
        final String fullName = givenName + " " + familyName;
        final Model model = ModelFactory.createDefaultModel();
        final Resource johnSmith = model.createResource(personUri)
                .addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N,
                        model.createResource()
                                .addProperty(VCARD.Given, givenName)
                                .addProperty(VCARD.Family, familyName));

        assertThat(johnSmith.getURI()).isEqualTo(personUri);
    }
}