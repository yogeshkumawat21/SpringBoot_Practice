package com.Main.repository;

import com.Main.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry , ObjectId> {

}

// controller call krega service ko ----- service call krega repository ko ------