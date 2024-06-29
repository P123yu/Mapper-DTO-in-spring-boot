package com.holiday.service;

import com.holiday.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // create
    public UserDTO create(UserDTO userDTO);

    // getByCity
    public UserDTO getByCity(String userName);

    // getAll
    public List<UserDTO> getAllByCity(String userCity);
}
