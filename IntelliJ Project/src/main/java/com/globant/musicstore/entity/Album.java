package com.globant.musicstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_creation")
    private Date year_creation;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "quantity_available")
    private Integer quantity_available;

    @Column(name = "price")
    private Double price;

    @ManyToOne(targetEntity = Artist.class,fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    /*@Column(name = "artist_id")
    private Long artist_id;*/

}
