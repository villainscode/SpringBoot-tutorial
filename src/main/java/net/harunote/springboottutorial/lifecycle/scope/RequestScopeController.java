package net.harunote.springboottutorial.lifecycle.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request-scope")
public class RequestScopeController {

    private final ObjectProvider<RequestBean> requestBeanProvider;  // 요청마다 새로운 객체가 주입됨

    @GetMapping("/test")
    public String testRequestScope() {
        RequestBean requestBean = requestBeanProvider.getObject();  // 요청이 발생할 때 Bean을 가져옴
        System.out.println("✅ 현재 RequestBean 인스턴스: " + requestBean);
        return "RequestBean이 요청마다 새로 생성됩니다! 로그를 확인하세요.";
    }
}