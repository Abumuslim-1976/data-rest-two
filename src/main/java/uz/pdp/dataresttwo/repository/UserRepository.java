package uz.pdp.dataresttwo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.dataresttwo.entity.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {

    @RestResource(path = "byFirstName")
    Page<User> findAllByFirstName(@Param("firstName") String firstName, Pageable pageable);

    @RestResource(path = "byLastName")
    Page<User> findAllByLastName(@Param("lastName") String lastName, Pageable pageable);

    @RestResource(path = "byEmail")
    Page<User> findByEmail(@Param("email") String email, Pageable pageable);

    @RestResource(path = "byPhoneNumber")
    Page<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber, Pageable pageable);
}
