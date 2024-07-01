package com.holiday.service.impl;
import com.holiday.dto.UserDTO;
import com.holiday.mapper.UserMapper;
import com.holiday.model.UserModel;
import com.holiday.repository.UserRepository;
import com.holiday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO create(UserDTO userDTO) {
        UserModel user=userMapper.dtoToModel(userDTO);
        UserModel userObj=userRepository.save(user);
        return userMapper.modelToDto(userObj);
    }

    @Override
    public UserDTO getById(int id) {
        UserModel user=userRepository.findById(id).orElse(null);
        return userMapper.modelToDto(user);

    }


    @Override
    public List<UserDTO> getAllByCity(String userCity) {
        List<UserModel>allUser=userRepository.findByUserCity(userCity);
        return allUser.stream().map(userMapper::modelToDto).collect(Collectors.toList());
    }
}
