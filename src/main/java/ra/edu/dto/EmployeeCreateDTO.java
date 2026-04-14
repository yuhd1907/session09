package ra.edu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateDTO {

    private String fullName;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại không hợp lệ")
    private String phone;

    @Min(value = 5000000, message = "Lương tối thiểu 5 triệu")
    private Long salary;

    @NotNull(message = "DepartmentId không được null")
    private Long departmentId;
}
