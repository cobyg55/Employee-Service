package co.com.employee.service.faceId.common.response;

import lombok.Data;

@Data
public class EmployeeResponse {

    private long id;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;

}
