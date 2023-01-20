package lt.techin.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class CommentDto {

    private String author;

    private String aComment;

    private LocalDateTime createdDate;

    public CommentDto() {
        
    }

    public CommentDto(String author, String aComment, LocalDateTime createdDate) {
        this.author = author;
        this.aComment = aComment;
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return aComment;
    }

    public void setComment(String aComment) {
        this.aComment = aComment;
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
        return Objects.equals(author, that.author) && Objects.equals(aComment, that.aComment) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, aComment, createdDate);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", comment='" + aComment + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
