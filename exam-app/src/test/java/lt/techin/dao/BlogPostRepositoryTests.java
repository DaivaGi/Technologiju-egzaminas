package lt.techin.dao;

import lt.techin.api.dto.BlogPostDto;
import lt.techin.model.BlogPost;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BlogPostRepositoryTests {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    public void BlogPostRepository_SaveAll_ReturnsSavedBlogPost(){

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("testTitle");
        blogPost.setText("testText");

        BlogPost savedBlogPost = blogPostRepository.save(blogPost);

        Assertions.assertThat(savedBlogPost).isNotNull();
        Assertions.assertThat(savedBlogPost.getId()).isGreaterThan(0);

    }

    @Test
    public void BlogPostRepository_GetAll_ReturnsMoreThanOnePokemon(){

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("testTitle");
        blogPost.setText("testText");

        BlogPost blogPost1 = new BlogPost();
        blogPost1.setTitle("testTitle1");
        blogPost1.setText("testText");


        blogPostRepository.save(blogPost);
        blogPostRepository.save(blogPost1);

        List<BlogPost> blogPostList = blogPostRepository.findAll();

        Assertions.assertThat(blogPostList).isNotNull();
        Assertions.assertThat(blogPostList.size()).isGreaterThan(2);
    }

    @Test
    public void BlogPostRepository_FindById_ReturnsBlogPost(){

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("testTitle");
        blogPost.setText("testText");


        blogPostRepository.save(blogPost);


        BlogPost blogPostById = blogPostRepository.findById(blogPost.getId()).get();

        Assertions.assertThat(blogPostById).isNotNull();

    }

    @Test
    public void BlogPostRepository_findAllByOrderByCreatedDateDesc_ReturnsBlogPost(){

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("testTitle");
        blogPost.setText("testText");


        blogPostRepository.save(blogPost);


        List<BlogPost> blogPostList = blogPostRepository.findAllByOrderByCreatedDateDesc();

        Assertions.assertThat(blogPostList).isNotNull();

    }
}
