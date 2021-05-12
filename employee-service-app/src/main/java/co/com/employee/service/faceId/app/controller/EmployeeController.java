package co.com.employee.service.faceId.app.controller;

import co.com.employee.service.faceId.api.IEmployeeAPI;
import co.com.employee.service.faceId.common.request.EmployeeRequest;
import co.com.employee.service.faceId.common.response.EmployeeResponse;
import co.com.employee.service.faceId.common.routes.Router;
import co.com.employee.service.faceId.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(Router.Employee.EMPLOYEE)
public class EmployeeController implements IEmployeeAPI {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll();
    }

    @Override
    public EmployeeResponse findById(@PathVariable("id") long id) throws Exception {
        return employeeService.findById((id));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse create(@RequestBody EmployeeRequest request) throws Exception {
        return employeeService.create(request);
    }

    @Override
    @PutMapping(Router.Employee.UPDATE)
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse update(@PathVariable("id") long id, @RequestBody EmployeeRequest request) throws Exception {
        return employeeService.update(id, request);
    }


}
