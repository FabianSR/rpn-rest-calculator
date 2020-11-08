package com.sanitas.calculator.util;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConstantsTest {

    @Test
    public void constructor_checkAvoidInstance() throws NoSuchMethodException, SecurityException {
        Constructor<Constants> constructor = Constants.class.getDeclaredConstructor();
        assertThat(isPrivate(constructor.getModifiers()), is(true));
    }
}
