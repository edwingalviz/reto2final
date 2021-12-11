/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.controller;

import com.example.g8.entities.Order;
import com.example.g8.services.OrderService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author bmao9
 */
@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService service;
    
    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Order> getZone(@PathVariable("id")Integer id){
        return service.getId(id);
    }
    @GetMapping("/zona/{zone}")
    public List<Order> getZone(@PathVariable("zone") String zona){
        return service.getZone(zona);
    }
    @GetMapping("/salesMan/{id}")
    public List<Order> getSalesMan(@PathVariable("id") Integer id){
        return service.getSalesMan(id);
    }
    @GetMapping("/state/{status}/{id}")
    public List<Order> getStatus(@PathVariable("id") Integer id,@PathVariable("status") String status){
        return service.getStatus(status, id);
    }
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getStatus(@PathVariable("id") Integer id,@PathVariable("registerDay") Date fecha){
        return service.getFecha(id, fecha);
    }
    
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order OrderNew(@RequestBody Order OrderNew){
        return service.createOrder(OrderNew);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order editOrder(@RequestBody Order order){
        return service.update(order);
    }
    
    
}
