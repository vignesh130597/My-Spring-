package com.spring.postgres.modal;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Basic(optional = false)
    private long id;
    @NotNull
    private String firstName;
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
}
