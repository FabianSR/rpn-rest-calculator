package com.fabian.calculator.util;

import io.corp.calculator.TracerImpl;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoggerTest {


    @Test
    public void constructor_checkAvoidInstance() throws NoSuchMethodException, SecurityException {
        Constructor<Logger> constructor = Logger.class.getDeclaredConstructor(TracerImpl.class);
        assertThat(isPrivate(constructor.getModifiers()), is(true));
    }

}
