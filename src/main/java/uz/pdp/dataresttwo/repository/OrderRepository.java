package uz.pdp.dataresttwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dataresttwo.entity.Order;

@RepositoryRestResource(path = "orders")
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
