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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cat_client_type")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_client_type_id")
    private Long id;

    @Column(name = "cat_client_type")
    private String type;

    @Column(name = "cat_client_description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "clientType")
    private Client client;

    public ClientType() {

    }
}
