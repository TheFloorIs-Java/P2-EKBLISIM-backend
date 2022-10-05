package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.repository.PackageRepository;

import app.model.Package;

@Service
public class PackageService {
    private PackageRepository pr;

    @Autowired
    public PackageService(PackageRepository pr) {
        this.pr = pr;
    }

    public Package getPackageByID(Integer ID) {
        return this.pr.findById(ID).get();
    }

    @Transactional
    public void addPackage(Package p) {
        this.pr.save(p);
    }

    @Transactional
    public void updatePackage(Package p) {
        this.pr.save(p);
    }
}