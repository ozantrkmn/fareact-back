package org.ozan.fareactback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import javax.validation.Valid;
import java.util.List;

import org.bson.types.ObjectId;
import org.ozan.fareactback.models.Item;
import org.ozan.fareactback.repo.ItemRepository;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://192.168.0.15:3000" })
@RestController
@RequestMapping("/items")
public class ItemController {
	

	  @Autowired
	  private ItemRepository repository;
	  
	  MongoClient mongoClient = new MongoClient();
	  DB db = mongoClient.getDB( "admin" );
	  

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Item> getAllItem() {
	    return repository.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Item getItemById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyItemById(@PathVariable("id") ObjectId id, @Valid @RequestBody Item item) {
	    item.set_id(id);
	    repository.save(item);
	  }

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Item createItem(@Valid @RequestBody Item item) {
		item.set_id(ObjectId.get());
		repository.save(item);
		return item;
	}
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteItem(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}


