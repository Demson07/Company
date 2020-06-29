import checking.Check;
import checking.StringFormattedException;
import output.PossibleTransfer;
import working.*;
import output.TextOutput;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class WorkerInformation {
    static final Map<String, Department> departments = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {

        String file = (args.length == 0 ? "test.csv" : args[0]);

        // открываем файл
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // считываем построчно
        String line;

        while ((line = reader.readLine()) != null) {
            Worker worker = new Worker();
            Check check = new Check();
            try {
                String[] dataLine = check.checkLine(line);
                worker.setName(dataLine[0]);
                worker.setSalary(dataLine[1]);
                worker.installToDepartment(departments, dataLine[2]);
            } catch (NullPointerException | StringFormattedException | ArrayIndexOutOfBoundsException exception) {
                System.out.println(exception + line);
            } catch (NumberFormatException exception) {
                System.out.println(exception + " Зарплата поставить по умолчанию: 0 " + line);
                worker.setSalary("0");
            }
        }



        // закрываем наш ридер
        reader.close();

//         Открываем меню для действии программы.
        Menu menu = new Menu();
        menu.menuAction(departments);

        // Отформатированный вывод
        System.out.println("\n");

//        TextOutput textOutput = new TextOutput();
//        textOutput.out(departments);

        System.out.println("\n");


//        Возможный перевод одного сотрудника между отделами при условии, что средняя зарплата увеличиться в двух
//        отделах
        PossibleTransfer.possibleTransferSoloOption(departments);


        System.out.println("\n");


    }
}
