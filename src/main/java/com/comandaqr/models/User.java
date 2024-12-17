package com.comandaqr.models;

import com.comandaqr.infra.epochuuid.EpochUUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class User implements UserDetails {
  @Id
  @EpochUUID
  private UUID id;

  private String username;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  private String name;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Business> businesses = new ArrayList<>();
}
