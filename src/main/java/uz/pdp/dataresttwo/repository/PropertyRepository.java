package uz.pdp.dataresttwo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.dataresttwo.entity.Property;


@RepositoryRestResource(path = "property")
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    @RestResource(path = "byName")
    Page<Property> findAllByName(@Param("name") String firstName, Pageable pageable);


}
