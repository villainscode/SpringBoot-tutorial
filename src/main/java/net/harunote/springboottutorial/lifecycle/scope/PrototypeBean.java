package net.harunote.springboottutorial.lifecycle.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 요청할 때마다 새로운 객체 생성
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("PrototypeBean 인스턴스 생성됨!");
    }
}