package hello.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;

public class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_trace(){
        TraceStatus status1 = trace.begin("hellp1");
        TraceStatus status2 = trace.begin("hellp1");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_trace(){
        TraceStatus status1 = trace.begin("hellp1");
        TraceStatus status2 = trace.begin("hellp1");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}
