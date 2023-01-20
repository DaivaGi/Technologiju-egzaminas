package lt.techin.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Blog_post_id")
        private BlogPost blogPost;

        private String aComment;

        @CreatedDate
        private LocalDateTime createdDate;

        @PrePersist
        public void prePersist() {
            createdDate = LocalDateTime.now();
        }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment that = (Comment) o;
        return Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(aComment, that.aComment) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, aComment, createdDate);
    }
}
