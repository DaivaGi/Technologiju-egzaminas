package lt.techin.api;


import lt.techin.api.dto.BlogPostDto;
import lt.techin.api.dto.BlogPostEntityDto;
import lt.techin.api.dto.mapper.BlogPostMapper;
import lt.techin.model.BlogPost;
import lt.techin.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.api.dto.mapper.BlogPostMapper.toBlogPost;
import static lt.techin.api.dto.mapper.BlogPostMapper.toBlogPostDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/blogposts")
public class BlogPostController {

    public static Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<BlogPostEntityDto> getBlogPosts() {
        return blogPostService.getAll().stream()
                .map(BlogPostMapper::toBlogPostEntityDto)
                .collect(toList());
    }


    @GetMapping(value = "/{blogPostId}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<BlogPost> getBlogPost(@PathVariable Long blogPostId) {
        var blogPostOptional = blogPostService.getById(blogPostId);

        var responseEntity = blogPostOptional
                .map(blogPost -> ok(blogPost))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }



    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BlogPostDto> createBlogPost(@RequestBody BlogPostDto blogPostDto) {
        var createdBlogPost = blogPostService.create(toBlogPost(blogPostDto));

        return ok(toBlogPostDto(createdBlogPost));
    }

//    @PostMapping("/{blogpostId}/addcomment")
//    @ResponseBody
//    public BlogPost addCommentToBlogPost(@PathVariable Long blogpostId, @RequestParam Long commentId) {
//        return blogPostService.addCommentToBlogPost(blogpostId, commentId );
//    }



}
