package com.comandaqr.services;

import com.comandaqr.models.User;
import com.comandaqr.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository repository;

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    return repository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("User not found")
    );
  }

  public User save(User user) {
    return repository.save(user);
  }
}
