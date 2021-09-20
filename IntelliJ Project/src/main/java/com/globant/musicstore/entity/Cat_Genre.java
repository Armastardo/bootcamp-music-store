package com.globant.musicstore.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cat_genre")
public class Cat_Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}


