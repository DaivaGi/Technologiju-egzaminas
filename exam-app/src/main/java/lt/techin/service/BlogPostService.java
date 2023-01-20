package lt.techin.service;

import lt.techin.dao.BlogPostRepository;
import lt.techin.dao.CommentRepository;
import lt.techin.exception.BloggingValidationException;
import lt.techin.model.BlogPost;
import lt.techin.model.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;
    private final List<Comment> comments;

    public BlogPostService(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
        comments = new ArrayList<>();
    }

    public List<BlogPost> getAll() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost create(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }


}


