package lt.techin.service;

import lt.techin.api.dto.BlogPostDto;
import lt.techin.dao.BlogPostRepository;
import lt.techin.exception.BloggingValidationException;
import lt.techin.model.BlogPost;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final Validator validator;

    public BlogPostService(BlogPostRepository blogPostRepository, Validator validator) {
        this.blogPostRepository = blogPostRepository;
        this.validator = validator;
    }

    void validateInputWithInjectedValidator(BlogPost blogPost) {
        Set<ConstraintViolation<BlogPost>> violations = validator.validate(blogPost);
        if (!violations.isEmpty()) {
            throw new BloggingValidationException(violations.toString(), "Blog Post", "Error in Blog Post entity", blogPost.toString());
        }
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
        validateInputWithInjectedValidator(blogPost);
        return blogPostRepository.save(blogPost);
    }

}


