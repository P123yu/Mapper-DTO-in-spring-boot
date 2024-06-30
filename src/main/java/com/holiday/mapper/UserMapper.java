package com.holiday.mapper;


import com.holiday.dto.UserDTO;
import com.holiday.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

       // Ignore userPassword in UserModel

      // @Mapping(target = "userPassword", ignore = true)
       UserModel dtoToModel(UserDTO userDTO);

       @Mapping(target = "userPassword", ignore = true)
       UserDTO modelToDto(UserModel userModel);

}
