package output;

import working.Department;
import working.Worker;

import java.util.*;

public interface PossibleTransfer {
    static void possibleTransferSoloOption(Map<String, Department> departmentMap) {
        try {
            departmentMap
                    .forEach((k, department) -> {
                        Map<String, Department> departmentMapNew = new LinkedHashMap<>(departmentMap);
                        departmentMapNew.remove(k);
                        for (Worker worker : department.getWorkers()) {
                            departmentMapNew.forEach((k2, departmentNew) -> {
                                if ((department.avgSalary().compareTo(worker.getSalary()) > 0) &&
                                        (departmentNew.avgSalary().compareTo(worker.getSalary()) < 0)) {
                                    System.out.printf("Name: %s Salary: %.2f From: %s AvgSalary Before::After: %.2f::%.2f To: %s AvgSalary" +
                                                    " Before::After: %.2f::%.2f\n", worker.getName(), worker.getSalary(),
                                            k, department.avgSalary(), department.avgSalaryMinus(worker ), k2,
                                            departmentNew.avgSalary(), departmentNew.avgSalaryPlus(worker));
                                }
                            });
                        }
                    });

        }catch (ArithmeticException e) {
            e.getMessage();
        }
    }

}
