package lt.techin.api.dto.mapper;

import lt.techin.api.dto.BlogPostDto;
import lt.techin.api.dto.BlogPostEntityDto;
import lt.techin.model.BlogPost;

public class BlogPostMapper {

    public static BlogPostDto toBlogPostDto(BlogPost blogPost) {
        var blogPostDto = new BlogPostDto();

        blogPostDto.setTitle(blogPost.getTitle());
        blogPostDto.setText(blogPost.getText());
        blogPostDto.setCreatedDate(blogPost.getCreatedDate());
        blogPostDto.setComments(blogPost.getComments());

        return blogPostDto;        
    }

    public static BlogPostEntityDto toBlogPostEntityDto(BlogPost blogPost) {
        var blogPostDto = new BlogPostEntityDto();

        blogPostDto.setId(blogPost.getId());
        blogPostDto.setText(blogPost.getText());
        blogPostDto.setCreatedDate(blogPost.getCreatedDate());
        blogPostDto.setComments(blogPost.getComments());

        return blogPostDto;
    }

    public static BlogPost toBlogPost(BlogPostDto blogPostDto) {
        var blogPost = new BlogPost();

        blogPost.setTitle(blogPostDto.getTitle());
        blogPost.setText(blogPostDto.getText());
        blogPost.setCreatedDate(blogPostDto.getCreatedDate());
        blogPost.setComments(blogPostDto.getComments());

        return blogPost;
    }

    public static BlogPost toBlogPostFromEntityDto(BlogPostEntityDto blogPostDto) {
        var blogPost = new BlogPost();

        blogPost.setId(blogPostDto.getId());
        blogPost.setText(blogPostDto.getText());
        blogPost.setCreatedDate(blogPostDto.getCreatedDate());
        blogPost.setComments(blogPostDto.getComments());

        return blogPost;
    }

}
