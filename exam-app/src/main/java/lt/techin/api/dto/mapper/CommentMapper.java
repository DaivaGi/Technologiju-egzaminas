package lt.techin.api.dto.mapper;

import lt.techin.api.dto.CommentDto;
import lt.techin.api.dto.CommentEntityDto;
import lt.techin.model.Comment;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        var commentDto = new CommentDto();

        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());
        commentDto.setCreatedDate(comment.getCreatedDate());


        return commentDto;
    }

    public static CommentEntityDto toCommentEntityDto(Comment comment) {
        var commentDto = new CommentEntityDto();

        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());
        commentDto.setCreatedDate(comment.getCreatedDate());

        return commentDto;
    }

    public static Comment toComment(CommentDto commentDto) {
        var comment = new Comment();

        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());
        comment.setCreatedDate(commentDto.getCreatedDate());


        return comment;
    }

    public static Comment toCommentFromEntityDto(CommentEntityDto commentDto) {
        var comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());
        comment.setCreatedDate(commentDto.getCreatedDate());

        return comment;
    }

}
