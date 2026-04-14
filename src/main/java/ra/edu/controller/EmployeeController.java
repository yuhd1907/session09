package ra.edu.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.edu.dto.ApiResponse;
import ra.edu.dto.EmployeeCreateDTO;
import ra.edu.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ApiResponse<?> create(@Valid @RequestBody EmployeeCreateDTO dto) {
        return new ApiResponse<>("SUCCESS", "Created", service.create(dto));
    }

    @PutMapping("/{id}/avatar")
    public ApiResponse<?> upload(
            @PathVariable Long id,
            @RequestParam MultipartFile file) {

        if (file.getSize() > 2 * 1024 * 1024) {
            throw new RuntimeException("File quá lớn");
        }

        String name = file.getOriginalFilename();
        if (!name.endsWith(".jpg") && !name.endsWith(".png") && !name.endsWith(".jpeg")) {
            throw new RuntimeException("Sai định dạng file");
        }

        // giả lập lưu
        String url = "uploads/" + name;

        return new ApiResponse<>("SUCCESS", "Upload thành công", url);
    }
}
