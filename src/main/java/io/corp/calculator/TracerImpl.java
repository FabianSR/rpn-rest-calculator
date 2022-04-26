package io.corp.calculator;


/**
 * Implementación por defecto de {@link TracerAPI} - no es especialmente brillante, pero para la realización de la POC es más que de sobra.
 * @author Sanitas
 */
public class TracerImpl  {

    /**
     * {@inheritDoc}
     */
    public <T> void trace( final T result ) {
        System.out.println( "result :: " + result.toString() );
    }

}
