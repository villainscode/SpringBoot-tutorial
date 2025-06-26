package cc.subnote.springboot.tutorial.jpa.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TagDTO {
    public TagDTO(Long tagId, String myTagName, boolean deleted) {
        this.tagId = tagId;
        this.myTagName = myTagName;
        this.deleted = deleted;
    }

    private Long tagId;
    private String myTagName;
    private boolean deleted;
}