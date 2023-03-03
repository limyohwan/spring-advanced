package hello.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;


public class HelloTraceV2Test {

    @Test
    void begin_end(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hell01");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hell02");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exeption(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hell01");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hell02");        
        trace.exception(status2, new IllegalStateException("exception"));
        trace.exception(status1, new IllegalStateException("exception"));
    }
}
