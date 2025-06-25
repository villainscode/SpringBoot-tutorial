package cc.subnote.springboot.tutorial.mvc1;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Hello {
    private final long id;
    private final String content;

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }
}