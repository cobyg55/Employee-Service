package co.com.employee.service.faceId.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
    private long id;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;
}
