package com.holiday.controller;
import com.holiday.dto.UserDTO;
import com.holiday.service.UserService;
import com.holiday.util.ResponseUtil;
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
    public ResponseEntity<ResponseUtil<UserDTO>> createCat(@RequestBody UserDTO userDTO) throws Exception {
        UserDTO userDto = userService.create(userDTO);
        ResponseUtil<UserDTO> response = ResponseUtil.<UserDTO>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .message("created successfully")
                .data(userDto)
                .build();
        return ResponseEntity.ok(response);
    }


    // getById

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseUtil<UserDTO>> getById(@PathVariable int id) {
        UserDTO userDTO = userService.getById(id);
        ResponseUtil<UserDTO> response = ResponseUtil.<UserDTO>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .message("fetched by id")
                .data(userDTO)
                .build();
        return ResponseEntity.ok(response);

    }


    @GetMapping("/getAll/{city}")
    public ResponseEntity<ResponseUtil<List<UserDTO>>> getAllCity(@PathVariable String city) {
        List<UserDTO> userDTOs = userService.getAllByCity(city);
        ResponseUtil<List<UserDTO>> response = ResponseUtil.<List<UserDTO>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .message("fetched all city information")
                .data(userDTOs)
                .build();
        return ResponseEntity.ok(response);
    }
}
