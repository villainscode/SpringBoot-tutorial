package net.harunote.springboottutorial.lifecycle.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST)  // HTTP 요청마다 새로운 객체 생성
public class RequestBean {
    public RequestBean() {
        System.out.println("RequestBean 생성");
    }
}