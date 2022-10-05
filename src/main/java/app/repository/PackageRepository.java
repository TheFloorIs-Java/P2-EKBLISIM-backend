package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Package;

public interface PackageRepository extends JpaRepository<Package, Integer> {
    
}