package cc.subnote.springboot.tutorial.ioc;

// MessageProvider를 상속받아 메시지만 다르게 제공
public class CustomMessageProvider extends MessageProvider {
    @Override
    public String getMessage() {
        return "안녕하세요, IoC";
    }
}