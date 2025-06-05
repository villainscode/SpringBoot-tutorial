package cc.subnote.springboot.tutorial.ioc;

// SimpleContainer를 통해 객체들이 자동으로 생성되고 연결됨
public class IoCExample {
    public static void main(String[] args) {
        // IoC 컨테이너 생성 -> 내부에서 MessageProvider와 GreetingService를 생성 및 연결
        SimpleContainer container = new SimpleContainer();
        
        // 컨테이너로부터 GreetingService를 조회하여 사용
        GreetingService service = container.getGreetingService();
        service.greet();  // 출력: Hello, World!
    }
}