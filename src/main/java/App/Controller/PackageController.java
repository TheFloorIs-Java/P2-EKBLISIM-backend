package App.Controller;

import App.Model.Package;
import App.Service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageController {
    PackageService ps;
    @Autowired
    public PackageController(PackageService ps){
        this.ps = ps;

    }
    @GetMapping
    public List<Package> getAllPackages(){
        return PackageService.getAllPackages();
    }
    @PostMapping
    public Package addPackage(@RequestBody Package p){
        return ps.addPackage();
    }

}
