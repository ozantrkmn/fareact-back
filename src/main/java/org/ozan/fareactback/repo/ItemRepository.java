package org.ozan.libprov2.repo;

import org.bson.types.ObjectId;
import org.ozan.libprov2.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>{

	Item findBy_id(ObjectId _id);
	
}
