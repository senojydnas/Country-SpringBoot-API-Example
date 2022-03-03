package com.vizientinc.ENTSharedTemplateJava.JPA.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "countries")
@NoArgsConstructor
@Entity
public class Country {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

}
