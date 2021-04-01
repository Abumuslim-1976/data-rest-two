package uz.pdp.dataresttwo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.dataresttwo.entity.Supplier;
import uz.pdp.dataresttwo.entity.User;

@RepositoryRestResource(path = "supplier")
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @RestResource(path = "byName")
    Page<Supplier> findAllByName(@Param("name") String firstName, Pageable pageable);

    @RestResource(path = "byPhoneNumber")
    Page<Supplier> findByPhoneNumber(@Param("phoneNumber") String phoneNumber, Pageable pageable);

}
