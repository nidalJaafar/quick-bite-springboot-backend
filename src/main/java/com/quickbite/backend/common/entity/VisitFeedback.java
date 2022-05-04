package com.quickbite.backend.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "visit_feedbacks")
public class VisitFeedback {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @Exclude
  private User user;

  @Column(name = "rating", nullable = false)
  private Integer rating;

  @Column(name = "details", nullable = false)
  private String details;

}