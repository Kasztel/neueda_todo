package com.neueda.item_api.controller;

import com.neueda.item_api.ItemApiApplication;
import com.neueda.item_api.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService=itemService;
        this.itemService.addItem("Test1");
        this.itemService.addItem("Test2");
        this.itemService.addItem("Test3");
    }

    @GetMapping
    public List<String> getAllItems(){
        return this.itemService.returnAllItems();
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable int id){
        return this.itemService.returnItem(id);
    }

    @PostMapping
    public String getItem(@RequestBody String item){
        this.itemService.addItem(item);
        return "Successfull POST";
    }
    @PutMapping("/{id}")
    public List<String> updateItem(@PathVariable int id, @RequestBody String item) {
        // This method would typically update an existing item.
        return itemService.updateItem(id, item);
    }
}
