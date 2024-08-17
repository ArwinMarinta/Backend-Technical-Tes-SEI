package teknikal_tes_arwinmarinta.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teknikal_tes_arwinmarinta.spring_boot.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    
}
