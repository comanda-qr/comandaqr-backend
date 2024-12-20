package com.comandaqr.mapstruct.mappers;

import com.comandaqr.mapstruct.dto.UserDTO;
import com.comandaqr.mapstruct.dto.UserLoginDTO;
import com.comandaqr.mapstruct.dto.UserRegisterDTO;
import com.comandaqr.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuthenticationMapper {
  User userLoginDtoToUser(UserLoginDTO userLoginDTO);
  User userRegisterDtoToUser(UserRegisterDTO userRegisterDTO);
  UserDTO userToUserDTO(User user);
}
