package com.informatorio.ACTIVIDAD.FINAL.controller;

import com.informatorio.ACTIVIDAD.FINAL.entity.User;
import com.informatorio.ACTIVIDAD.FINAL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fromDate) {
        if(fromDate != null){
            List<User> usersFromDate = userService.findByDateOfCreation(fromDate);
            return new ResponseEntity<>(usersFromDate,HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping(value = "/{city}")
    public ResponseEntity<?> getUsersByCity(@PathVariable String city){
        List<User> usersByCity = userService.findByCity(city);
        return new ResponseEntity<>(usersByCity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerNewUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    public void modifyUser(@PathVariable Long id ,@RequestBody User user){
        userService.updateUser(user, id);
    }


}
