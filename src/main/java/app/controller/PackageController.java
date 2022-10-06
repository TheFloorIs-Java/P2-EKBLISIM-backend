package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.service.PackageService;
import app.aspect.Logging;
import app.model.Package;

@RestController
@CrossOrigin
public class PackageController {
    private PackageService ps;

    @Autowired
    public PackageController(PackageService ps) {
        this.ps = ps;
    }

    @PostMapping("packages")
    public void addPackage(@RequestBody Package p) {
        Logging.LOG.info("Adding package");
        this.ps.addPackage(p);
    }

    @GetMapping("packages/{id}")
    public Package getPackageByID(@PathVariable("id") Integer ID) {
        Logging.LOG.info("Retrieving package");
        return this.ps.getPackageByID(ID);
    }

    @PutMapping("packages/{id}")
    public void updatePackage(@RequestBody Package p) {
        Logging.LOG.info("Updating package " + p.getID());
        this.ps.updatePackage(p);
    }
}