package com.globant.musicstore.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "house_record")
public class HouseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_record_id")
    private long id;
    @Column(name = "house_record_name", nullable = false)
    private String name;
    @Column(name = "year_from", nullable = false)
    private Date yearFrom;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "houseRecord", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("houseRecord")
    private Set<Artist> artists;

}
