package main.api.repo;

import main.api.entitys.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends MongoRepository<List, Long> {
}
