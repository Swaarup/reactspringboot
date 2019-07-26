package com.example.demo.controller;

import java.util.List;


import com.example.demo.docs.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin 

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;
    
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "This is a public Index Page. Everyone Can see this";
    }

    
    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public List<Item> getItem(@RequestParam("category") String category){
        return itemService.getItemByCategory(category);
    }

    @RequestMapping("/getItemById")
    @ResponseBody
    public Item getItemById(@RequestParam("id") String id){
        return itemService.getItemByItemId(id);
    }
       

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("itemId") long itemId,@RequestParam("serialNumber") String serialNumber,
                          @RequestParam("name") String name, @RequestParam("category") String category){
        if(itemService.addItem(itemId,serialNumber,name,category) != null){
            return "Item Added Successfully.... Bravooo";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deleteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("id") String id){
        if(itemService.deleteItem(id) == 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}