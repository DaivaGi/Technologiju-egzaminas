package lt.techin.service;

import lt.techin.api.dto.BlogPostDto;
import lt.techin.dao.BlogPostRepository;
import lt.techin.model.BlogPost;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogPostServiceTests {

    @Mock
    private BlogPostRepository blogPostRepository;

    @InjectMocks
    private BlogPostService blogPostService;

//    @Test
//    public void BlogPostService_CreateBlogPost_ReturnsBlogPostDto(){
//        BlogPost blogPost = new BlogPost();
//        blogPost.setTitle("testTitle");
//        blogPost.setText("testText");
//
//        BlogPost blogPost1 = new BlogPost();
//        blogPost1.setId(10l);
//        blogPost1.setTitle("testTitle1");
//        blogPost1.setText("testText");
//
//        when(blogPostRepository.save(Mockito.any(BlogPost.class))).thenReturn(blogPost);
//
//        BlogPost savedBlogPost = blogPostService.create(blogPost1);
//
//        Assertions.assertThat(savedBlogPost).isNotNull();
//    }

}
