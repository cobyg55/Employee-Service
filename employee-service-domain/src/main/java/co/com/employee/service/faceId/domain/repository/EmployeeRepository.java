package co.com.employee.service.faceId.domain.repository;

import co.com.employee.service.faceId.domain.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
