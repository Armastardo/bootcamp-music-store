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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name = "repayment")
public class Repayment{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Date")
    private Date date;

    @OneToOne
    @JoinColumn(name="invoice_id")
    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name="cat_repayment_id",referencedColumnName = "cat_repayment_type_id")
    @Column(name="cat_repayment_id")
    private Repayment catRepaymentId;

    @Column(name="album_id")
    private Integer albumId;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name = "is_active")
    private Boolean isActive;
}
