package cc.subnote.springboot.tutorial.cp3;

class PaymentService {
    public String pay(int amount) {
        return "결제 완료: " + amount + "원";
    }
}