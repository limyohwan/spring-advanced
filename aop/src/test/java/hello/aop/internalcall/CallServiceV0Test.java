package hello.aop.internalcall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;

@Import(CallLogAspect.class)
@Slf4j
@SpringBootTest
public class CallServiceV0Test {
    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void testExternal() {
        // log.info("target ={}",callServiceV0.getClass());
        callServiceV0.external();
    }

    @Test
    void testInternal() {
        callServiceV0.internal();
    }
}
