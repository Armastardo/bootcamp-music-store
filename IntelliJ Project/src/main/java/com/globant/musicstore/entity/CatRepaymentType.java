package com.globant.musicstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cat_repayment_type")
public class CatRepaymentType {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catRepaymentTypeId;

    @Column(name = "cat_repayment_type")
    private String catRepaymentType;

    @Column(name="cat_repayment_description")
    private String catRepaymentDescription;

    @Column(name = "is_active")
    private Boolean isActive;

    public CatRepaymentType() {

    }
}