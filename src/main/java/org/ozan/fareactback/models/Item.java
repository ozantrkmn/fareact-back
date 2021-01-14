package org.ozan.fareactback.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Item {
	
	@Id
	public ObjectId _id;
	String itemName;
	
	
	public Item(ObjectId _id, String itemName) {
		super();
		this._id = _id;
		this.itemName = itemName;
	}




	public String get_id() {
		return _id.toHexString();
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
