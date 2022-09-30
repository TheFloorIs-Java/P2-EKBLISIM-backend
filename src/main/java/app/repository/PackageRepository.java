package App.Repository;

import App.Model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Packages, Integer> {

}
