package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entity.concrete.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
}
