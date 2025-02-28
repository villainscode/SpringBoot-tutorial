package net.harunote.springboottutorial.lifecycle.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SingletonScopeReferenceCompare {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SingletonScopeReferenceCompare.class);
        SingletonBean bean1 = context.getBean(SingletonBean.class);
        System.out.println("bean1 = " + bean1);
        SingletonBean bean2 = context.getBean(SingletonBean.class);
        System.out.println("bean2 = " + bean2);
        System.out.println(bean1.equals(bean2));
    }
}


