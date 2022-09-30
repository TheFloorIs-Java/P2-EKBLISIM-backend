package App.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackageService {
    @Autowired
    public PackageService(){

    }
    public List<Package> getAllPackages(){
        return null;
    }
    public Package addPackage(){
        return null;
    }

}
