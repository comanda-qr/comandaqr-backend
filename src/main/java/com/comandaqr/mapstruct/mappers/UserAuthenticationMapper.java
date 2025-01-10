package com.comandaqr.mapstruct.mappers;

import com.comandaqr.mapstruct.dto.user.UserDTO;
import com.comandaqr.mapstruct.dto.user.UserLoginDTO;
import com.comandaqr.mapstruct.dto.user.UserRegisterDTO;
import com.comandaqr.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuthenticationMapper {
  User userLoginDtoToUser(UserLoginDTO userLoginDTO);
  User userRegisterDtoToUser(UserRegisterDTO userRegisterDTO);
  UserDTO userToUserDTO(User user);
}
