package lt.techin.dao;

import lt.techin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
List<Comment> getAllByBlogPost_IdOrderByCreatedDateDesc(Long blogPostId);
}
