package net.harunote.springboottutorial.lifecycle.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PrototypeScopeReferenceCompare {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                PrototypeScopeReferenceCompare.class);

        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        System.out.println("bean1 = " + bean1);
        PrototypeBean bean2 = context.getBean(PrototypeBean.class);
        System.out.println("bean2 = " + bean2);
        System.out.println(bean1.equals(bean2));
    }
}