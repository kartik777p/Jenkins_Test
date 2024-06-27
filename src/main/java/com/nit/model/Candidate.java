package com.nit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_CANDIDATE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String email;
    private String accessToken;
    private String refreshToken;
    // Many-to-one relationship with Referral class
    @ManyToOne
    @JoinColumn(name = "referral_id")
    private Referral referredBy;
    private String referralCode;

    // Constructors, getters, setters
    // Omitted for brevity
}
