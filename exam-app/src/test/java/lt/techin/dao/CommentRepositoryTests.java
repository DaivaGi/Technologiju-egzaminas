package lt.techin.dao;

import lt.techin.api.dto.BlogPostDto;
import lt.techin.model.BlogPost;
import lt.techin.model.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static lt.techin.api.dto.mapper.BlogPostMapper.toBlogPost;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CommentRepositoryTests {


    private CommentRepository commentRepository;
    private BlogPostRepository blogPostRepository;

    @Autowired

    public CommentRepositoryTests(CommentRepository commentRepository, BlogPostRepository blogPostRepository) {
        this.commentRepository = commentRepository;
        this.blogPostRepository = blogPostRepository;
    }

    @Test
    public void CommentRepository_SaveAll_ReturnsSavedComment(){

        Comment comment = new Comment();
        comment.setAuthor("authorTest");
        comment.setText("textTest");

        Comment savedComment = commentRepository.save(comment);

        Assertions.assertThat(savedComment).isNotNull();
        Assertions.assertThat(savedComment.getId()).isGreaterThan(0);

    }

    @Test
    public void CommentRepository_GetAll_ReturnsMoreThanOnePokemon(){

        Comment comment = new Comment();
        comment.setAuthor("testAuthor");
        comment.setText("testText");

        Comment comment1 = new Comment();
        comment1.setAuthor("testAuthor1");
        comment1.setText("testText");


        commentRepository.save(comment);
        commentRepository.save(comment1);

        List<Comment> commentsList = commentRepository.findAll();

        Assertions.assertThat(commentsList).isNotNull();
        Assertions.assertThat(commentsList.size()).isGreaterThan(2);
    }

    @Test
    public void CommentRepository_FindById_ReturnsComment(){

        Comment comment = new Comment();
        comment.setAuthor("testAuthor");
        comment.setText("testText");

        commentRepository.save(comment);


       Comment commentById = commentRepository.findById(comment.getId()).get();

        Assertions.assertThat(commentById).isNotNull();
    }

    @Test
    public void CommentRepository_GetAllByBlogPost_IdOrderByCreatedDateDesc_ReturnsCommentNotNull(){

        Comment comment = new Comment();
        comment.setAuthor("testAuthor");
        comment.setText("testText");

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("testTitle");
        blogPostRepository.save(blogPost);
        comment.setBlogPost(blogPost);

        commentRepository.save(comment);

        List<Comment> commentList = commentRepository.getAllByBlogPost_IdOrderByCreatedDateDesc(blogPost.getId());

        Assertions.assertThat(commentList).isNotNull();
    }

}
