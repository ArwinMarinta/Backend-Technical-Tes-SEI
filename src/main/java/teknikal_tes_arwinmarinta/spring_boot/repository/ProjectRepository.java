package teknikal_tes_arwinmarinta.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teknikal_tes_arwinmarinta.spring_boot.entity.Proyek;


@Repository
public interface ProjectRepository extends JpaRepository<Proyek, Integer> {
    
}
