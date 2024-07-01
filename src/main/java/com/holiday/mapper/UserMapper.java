package com.holiday.mapper;
import com.holiday.dto.UserDTO;
import com.holiday.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

       UserModel dtoToModel(UserDTO userDTO);

       @Mapping(target = "userPassword", ignore = true)
       UserDTO modelToDto(UserModel userModel);

}
