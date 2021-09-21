package com.globant.musicstore.entity;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artist_id")
    private long id;
    @Column(name = "artist_name", nullable = false)
    private String name;
    @Column(name = "year_from", nullable = false)
    private Date yearFrom;
    @Column(name = "is_single", nullable = false)
    private boolean isSingle;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "house_record_id", referencedColumnName = "house_record_id")
    @JsonIgnoreProperties("artists")
    private HouseRecord houseRecord;

}
