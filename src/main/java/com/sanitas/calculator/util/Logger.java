package com.sanitas.calculator.util;

import io.corp.calculator.TracerImpl;

/**
 * Singleton pattern
 * @autor FabianSR
 */
public final class Logger {

    private static Logger logger;
    private TracerImpl tracer;

    private Logger(TracerImpl tracer) {
        this.tracer = tracer;
    }

    public static TracerImpl getTracerInstance() {
        if (logger == null) buildIntance();
        return logger.tracer;
    }

    private synchronized static void buildIntance() {
        if (logger == null) logger = new Logger(new TracerImpl());
    }

}
