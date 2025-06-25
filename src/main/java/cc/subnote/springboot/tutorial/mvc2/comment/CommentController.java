package cc.subnote.springboot.tutorial.mvc2.comment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/{postId}")
    public String addComment(@PathVariable Long postId,
                             @RequestParam String content) {
        log.info("Adding comment to post with id: " + postId + " and content: " + content);
        Comment comment = new Comment();
        comment.setPostId(postId);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());

        commentService.create(comment);
        return "redirect:/posts/" + postId;
    }


    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Comment comment = commentService.get(id);
        model.addAttribute("comment", comment);
        return "comment/form";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @RequestParam String content) {
        Comment comment = commentService.get(id);
        comment.setContent(content);
        commentService.update(comment);
        return "redirect:/posts/" + comment.getPostId();
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        Comment comment = commentService.get(id);
        Long postId = comment.getPostId();
        commentService.delete(id);
        return "redirect:/posts/" + postId;
    }
}