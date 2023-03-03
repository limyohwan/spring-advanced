package hello.aop.internalcall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;

@Import(CallLogAspect.class)
@Slf4j
@SpringBootTest(properties = "spring.main.allow-circular-references=true")
public class CallServiceV3Test {
    @Autowired
    CallServiceV3 callService;

    @Test
    void testExternal() {
        // log.info("target ={}",callServiceV0.getClass());
        callService.external();
    }


}
