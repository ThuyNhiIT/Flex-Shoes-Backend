package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name = "EMAIL")
    private Customer customer;

    @Column(name = "PASSWORD", columnDefinition = "nvarchar(16)")
    @Pattern(regexp = "^[a-zA-Z0-9]{7,15}$", message = "Invalid password format")
    private String password;

    @Column(name = "ROLE", columnDefinition = "nvarchar(20)")
    @Enumerated(EnumType.STRING)
    private Role role;

}
