package ra.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.dto.EmployeeCreateDTO;
import ra.edu.entity.Department;
import ra.edu.entity.Employee;
import ra.edu.exception.DuplicateResourceException;
import ra.edu.exception.ResourceNotFoundException;
import ra.edu.repository.DepartmentRepository;
import ra.edu.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public Employee create(EmployeeCreateDTO dto) {

        Department dept = departmentRepo.findById(Math.toIntExact(dto.getDepartmentId()))
                .orElseThrow(() -> new ResourceNotFoundException("Phòng ban không tồn tại"));

        if (employeeRepo.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("Email đã được sử dụng");
        }

        Employee e = new Employee();
        e.setFullName(dto.getFullName());
        e.setEmail(dto.getEmail());
        e.setPhone(dto.getPhone());
        e.setSalary(dto.getSalary());
        e.setDepartment(dept);

        return employeeRepo.save(e);
    }
}
