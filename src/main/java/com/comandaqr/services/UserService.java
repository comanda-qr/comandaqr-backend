package com.comandaqr.services;

import com.comandaqr.models.User;
import com.comandaqr.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
    );
  }
}
