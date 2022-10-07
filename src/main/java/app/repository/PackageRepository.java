package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {
    
}