package cc.subnote.springboot.tutorial.beans;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lifecycle")
public class LifecycleController {
    private final LifecycleBean lifecycleBean;

    @GetMapping("/test")
    public String testLifecycle() {
        lifecycleBean.doWork();
        return "LifecycleBean의 doWork() 실행 완료!";
    }
}