package com.accountant.apiservice.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
    name = "accountant"
)
@Getter
@Setter
@NoArgsConstructor
public class Accountant extends EntityWithLongId {

  @Column(name = "name")
  private String name;

  @Column(name = "is_active", nullable = false)
  private boolean active;
}
