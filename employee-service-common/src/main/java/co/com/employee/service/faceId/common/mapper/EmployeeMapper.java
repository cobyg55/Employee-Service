package co.com.employee.service.faceId.common.mapper;

import co.com.employee.service.faceId.common.request.EmployeeRequest;
import co.com.employee.service.faceId.common.response.EmployeeResponse;
import co.com.employee.service.faceId.domain.model.Employee;

public class EmployeeMapper {

    public static EmployeeResponse mapToEmployeeResponse (Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setAddress(employee.getAddress());
        employeeResponse.setPhone(employee.getPhone());
        return employeeResponse;
    }

    public static Employee mapToEmployee (EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setAddress(employeeRequest.getAddress());
        employee.setPhone(employeeRequest.getPhone());
        return employee;
    }

}
