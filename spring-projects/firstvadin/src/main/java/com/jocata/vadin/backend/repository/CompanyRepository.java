package com.jocata.vadin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.vadin.backend.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
