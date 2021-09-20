package com.globant.musicstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "is_active")
    private Boolean is_active;

    @ManyToOne(targetEntity = Album.class,fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "cat_genre_id", referencedColumnName = "id")
    private Cat_Genre cat_genre;

}
