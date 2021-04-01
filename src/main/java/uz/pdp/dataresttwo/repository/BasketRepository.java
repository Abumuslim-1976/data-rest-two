package uz.pdp.dataresttwo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.dataresttwo.entity.Basket;

@RepositoryRestResource(path = "basket")
public interface BasketRepository extends JpaRepository<Basket,Integer> {

    @RestResource(path = "byPrice")
    Page<Basket> findAllByPrice(@Param("price") Double price, Pageable pageable);
}
