package com.sanitas.calculator.util;

import io.corp.calculator.TracerImpl;

/**
 * Singleton pattern
 * It does not prevent the instantiation of TracerImpl but implements a single object (Logger)
 * to access a single instance of the tracer
 * @autor FabianSR
 */
public final class Logger {

    private static Logger logger;
    private TracerImpl tracer;

    private Logger(TracerImpl tracer) {
        this.tracer = tracer;
    }

    public static Logger getLoggerInstance() {
        if (logger == null) buildInstance();
        return logger;
    }

    private synchronized static void buildInstance() {
        if (logger == null) logger = new Logger(new TracerImpl());
    }

    public TracerImpl getTracer() { return tracer; }
}
