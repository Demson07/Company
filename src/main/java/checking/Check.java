package checking;

import java.math.BigDecimal;

public class Check implements CheckLine {

    public static BigDecimal checkSetSalary(String str) {
        if (str.matches("[0-9]+.?([0-9]+)?")) {
            return new BigDecimal(str);
        } else if (str.isEmpty()){
            throw new NullPointerException("Пустое поле с зарплатой работника:");
        } else {
            throw new NumberFormatException("Неправильное введена зарплата:");
        }
    }

    public static String checkSetName(String str) {
        if (str.matches("[0-9]+")) {
            throw new StringFormattedException("Неправильно введено имя работника:");
        } else if (str.isEmpty()) {
            throw new NullPointerException("Пустое поле с именем работника:");
        } else {
            return str;
        }
    }

/*    public static String checkDepartment (String str) {
        if (str.isEmpty()) {
            throw  new NullPointerException("Не назван отдел.");
        } else {
            return str;
        }
    }
 */

    @Override
    public String[] checkLine(String args) {
        if (args == null || args.isEmpty()) {
            throw new NullPointerException("Пустая строка файла:");
        }
        String[] line = args.split(";");
        if (line.length != 3) {
            throw new ArrayIndexOutOfBoundsException("Неправильный ввод данных:");
        } else {
            return line;
        }
    }
}