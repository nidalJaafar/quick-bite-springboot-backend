package com.quickbite.backend.common.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "role", nullable = false)
  private String role;

  @OneToMany(mappedBy = "user")
  @Exclude
  private Set<Order> orders = new LinkedHashSet<>();

  @OneToOne(mappedBy = "user")
  @Exclude
  private VisitFeedback visitFeedback;

  @OneToMany(mappedBy = "user")
  @Exclude
  private Set<ItemFeedback> itemFeedbacks = new LinkedHashSet<>();

}