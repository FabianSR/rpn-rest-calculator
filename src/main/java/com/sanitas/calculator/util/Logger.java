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

    public static Logger getLoggerInstance() {
        if (logger == null) buildIntance();
        return logger;
    }

    private synchronized static void buildIntance() {
        if (logger == null) logger = new Logger(new TracerImpl());
    }

    public TracerImpl getTracer() { return tracer; }
}
