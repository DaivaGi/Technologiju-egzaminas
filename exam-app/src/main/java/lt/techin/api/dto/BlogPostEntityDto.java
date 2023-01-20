package lt.techin.api.dto;

import lt.techin.model.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class BlogPostEntityDto extends BlogPostDto {

    private Long id;

    public BlogPostEntityDto() {
    }
    public BlogPostEntityDto(String title, String text, List<Comment> comments, LocalDateTime createdDate, Long id) {
        super(title, text, comments, createdDate);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BlogPostEntityDto that = (BlogPostEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "BlogPostEntityDto{" +
                "id=" + id +
                '}';
    }
}
