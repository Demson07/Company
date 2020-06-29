package working;

import checking.Check;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Worker {
    private String name;
    private BigDecimal salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Check.checkSetName(name);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = Check.checkSetSalary(salary).setScale(2, RoundingMode.DOWN);

    }

    public void installToDepartment(Map<String, Department> departmentStringLinkedHashMap, String depName) {
        if (departmentStringLinkedHashMap.isEmpty()) {
            Department department = new Department(depName);
            department.addWorker(this);
            departmentStringLinkedHashMap.put(depName, department);
        } else {
            if (departmentStringLinkedHashMap.containsKey(depName)) {
                departmentStringLinkedHashMap.get(depName).addWorker(this);
            } else {
                Department department = new Department(depName);
                department.addWorker(this);
                departmentStringLinkedHashMap.put(depName, department);
            }
        }

    }
}

