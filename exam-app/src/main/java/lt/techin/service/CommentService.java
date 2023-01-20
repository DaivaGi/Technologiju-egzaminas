package lt.techin.service;

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
public class CommentService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;

    public CommentService(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll() {
        return animalRepository.findAll();
    }

    public Optional<Comment> getById(Long id) {
        return animalRepository.findById(id);
    }


    public Comment create(Comment animal) {
        return animalRepository.save(animal);
    }


    public Comment addCommentToBlogPost(Long animalId, Long roomId) {
        // - find animal
        var existingAnimal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ZooValidationException("Animal does not exist",
                        "id", "Animal not found", animalId.toString()));

        // - find room
        var existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new ZooValidationException("Room does not exist",
                        "id", "Room not found", roomId.toString()));

        // - if OK - set
        existingAnimal.setRoom(existingRoom);

        //TODO check this hack :)
//        var dummyRoom = new Room();
//        dummyRoom.setId(roomId);
//        existingAnimal.setRoom(dummyRoom);

        // - save
        return animalRepository.save(existingAnimal);
    }

//    @PostConstruct
//    //FIXME for dev purpose
//    public void loadInitialAnimals() {
//        var initialAnimalsToAdd = List.of(
//                new AnimalDto("zirafa", GIRAFFE, ""),
//                new AnimalDto("tigriukas", TIGER, ""),
//                new AnimalDto("liutukas", LION, null)
//        );
//
//
//        initialAnimalsToAdd.stream()
//                .map(AnimalMapper::toAnimal)
//                .forEach(animalRepository::save);
//
//        var registeredParrot = new AnimalDto("registruotas zveris", PARROT, null);
//        var parrotEntity = toAnimal(registeredParrot);
//        parrotEntity.setRegistered(true);
//        animalRepository.save(parrotEntity);
//    }


}
