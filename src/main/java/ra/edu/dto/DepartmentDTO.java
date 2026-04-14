package ra.edu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    @NotBlank(message = "Tên phòng ban không được để trống")
    @Size(min = 5, max = 50, message = "Tên phòng ban phải từ 5-50 ký tự")
    private String name;

    @Size(max = 100, message = "Mô tả tối đa 100 ký tự")
    private String description;
}
