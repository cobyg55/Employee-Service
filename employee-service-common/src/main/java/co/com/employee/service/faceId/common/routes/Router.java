package co.com.employee.service.faceId.common.routes;

public class Router {
    public static final String API = "/api";

    public static class Employee {
        public static final String EMPLOYEE = API + "/employee";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
    }

}
