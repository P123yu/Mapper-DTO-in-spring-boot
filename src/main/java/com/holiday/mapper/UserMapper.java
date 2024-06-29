package com.holiday.mapper;


import com.holiday.dto.UserDTO;
import com.holiday.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
       UserModel dtoToModel(UserDTO userDTO);
       UserDTO modelToDto(UserModel userModel);

}
