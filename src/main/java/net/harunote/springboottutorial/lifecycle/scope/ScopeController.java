package net.harunote.springboottutorial.lifecycle.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scope")
public class ScopeController {
    private final SingletonBean singletonBean;
    private final ObjectProvider<PrototypeBean> prototypeBeanProvider; // PrototypeBean을 요청할 때 생성


    @GetMapping("/test")
    public String testScope() {
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject();  // 요청할 때마다 새로운 객체 생성
        System.out.println("[v] SingletonBean: " + singletonBean);
        System.out.println("[v] PrototypeBean: " + prototypeBean);
        return "로그 확인!!";
    }
}