package ra.edu.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.dto.ApiResponse;
import ra.edu.dto.DepartmentDTO;
import ra.edu.entity.Department;
import ra.edu.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository repo;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> create(
            @Valid @RequestBody DepartmentDTO dto) {

        Department d = new Department();
        d.setName(dto.getName());
        d.setDescription(dto.getDescription());

        repo.save(d);

        return ResponseEntity.status(201)
                .body(new ApiResponse<>("SUCCESS", "Created", d));
    }
}
