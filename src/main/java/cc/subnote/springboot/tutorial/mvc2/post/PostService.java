package cc.subnote.springboot.tutorial.mvc2.post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> list(int page, int size) {
        return postRepository.findAll(page, size);
    }

    public void create(Post post) {
        postRepository.save(post);
    }

    public Post get(Long id) {
        return postRepository.findById(id);
    }

    public void update(Post post) {
        postRepository.update(post);
    }

    public void delete(Long id) {
        postRepository.delete(id);
    }

    public int count() {
        return postRepository.count();
    }

}