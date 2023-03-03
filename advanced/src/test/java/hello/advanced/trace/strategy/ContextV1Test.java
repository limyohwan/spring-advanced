package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0(){
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

    @Test
    void startegyV1(){
        ContextV1 contextV1 = new ContextV1(new StrategyLogic1());
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new StrategyLogic2());
        contextV2.execute();
    }

    @Test
    void startegyV2(){
        Strategy strategy = new Strategy() {
            @Override
            public void call(){
                log.info("비지니스로직 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();
    }

    @Test
    void startegyV3(){
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call(){
                log.info("비지니스로직 실행");
            }
        });
        contextV1.execute();
    }

    @Test
    void startegyV4(){
        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스로직 실행"));
        contextV1.execute();
    }
}
