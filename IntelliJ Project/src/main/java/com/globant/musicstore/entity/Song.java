package com.globant.musicstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "song_name")
    private String name;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(targetEntity = Album.class,fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    //@JsonBackReference
    @JoinColumn(name = "album_id", referencedColumnName = "album_id")
    private Album album;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "cat_genre_id", referencedColumnName = "cat_genre_id")
    private CatGenre catGenre;

}
