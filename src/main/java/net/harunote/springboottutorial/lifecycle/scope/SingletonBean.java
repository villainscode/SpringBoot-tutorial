package net.harunote.springboottutorial.lifecycle.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // (기본값) 애플리케이션에서 하나만 생성됨
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean 인스턴스 생성됨!");
    }
}