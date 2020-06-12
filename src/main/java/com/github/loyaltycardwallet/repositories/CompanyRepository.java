package com.github.loyaltycardwallet.repositories;

import com.github.loyaltycardwallet.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findCompanyByStampCardId(UUID scId);

    boolean existsById(UUID id);
}
