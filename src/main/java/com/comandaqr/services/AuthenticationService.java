package com.comandaqr.services;

import com.comandaqr.mapstruct.dto.user.UserLoginDTO;
import com.comandaqr.mapstruct.dto.user.UserRegisterDTO;
import com.comandaqr.mapstruct.mappers.UserAuthenticationMapper;
import com.comandaqr.models.User;
import com.comandaqr.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final UserAuthenticationMapper mapper;

  public User register(UserRegisterDTO userRegisterDTO) throws ResponseStatusException {
    if (!userNotRegistered(userRegisterDTO.username()))
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already in use");

    User user = mapper.userRegisterDtoToUser(userRegisterDTO);

    String encryptedPassword = passwordEncoder.encode(userRegisterDTO.password());
    user.setPassword(encryptedPassword);

    return userRepository.save(user);
  }

  public User login(UserLoginDTO userLoginDTO) throws ResponseStatusException {
    User user = mapper.userLoginDtoToUser(userLoginDTO);
    var usernamePassword = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    var auth = this.authenticationManager.authenticate(usernamePassword);
    return (User) auth.getPrincipal();
  }

  private boolean userNotRegistered(String username) {
    return userRepository.findByUsername(username).isEmpty();
  }
}
