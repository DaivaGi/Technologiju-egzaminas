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

    public BlogPost addCommentToBlogPost(Long blogPostId, Long commentId) {
        var existingBlogPost = blogPostRepository.findById(blogPostId)
                .orElseThrow(() -> new BloggingValidationException("BlogPost does not exist",
                        "id", "BlogPost not found", blogPostId.toString()));

        var existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BloggingValidationException("Comment does not exist",
                        "id", "Comment not found", commentId.toString()));

        comments.add(existingComment);
        existingBlogPost.setComments(comments);

        return blogPostRepository.save(existingBlogPost);

    }
}

