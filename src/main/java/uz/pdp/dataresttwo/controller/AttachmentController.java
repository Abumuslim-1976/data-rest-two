package uz.pdp.dataresttwo.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.dataresttwo.entity.Attachment;
import uz.pdp.dataresttwo.entity.AttachmentContent;
import uz.pdp.dataresttwo.payload.ApiResponse;
import uz.pdp.dataresttwo.repository.AttachmentContentRepository;
import uz.pdp.dataresttwo.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    @PostMapping
    public ApiResponse upload(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        if (file != null) {
            Attachment attachment = new Attachment();
            attachment.setName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setContentType(file.getContentType());
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);
            return new ApiResponse("Fayl saqlandi", true);
        }
        return new ApiResponse("Xatolik", false);
    }


    @SneakyThrows
    @GetMapping("/{id}")
    public ApiResponse download(@PathVariable Integer id, HttpServletResponse response) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent())
            return new ApiResponse("Fayl topilmadi", false);

        Optional<AttachmentContent> byAttachmentId = attachmentContentRepository.findByAttachmentId(id);
        if (!byAttachmentId.isPresent())
            return new ApiResponse("Faylni contenti mavjud emas", false);

        Attachment attachment = optionalAttachment.get();
        AttachmentContent attachmentContent = byAttachmentId.get();

        response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getName() + "\"");
        response.setContentType(attachment.getContentType());
        FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
        return new ApiResponse("Fayl yuklab olindi", true);
    }

}
