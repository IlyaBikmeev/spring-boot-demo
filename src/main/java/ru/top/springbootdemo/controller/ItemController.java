package ru.top.springbootdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.top.springbootdemo.entity.Item;
import ru.top.springbootdemo.repository.ItemRepository;

import java.util.List;

/**
 * GET /items - получить все товары
 * POST /items - сохранить товар
 * GET /items/{id} - получить товар по id
 */

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> allItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/shop/{shop}")
    public List<Item> allInShop(@PathVariable(value = "shop") String shop) {
        return itemRepository.findAllByShop(shop);
    }


    @PostMapping
    public Item saveItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }
}
