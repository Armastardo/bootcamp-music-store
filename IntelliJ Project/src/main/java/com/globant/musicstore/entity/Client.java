package com.globant.musicstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_surname")
    private String surname;

    @Column(name = "client_mail")
    private String mail;

    @Column(name = "stars")
    private Integer stars;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_client_type_id", referencedColumnName = "cat_client_type_id")
    private ClientType clientType;

    @Column(name = "is_active")
    private Boolean isActive;

    public Client() {

    }
}
