import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Teacher(scanner.nextLine(), scanner.nextLine(), scanner.nextLong()));
    }
}

enum TeacherLevel {
    HT(2000000),
    HP(900000),
    GV(500000);

    private int allowance;

    TeacherLevel(int allowance) {
        this.allowance = allowance;
    }

    public int getAllowance() {
        return this.allowance;
    }
}

class Teacher {

    private String id;
    private String fullName;
    private long baseSalary;

    public Teacher(String id, String fullName, long baseSalary) {
        this.id = id;
        this.fullName = fullName;
        this.baseSalary = baseSalary;
    }

    private long calculateIncome() {
        return baseSalary * getLevel() + getAllowance();
    }

    private int getAllowance() {
        // for (TeacherLevel teacherLevel : TeacherLevel.values()) {
        //     if (teacherLevel.name().equals(id.subSequence(0, 2)))) {
        //         return teacherLevel.getAllowance();
        //     }
        // }
        // return 0;
        return TeacherLevel.valueOf(id.subSequence(0, 2) + "").getAllowance();
    }

    private int getLevel() {
        return Integer.parseInt(id.subSequence(2, 4) + "");
    }

    @Override
    public String toString() {
        return id + " " + fullName + " " + getLevel() + " " + getAllowance() + " " + calculateIncome();
    }

}
