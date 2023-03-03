package hello.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;

public class HelloTraceV1Test {

    @Test
    void begin_end(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hell0");
        trace.end(status);
    }

    @Test
    void begin_exeption(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hell0");
        trace.exception(status, new IllegalStateException("exception"));
    }
}
