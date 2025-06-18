package cc.subnote.springboot.tutorial.cp3.config;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String pay(int amount) {
        return "결제 완료: " + amount + "원";
    }
}
