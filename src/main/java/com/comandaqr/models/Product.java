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
public class Product {
  @Id
  @EpochUUID
  private UUID id;

  @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<Order> orders = new ArrayList<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "businessid")
  private Business business;
}
