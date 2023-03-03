package hello.advanced.trace.template;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {
    
    @Test
    void templateMethodVO(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        log.info("비지니스로직 1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        log.info("비지니스로직 2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    @Test
    void templateMethodV1(){
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2(){
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call(){
                log.info("비지니스 로직 1 실행");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call(){
                log.info("비지니스 로직 2 실행");
            }
        };

        template2.execute();

    }
}
