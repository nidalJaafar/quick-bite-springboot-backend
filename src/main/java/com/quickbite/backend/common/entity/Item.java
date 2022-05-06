package com.quickbite.backend.common.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "items")
@Accessors(chain = true)
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "details", nullable = false)
  private String details;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "base_price", nullable = false)
  private Double basePrice;

  @Column(name = "sale", nullable = false)
  private Integer sale;

  @Column(name = "average_rating", nullable = false)
  private Double averageRating;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "menu_id")
  @Exclude
  private Menu menu;

  @Column(name = "is_trending", nullable = false)
  private Integer isTrending;

  @OneToMany(mappedBy = "item")
  @Exclude
  private Set<Image> images = new LinkedHashSet<>();

  @OneToMany(mappedBy = "item")
  @Exclude
  private Set<Order> orders = new LinkedHashSet<>();

  @OneToMany(mappedBy = "item")
  @Exclude
  private Set<ItemFeedback> itemFeedbacks = new LinkedHashSet<>();

}