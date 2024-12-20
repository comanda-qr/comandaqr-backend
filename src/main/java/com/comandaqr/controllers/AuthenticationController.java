package com.comandaqr.controllers;

import com.comandaqr.infra.security.TokenService;
import com.comandaqr.mapstruct.dto.AuthenticationDTO;
import com.comandaqr.mapstruct.dto.UserDTO;
import com.comandaqr.mapstruct.dto.UserLoginDTO;
import com.comandaqr.mapstruct.dto.UserRegisterDTO;
import com.comandaqr.mapstruct.mappers.UserAuthenticationMapper;
import com.comandaqr.models.User;
import com.comandaqr.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
  private final AuthenticationService service;
  private final TokenService tokenService;
  private final UserAuthenticationMapper mapper;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationDTO> register(@RequestBody UserRegisterDTO request) {
    User user = service.register(request);
    String token = tokenService.generateToken(user, true);
    UserDTO userDTO = mapper.userToUserDTO(user);

    AuthenticationDTO response = new AuthenticationDTO(userDTO, token);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationDTO> login(@RequestBody UserLoginDTO request) {
    User user = service.login(request);
    String token = tokenService.generateToken(user, true);
    UserDTO userDTO = mapper.userToUserDTO(user);

    AuthenticationDTO response = new AuthenticationDTO(userDTO, token);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
