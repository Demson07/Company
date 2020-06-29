package output;

import working.Department;

import java.util.ArrayList;
import java.util.Map;

public class TextOutput {
    public void out (Map<String, Department> departments) {
        int bigWord = 0;
        ArrayList<String> departmentList = new ArrayList<>(departments.keySet());
        for (String name : departmentList) {
            if (name.length() > bigWord) {
                bigWord = name.length();
            }
        }
        int finalBigName = bigWord;
        departments.forEach((k, v) -> System.out.printf("%"+ finalBigName +"s :: %10.2f :: total number of workers:" +
                " %d\n", k, v.avgSalary(), v.getWorkers().size()));
    }
}
