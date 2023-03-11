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
public class CommentService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;

    private final List<Comment> commentsInPost;

    public CommentService(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
        this.commentsInPost = new ArrayList<>();
    }

    public List<Comment> getAll(Long blogPostId) {
        return commentRepository.getAllByBlogPost_IdOrderByCreatedDateDesc(blogPostId);
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }


    public Comment create(Comment comment, Long blogPostId) {
        var existingBlogPost = blogPostRepository.findById(blogPostId)
                .orElseThrow(() -> new BloggingValidationException("BlogPost does not exist",
                        "id", "BlogPost not found", blogPostId.toString()));
        comment.setBlogPost(existingBlogPost);

        return commentRepository.save(comment);
    }


}
