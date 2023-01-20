package lt.techin.service;

import lt.techin.model.BlogPost;
import lt.techin.zoo.dao.AnimalRepository;
import lt.techin.zoo.dao.RoomRepository;
import lt.techin.zoo.exception.ZooValidationException;
import lt.techin.zoo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static lt.techin.zoo.model.AnimalType.*;

@Service
public class BlogPostService {

    private final BlogPostService blogPostRepository;

    public BlogPostService(BlogPostService blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPost> getAll() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost create(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

//TO FIX
//    public List<Comment> getAllComments { return blogPostRepository.getAll();}

}
