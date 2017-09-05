package com.MaaSoft.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	 @ResponseBody
	 @RequestMapping(value = "/save-item",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ItemEntity itemSave(@RequestBody ItemEntity itemEntity){
	    	return itemService.saveItem(itemEntity);
	       
	    }
	 
	 @ResponseBody
	 @RequestMapping(value = "/delete-item",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 public boolean itemdelete(@RequestBody ItemEntity itemEntity){
		 System.out.println("Id"+itemEntity.toString());
	    	 itemService.deleteItem(itemEntity);
	       return true;
	    }

}
