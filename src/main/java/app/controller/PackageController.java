package App.controller;

import App.Model.Packages;
import App.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PackageController {
    PackageService ps;
    @Autowired
    public PackageController(PackageService ps){
        this.ps = ps;
    }
    @GetMapping("packages")
    public List<Packages> getAllPackages(){
        return ps.getAllPackages();
    }
}
