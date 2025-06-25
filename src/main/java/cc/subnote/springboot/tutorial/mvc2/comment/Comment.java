package cc.subnote.springboot.tutorial.mvc2.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private Long id;
    private Long postId;
    private String content;
    private LocalDateTime createdAt;

    public Comment(Long id, Long postId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
    }
}