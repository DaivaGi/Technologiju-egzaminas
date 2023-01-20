package lt.techin.service;

import lt.techin.dao.BlogPostRepository;
import lt.techin.dao.CommentRepository;
import lt.techin.exception.BloggingValidationException;
import lt.techin.model.BlogPost;
import lt.techin.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;

    public CommentService(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }


    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public BlogPost addCommentToBlogPost(Long blogPostId, Long commentId) {
        var existingBlogPost = blogPostRepository.findById(blogPostId)
                .orElseThrow(() -> new BloggingValidationException("BlogPost does not exist",
                        "id", "BlogPost not found", blogPostId.toString()));

        var existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BloggingValidationException("Comment does not exist",
                        "id", "Comment not found", commentId.toString()));

        existingComment.setBlogPost(existingBlogPost);

        return blogPostRepository.save(existingBlogPost);

    }
}
