package cc.subnote.springboot.tutorial.jpa.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CodeVillains
 */
@Setter
@Getter
public class TagRequest {
    Long id;
    String tagName;

    boolean deleted;
}