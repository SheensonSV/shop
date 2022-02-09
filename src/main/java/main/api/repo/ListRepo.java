package main.api.repo;

import main.api.entitys.List;
import main.api.entitys.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends MongoRepository<List, Long> {
    @Query("{ 'long_id' : ?0 }")
    java.util.List<List> findByLongId(long id);
}
