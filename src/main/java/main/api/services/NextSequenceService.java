package main.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NextSequenceService {
    @Autowired
    private MongoOperations mongo;

    public long getNextSequence(String sequenceName)
    {
        SequenceForProducts counter;
        counter = mongo.findAndModify(
                Query.query(Criteria.where("long_id").is(sequenceName)),
                new Update().inc("seq",1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                SequenceForProducts.class);
        assert counter != null;
        return counter.getSeq();
    }
}
