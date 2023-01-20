package lt.techin.api.dto;

import lt.techin.model.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class BlogPostDto {

    private String title;

    private String text;

    private LocalDateTime createdDate;
    private List<Comment> comments;

    public BlogPostDto() {
    }

    public BlogPostDto(String title, String text, List<Comment> comments, LocalDateTime createdDate) {
        this.title = title;
        this.text = text;
        this.comments = comments;
        this.createdDate = createdDate;
    }

    public BlogPostDto(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPostDto that = (BlogPostDto) o;
        return Objects.equals(title, that.title) && Objects.equals(text, that.text) && Objects.equals(createdDate, that.createdDate) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, createdDate, comments);
    }

    @Override
    public String toString() {
        return "BlogPostDto{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", comments=" + comments +
                '}';
    }
}
