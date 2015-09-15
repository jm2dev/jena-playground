package com.optimates.jena.rdf;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void example() {
        final String expected = "hola";
        final String actual = "adios";

        assertThat(actual).isEqualTo(expected);
    }
}
