/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.repositoriesCrud;

import com.example.g8.entities.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;







/**
 *
 * @author bmao9
 */
public interface OrderCrudRepository extends MongoRepository<Order,Integer>{
    
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesMan(final Integer id);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    @Query("{registerDay: ?0}")
    List<Order> findByRegisterDay(final Date fecha);
    
    
    
}
/*public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    
    Optional<Order> findByZone(String zone);
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    //@Query("{'salesMan.zone': ?0}")
    //List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}*/

