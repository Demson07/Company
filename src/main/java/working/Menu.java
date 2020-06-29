package working;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Menu {

    private static final Scanner scan = new Scanner(System.in);

    public void menuAction(Map<String, Department> departments) {
        System.out.print("Do you want to transfer an employee to another Working Department: (yes/no) >");
        String menuAnswer = scan.next();
        menuAnswer(menuAnswer, departments);
    }

    public void menuAnswer (String menuAnswer, Map<String, Department> departments) {
        if ("yes".equals(menuAnswer.toLowerCase())) {
            departments.forEach((k, v) -> System.out.println("\"" + k + "\""));
            System.out.println("Which work department do you want to change: >");
            String answerDepartment = scan.next();
            if (!departments.containsKey(answerDepartment)) {
                System.out.println("There is no Working.Department under this number");
            } else {
                changeDepartment(departments.get(answerDepartment), departments);
            }
        }
    }

    public void changeDepartment (Department departmentOut, Map<String, Department> departments) {
        for (int i = 0; i < departmentOut.getWorkers().size(); i++) {
            System.out.println(i+1 + ":" + departmentOut.getWorkers().get(i).getName());
        }
        System.out.print("\nChose worker: >");
        int numberWorker = Integer.parseInt(scan.next()) - 1;
        if (numberWorker > departmentOut.getWorkers().size()) {
            System.out.println("There is no employee under this number");
        } else {
            Map<String, Department> otherDepartments = new LinkedHashMap<>(departments);
            otherDepartments.remove(departmentOut.getDepartmentName());
            try {
                Department departmentIn = whichDepartment(otherDepartments);
                departmentIn.addWorker(departmentOut.getWorkers().get(numberWorker));
                departmentOut.getWorkers().remove(departmentOut.getWorkers().get(numberWorker));
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println(exception);
            }
        }
    }

    Department whichDepartment (Map<String, Department> departmentIn) {
        System.out.println();
        departmentIn.forEach((k, v) -> System.out.println("\"" + k + "\""));
        System.out.println("Which department to transfer?");
        String whatIsDepartment = scan.next();
        if (departmentIn.containsKey(whatIsDepartment)) {
            return departmentIn.get(whatIsDepartment);
        } else {
            throw new ArrayIndexOutOfBoundsException("Wrong department selected.");
        }
    }
}
