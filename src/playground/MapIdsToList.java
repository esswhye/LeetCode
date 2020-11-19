package playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapIdsToList {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            employeeList.add(new Employee(((long) i)));
        }

        Integer[] empIds = {1, 2, 3, 4};

        List<Employee> employeesFound = Stream.of(empIds).map(MapIdsToList::findById).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(employeesFound);

        int sum = employeesFound.stream().mapToInt(value -> Math.toIntExact(value.getId())).sum();

        System.out.println(sum);
    }


    static Employee findById(long id) {
        return employeeList.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

}


class Employee {

    Long id;

    public Employee(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}