package main.api.repo;

import main.api.entitys.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, Long> {
    @Query("{ 'name' : ?0 }")
    List<Product> findProductByName(String name);

    @Query("{ 'long_id' : ?0 }")
    List<Product> findByLongId(long id);

//    @Override
//    @Query("{ '_id' : ?0 }")
//    Optional<Product> findById(Long aLong);
}
