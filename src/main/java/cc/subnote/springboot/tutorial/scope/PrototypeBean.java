package cc.subnote.springboot.tutorial.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("🔄 PrototypeBean 생성됨: " + this);
    }
}