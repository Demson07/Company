package working;

import checking.Check;
import checking.StringFormattedException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveAction;

public class Department {

    private String departmentName;
    private final ArrayList<Worker> workers = new ArrayList<Worker>();
    long count;


    public Department(String departmentName) {
        setDepartmentName(departmentName);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = Check.checkSetName(departmentName);
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }


    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public BigDecimal sumSalary (List<Worker> forThis) {

        BigDecimal avgSalary = BigDecimal.ZERO;
        count = forThis.size();

        for (Worker worker : forThis) {
            avgSalary = avgSalary.add(worker.getSalary());
        }
        if (count == 0) {
            throw new ArithmeticException("Пустой массив");
        } else {
            return avgSalary;
        }
    }

    public BigDecimal avgSalary() {

        BigDecimal avgSalary = sumSalary(workers);

        return avgSalary.divide(BigDecimal.valueOf(count), 2, RoundingMode.DOWN);

    }

    public BigDecimal avgSalaryMinus(Worker worker) {
        List<Worker> oneTimeList = new ArrayList<>(workers);
        oneTimeList.remove(worker);
        return sumSalary(oneTimeList).divide(BigDecimal.valueOf(count), 2, RoundingMode.DOWN);

    }

    public BigDecimal avgSalaryPlus(Worker worker) {
        List<Worker> oneTimeList = new ArrayList<>(workers);
        oneTimeList.add(worker);
        return sumSalary(oneTimeList).divide(BigDecimal.valueOf(count), 2, RoundingMode.DOWN);
    }


}
