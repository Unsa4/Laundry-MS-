package com.example.laundry.controller;

import com.example.laundry.model.Item;
import com.example.laundry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService ItemService;

    @Autowired
    public ItemController(ItemService ItemService) {
        this.ItemService = ItemService;
    }

    @PostMapping("/Items")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item Item) {
        Item createdItem = ItemService.saveItem(Item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/Items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> Items = ItemService.getAllItems();
        return ResponseEntity.ok(Items);
    }

    @GetMapping("/Items/{id}")
    public ResponseEntity<Optional<Item>> getItemById(@PathVariable(value = "id") Long id) {
        Optional<Item> Item = ItemService.getItemById(String.valueOf(id));
        if (Item.isPresent()) {
            return ResponseEntity.ok(Item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long id, @RequestBody Item ItemDetails) {
        Item updatedItem = ItemService.updateItem(String.valueOf(id), ItemDetails);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/Items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable(value = "id") Long id) {
        ItemService.deleteItem(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
