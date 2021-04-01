package uz.pdp.dataresttwo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dataresttwo.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
