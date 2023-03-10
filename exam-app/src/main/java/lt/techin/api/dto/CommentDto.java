package lt.techin.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class CommentDto {

    private String author;

    private String text;

    private LocalDateTime createdDate;

    public CommentDto() {
        
    }

    public CommentDto(String author, String text, LocalDateTime createdDate) {
        this.author = author;
        this.text = text;
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        return Objects.equals(author, that.author) && Objects.equals(text, that.text) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text, createdDate);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
