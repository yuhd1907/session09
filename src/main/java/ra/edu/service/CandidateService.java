package ra.edu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.edu.dto.CandidateApplyDTO;
import ra.edu.entity.Candidate;
import ra.edu.repository.CandidateRepository;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository repo;

    @Transactional
    public Candidate apply(CandidateApplyDTO dto) {

        MultipartFile file = dto.getCvFile();

        if (file == null || !file.getOriginalFilename().endsWith(".pdf")) {
            throw new RuntimeException("File phải là PDF");
        }

        // giả lập upload
        String url = "cloudinary/url.pdf";

        Candidate c = new Candidate();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setCvUrl(url);

        return repo.save(c);
    }
}
