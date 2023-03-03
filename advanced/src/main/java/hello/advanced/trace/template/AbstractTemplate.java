package hello.advanced.trace.template;

import org.springframework.web.bind.annotation.RequestMapping;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {
    private final LogTrace trace;

    public T excute(String message){
        TraceStatus status = null;
        try{
            status = trace.begin(message);

            T result = call();

            trace.end(status);
            return result;
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();

}
