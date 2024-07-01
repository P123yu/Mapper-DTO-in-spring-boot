package com.holiday.service;
import com.holiday.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    // create
    public UserDTO create(UserDTO userDTO);

    // getById
    public UserDTO getById(int id);

    // getAll
    public List<UserDTO> getAllByCity(String userCity);
}
