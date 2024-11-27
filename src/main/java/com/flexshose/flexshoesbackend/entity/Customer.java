package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")

public class Customer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", columnDefinition = "int", updatable = false, insertable = false)
    private Integer customerId;

    @Column(name = "CUSTOMER_NAME", columnDefinition = "nvarchar(105)")
    @NotNull(message = "Customer name cannot be empty")
    @NotEmpty(message = "Customer name cannot be empty")
    private String customerName;

    @Column(name = "PHONE_NUMBER", columnDefinition = "nvarchar(12)")
    private String phoneNumber;

    @Column(name = "EMAIL", columnDefinition = "nvarchar(105)")
    private String email;

    @Column(name = "REGISTER_DATE")
    private LocalDate registerDate;
    
    @Column(name = "GENDER")
    private String gender;

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =  @JoinColumn(name = "CUSTOMER_ID"))
    @Column(name = "ADDRESS", columnDefinition = "nvarchar(105)")
    private Set<String> address;
}
