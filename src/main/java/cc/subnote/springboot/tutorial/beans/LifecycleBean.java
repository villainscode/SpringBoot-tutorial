package cc.subnote.springboot.tutorial.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {
    // 1. 빈 생성자 호출
    public LifecycleBean() {
        System.out.println("1. Bean 생성자 호출");
    }

    // 2. 객체가 생성된 후 초기화 작업을 수행
    @PostConstruct
    public void init() {
        System.out.println("2. @PostConstruct - 초기화 작업 수행");
    }


    // 3. 실제 Bean이 사용되는 단계
    public void doWork() {
        System.out.println("3. Bean 사용 중...");
    }

    // 4. 애플리케이션이 종료되기 전 정리 작업
    @PreDestroy
    public void destroy() {
        System.out.println("4. @PreDestroy - 소멸 작업 수행");
    }
}