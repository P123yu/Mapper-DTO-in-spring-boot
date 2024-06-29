package com.holiday.controller;

import com.holiday.dto.UserDTO;
import com.holiday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    // post

    @PostMapping("/postUser")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        UserDTO userDto= userService.create(userDTO);
        if(userDto!=null){
            return ResponseEntity.ok(userDto);
        }
        else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not created");
        }
    }

    // getByCity

    @GetMapping("/get/{city}")
    public ResponseEntity<?> getByCity(@PathVariable String city){
        UserDTO userDTO=userService.getByCity(city);
        if(userDTO!=null){
            return ResponseEntity.ok(userDTO);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }


    // getAllByCity

    @GetMapping("/getAll/{city}")
    public ResponseEntity<?> getAllByCity(@PathVariable String city) {
         List<UserDTO> userDTO=userService.getAllByCity(city);
        if(!userDTO.isEmpty()){
            return ResponseEntity.ok(userDTO);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("all user not found");
        }
    }

}
