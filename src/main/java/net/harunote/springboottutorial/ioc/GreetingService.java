package net.harunote.springboottutorial.ioc;

// 생성자를 통해 외부에서 MessageProvider를 주입받음
public class GreetingService {
    private MessageProvider messageProvider;

    // 생성자 주입
    public GreetingService(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void greet() {
        System.out.println(messageProvider.getMessage());
    }
}