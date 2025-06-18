package cc.subnote.springboot.tutorial.cp3.config;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentService paymentService;    // 의존성을 외부에서 주입받도록 변경

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String processOrder(int amount) {
        return paymentService.pay(amount);
    }
}