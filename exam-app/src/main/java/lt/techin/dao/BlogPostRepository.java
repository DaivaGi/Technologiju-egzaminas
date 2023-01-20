package lt.techin.dao;

import lt.techin.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

//    @Query(value = "SELECT a FROM Animal a WHERE a.status = 1",
//            nativeQuery = true)
//    List<Animal> findAllMarkedAnimals();
//
//
//    @Modifying
//    @Query("delete Animal a where (a.registered IS NULL or a.registered = false)")
//    //The @Modifying annotation is used to enhance the @Query annotation so
//        // that we can execute not only SELECT queries, but also INSERT, UPDATE, DELETE, and even DDL queries.
//    int deleteNonRegisteredAnimals();


//    @Query(
//            value = "SELECT * FROM animal a WHERE a.status = 1",
//            nativeQuery = true)
//    Collection<Animal> findAllActiveAnimalNative();
    //native query nebegaletume paduoti "sort"

    //findAll(Sort.by(Sort.Direction.ASC, "name"));
    //findAll(Sort.by("LENGTH(name)"));

//    @Query(value = "SELECT a FROM animal a")
//    List<Animal> findAllAnimals(Sort sort);

}
