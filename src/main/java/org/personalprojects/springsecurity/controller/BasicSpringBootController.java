package org.personalprojects.springsecurity.controller;

import org.personalprojects.springsecurity.model.Item;
import org.personalprojects.springsecurity.service.BasicSpringBootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring-boot")
public class BasicSpringBootController {

  @Autowired
  BasicSpringBootService basicSpringBootService;

  @GetMapping("test")
  public String testMapping(){return basicSpringBootService.testBasicSpringBootService();}

  @GetMapping("items")
  public ResponseEntity<List<Item>> getAllItems(){
    return new ResponseEntity<>(basicSpringBootService.getAllItems(), HttpStatus.OK);
  }

  @PostMapping("item")
  public ResponseEntity<Item> createItem(@RequestBody Item item){
    return new ResponseEntity<>(basicSpringBootService.createItem(item), HttpStatus.CREATED);
  }

  @DeleteMapping("item/{itemId}")
  public ResponseEntity deleteItem(@PathVariable Integer itemId){
    basicSpringBootService.deleteItem(itemId);
    return ResponseEntity.noContent().build();
  }
}
