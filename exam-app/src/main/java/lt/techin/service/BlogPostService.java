package lt.techin.service;

import lt.techin.dao.BlogPostRepository;
import lt.techin.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public boolean blogPostTitleIsUnique(BlogPost blogPost) {
        return blogPostRepository.findAll()
                .stream()
                .noneMatch(bp -> bp.getTitle().equals(blogPost.getTitle()));
    }
    public List<BlogPost> getAll() {
        return blogPostRepository.findAllByOrderByCreatedDateDesc();
    }

    public Optional<BlogPost> getById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost create(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

}


