package com.ms.tourist_app.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.tourist_app.application.constants.AppStr;
import com.ms.tourist_app.domain.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = AppStr.Destination.tableDestination)
public class Destination extends BaseEntity {
    @Column(name = AppStr.Destination.name)
    private String name;


    @Column(name = AppStr.Destination.description)
    private String description;

    @ManyToOne
    @JoinColumn(name = AppStr.Destination.idTypeDestination)
    @JsonIgnore
    private DestinationType destinationType;


    @OneToMany(mappedBy = AppStr.Destination.tableDestination)
    private List<ImageDestination> imageDestinations;


    @ManyToOne
    @JoinColumn(name = AppStr.Destination.idAddress)
    @JsonIgnore
    private Address address;


}