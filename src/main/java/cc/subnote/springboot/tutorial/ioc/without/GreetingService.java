package cc.subnote.springboot.tutorial.ioc.without;

// 내부에서 직접 MessageProvider를 생성하여 인사말 출력 메서드를 호출
public class GreetingService {
    // 직접 MessageProvider를 생성 (강한 결합)
    private MessageProvider messageProvider = new MessageProvider();

    public void greet() {
        System.out.println(messageProvider.getMessage());
    }
}