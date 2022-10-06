package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.repository.PackageRepository;
import app.aspect.Logging;
import app.model.Package;

@Service
public class PackageService {
    private PackageRepository pr;

    @Autowired
    public PackageService(PackageRepository pr) {
        this.pr = pr;
    }

    public Package getPackageByID(Integer ID) {
        Logging.LOG.info("Retrieving package " + ID);
        return this.pr.findById(ID).get();
    }

    @Transactional
    public void addPackage(Package p) {
        Logging.LOG.info("Adding package");
        this.pr.save(p);
    }

    @Transactional
    public void updatePackage(Package p) {
        Logging.LOG.info("Updating package " + p.getID());
        this.pr.save(p);
    }
}