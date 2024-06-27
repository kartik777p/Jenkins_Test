package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.Candidate;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

}
