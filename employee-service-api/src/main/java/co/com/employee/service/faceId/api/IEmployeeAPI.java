package co.com.employee.service.faceId.api;

import co.com.employee.service.faceId.common.request.EmployeeRequest;
import co.com.employee.service.faceId.common.response.EmployeeResponse;

import java.util.List;

public interface IEmployeeAPI {

    List<EmployeeResponse> findAll();

    EmployeeResponse findById(long id) throws Exception;

    EmployeeResponse create(EmployeeRequest request) throws Exception;

    EmployeeResponse update(long id, EmployeeRequest request) throws Exception;
}
