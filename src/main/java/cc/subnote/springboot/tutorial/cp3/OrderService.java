package cc.subnote.springboot.tutorial.cp3;

public class OrderService {
    private final PaymentService paymentService = new PaymentService();

    public String processOrder(int amount) {
        return paymentService.pay(amount);
    }
}