package lt.techin.api;

import lt.techin.api.dto.CommentDto;
import lt.techin.api.dto.CommentEntityDto;
import lt.techin.api.dto.mapper.CommentMapper;
import lt.techin.model.BlogPost;
import lt.techin.model.Comment;
import lt.techin.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.api.dto.mapper.CommentMapper.toComment;
import static lt.techin.api.dto.mapper.CommentMapper.toCommentDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/comments")
public class CommentController {

    public static Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/all/{blogPostId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<CommentEntityDto> getComments(@PathVariable Long blogPostId) {
        return commentService.getAll(blogPostId).stream()
                .map(CommentMapper::toCommentEntityDto)
                .collect(toList());
    }

    @GetMapping(value = "/{commentId}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        var commentOptional = commentService.getById(commentId);

        var responseEntity = commentOptional
                .map(comment -> ok(comment))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value = "/{blogPostId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Long blogPostId) {
        var createdComment = commentService.create(toComment(commentDto), blogPostId);

        return ok(toCommentDto(createdComment));
    }


}
