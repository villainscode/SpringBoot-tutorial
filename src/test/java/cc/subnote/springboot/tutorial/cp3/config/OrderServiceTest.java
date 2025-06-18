package cc.subnote.springboot.tutorial.cp3.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    @Test
    void testProcessOrder() {        // 가짜(Mock) PaymentService를 생성하여 주입
        PaymentService mockPaymentService = new PaymentService() {
            @Override
            public String pay(int amount) {
                return "Mock 결제 완료: " + amount + "원";
            }
        };        // OrderService는 가짜 PaymentService를 사용

        OrderService orderService = new OrderService(mockPaymentService);        // 테스트 검증
        assertEquals("Mock 결제 완료: 1000원", orderService.processOrder(1000));
    }
}