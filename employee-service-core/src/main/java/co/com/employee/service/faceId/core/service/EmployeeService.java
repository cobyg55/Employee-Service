package co.com.employee.service.faceId.core.service;

import co.com.employee.service.faceId.common.ex.BasketException;
import co.com.employee.service.faceId.common.ex.ErrorCodes;
import co.com.employee.service.faceId.common.ex.ErrorMessages;
import co.com.employee.service.faceId.common.mapper.EmployeeMapper;
import co.com.employee.service.faceId.common.request.EmployeeRequest;
import co.com.employee.service.faceId.common.response.EmployeeResponse;
import co.com.employee.service.faceId.domain.model.Employee;
import co.com.employee.service.faceId.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MessageService messageService;

    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::mapToEmployeeResponse).collect(Collectors.toList());
    }

    public EmployeeResponse findById(long id) throws BasketException {
        return EmployeeMapper.mapToEmployeeResponse(getById(id));
    }

    public EmployeeResponse create(EmployeeRequest request) throws BasketException {
        return EmployeeMapper.mapToEmployeeResponse(employeeRepository.save(EmployeeMapper.mapToEmployee(request)));
    }

    public EmployeeResponse update(long id, EmployeeRequest request) throws BasketException {
        Employee current = getById(id);
        current.setLastName(request.getLastName());
        current.setName(request.getName());
        current.setAddress(request.getAddress());
        current.setPhone(request.getPhone());
        current.setEmail(request.getEmail());
        return EmployeeMapper.mapToEmployeeResponse(employeeRepository.save(current));
    }

    public Employee getById(long id) throws BasketException {
        return employeeRepository.findById(id).orElseThrow(() -> new BasketException(ErrorCodes.VALIDATION, messageService.getMessage(ErrorMessages.EMPLOYEE_NOT_FOUND, new Object[]{id}), HttpStatus.BAD_REQUEST));
    }

}
