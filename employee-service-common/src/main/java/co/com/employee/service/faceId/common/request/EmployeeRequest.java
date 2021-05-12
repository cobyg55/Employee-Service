package co.com.employee.service.faceId.common.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;
}
