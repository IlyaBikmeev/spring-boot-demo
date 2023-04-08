package ru.top.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.top.springbootdemo.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByShop(String shop);
}
