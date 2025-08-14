package com.neueda.item_api.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService implements ItemServiceInterface{
    private List<String> itemsList = new ArrayList<String>();

    @Override
    public List<String> returnAllItems() {
        return itemsList;
    }
    public String returnItem(int id) {
        return itemsList.get(id);
    }
    public void addItem(String item){
        itemsList.add(item);
    }
    public List<String> updateItem(int id, String item) {
        itemsList.set(id,item);
        return List.of("Update successful");
    }
}
