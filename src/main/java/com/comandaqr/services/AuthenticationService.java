package com.comandaqr.services;

import com.comandaqr.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AuthenticationService {
  private final UserService userService;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  public User register(User user) throws ResponseStatusException {
    if (userIsRegistered(user.getUsername()))
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already in use");

    String encryptedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encryptedPassword);

    return userService.save(user);
  }

  public User login(User user) throws ResponseStatusException {
    var usernamePassword = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    var auth = this.authenticationManager.authenticate(usernamePassword);
    return (User) auth.getPrincipal();
  }

  private boolean userIsRegistered(String username) {
    try {
      userService.loadUserByUsername(username);
    } catch (UsernameNotFoundException usernameNotFoundException) {
      return false;
    }
    return true;
  }
}
