package cc.subnote.springboot.tutorial;

import cc.subnote.springboot.tutorial.scope.PrototypeBean;
import cc.subnote.springboot.tutorial.scope.SingletonBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootTutorialApplication implements CommandLineRunner {

    private final ApplicationContext context;

    public SpringBootTutorialApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Singleton Test ===");
        SingletonBean singleton1 = context.getBean(SingletonBean.class);
        SingletonBean singleton2 = context.getBean(SingletonBean.class);
        System.out.println("singleton1 == singleton2 ? " + (singleton1 == singleton2)); // true

        System.out.println("\n=== Prototype Test ===");
        PrototypeBean prototype1 = context.getBean(PrototypeBean.class);
        PrototypeBean prototype2 = context.getBean(PrototypeBean.class);
        System.out.println("prototype1 == prototype2 ? " + (prototype1 == prototype2)); // false
    }
}
