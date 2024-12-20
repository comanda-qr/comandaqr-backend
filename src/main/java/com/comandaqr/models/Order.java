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
public class Order {
  @Id
  @EpochUUID
  private UUID id;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
      name = "ordersproductslike",
      joinColumns = @JoinColumn(name = "orderid"),
      inverseJoinColumns = @JoinColumn(name = "productid")
  )
  private List<Product> products = new ArrayList<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "businessid")
  private Business business;
}
