package App.Service;

import App.Model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackageService {
    @Autowired
    public PackageService(){

    }
    public static List<Package> getAllPackages(){
        return null;
    }
    public Package addPackage(Package p){
        return null;
    }

}
