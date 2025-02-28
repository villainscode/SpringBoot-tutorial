package net.harunote.springboottutorial.ioc.without;

// 실행 예제
public class TraditionalExample {
    public static void main(String[] args) {
        GreetingService service = new GreetingService();
        service.greet();  // 출력: Hello, World!
    }
}