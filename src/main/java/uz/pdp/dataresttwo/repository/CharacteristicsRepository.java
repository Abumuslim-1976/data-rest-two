package uz.pdp.dataresttwo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.dataresttwo.entity.Characteristic;

@RepositoryRestResource(path = "characteristic",collectionResourceRel = "list")
public interface CharacteristicsRepository extends JpaRepository<Characteristic, Integer> {

    @RestResource(path = "byName")
    Page<Characteristic> findAllByName(@Param("name") String name, Pageable pageable);

}
