package com.example.role.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
@Entity
@Table(name = "ROLES")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
