package com.comandaqr.models;

import com.comandaqr.infra.epochuuid.EpochUUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Business {
  @Id
  @EpochUUID
  private UUID id;

  private String name;

  @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
  private List<Order> orders = new ArrayList<>();

  @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
  private List<Product> products = new ArrayList<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userid")
  private User user;
}
