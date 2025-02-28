package net.harunote.springboottutorial.ioc;

// IoC 컨테이너 역할을 하는 아주 간단한 클래스
public class SimpleContainer {
    // 컨테이너 내부에 객체를 보관
    private MessageProvider messageProvider;
    private GreetingService greetingService;

    public SimpleContainer() {
        // 먼저 MessageProvider 객체를 생성
        // messageProvider = new MessageProvider();
        messageProvider = new CustomMessageProvider();
        // 그리고 생성된 MessageProvider를 주입하여 GreetingService 객체를 생성
        greetingService = new GreetingService(messageProvider);
    }


    // 외부에서 GreetingService 객체를 사용할 수 있도록 제공
    public GreetingService getGreetingService() {
        return greetingService;
    }
}