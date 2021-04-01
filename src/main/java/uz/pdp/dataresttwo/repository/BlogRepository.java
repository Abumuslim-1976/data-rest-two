package uz.pdp.dataresttwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dataresttwo.entity.Blog;

@RepositoryRestResource(path = "blog",collectionResourceRel = "blogs")
public interface BlogRepository extends JpaRepository<Blog,Integer> {

}
