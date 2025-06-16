package cc.subnote.springboot.tutorial.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // 생략해도 기본값
public class SingletonBean {
    public SingletonBean() {
        System.out.println("✅ SingletonBean 생성됨: " + this);
    }
}