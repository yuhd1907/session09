package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
