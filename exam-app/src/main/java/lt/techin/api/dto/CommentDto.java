package lt.techin.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class CommentDto {

    private String author;

    private String comment;

    private LocalDateTime createdDate;

    public CommentDto() {
    }

    public CommentDto(String author, String comment, LocalDateTime createdDate) {
        this.author = author;
        this.comment = comment;
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(author, that.author) && Objects.equals(comment, that.comment) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, comment, createdDate);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
