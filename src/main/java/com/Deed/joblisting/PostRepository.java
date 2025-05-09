package com.Deed.joblisting;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Deed.joblisting.Model.Schema;

public interface PostRepository extends MongoRepository<Schema, ObjectId> {
    // Custom query methods can be defined here if needed
        List<Schema> findByTitleContainingIgnoreCase(String title);
        // List<Schema> findByDescriptionContainingIgnoreCase(String desc);
}



