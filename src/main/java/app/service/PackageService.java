package App.Service;

import App.Model.Packages;
import App.Repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class PackageService {
    PackageRepository pr;
    @Autowired
    public PackageService(PackageRepository pr){
        this.pr = pr;
    }
    public List<Packages> getAllPackages(){
        return pr.findAll();
    }
}
