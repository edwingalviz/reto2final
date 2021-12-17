/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.repositoriesCrud;

import com.example.g8.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author bmao9
 */
public interface UserCrudRepository extends MongoRepository<User,Integer>{
    
    @Query("{monthBirthtDay: ?0}")
    List<User> getMountBrithDay(String mount);
    
}
