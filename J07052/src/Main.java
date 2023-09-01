import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "THISINH.in";
    static final Set<Student> students = new TreeSet<>(new Comparator<Student>() {

        private int compareId(Student student1, Student student2) {
            return student1.getId().compareTo(student2.getId());
        }

        @Override
        public int compare(Student student1, Student student2) {
            if (student1.getSumGrade() != student2.getSumGrade()) {
                return Double.compare(student2.getSumGrade(), student1.getSumGrade());
            } else {
                return compareId(student1, student2);
            }
        }

    });

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            students.add(new Student(
                scanner.nextLine(), 
                scanner.nextLine(), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine())
            ));
        }
        int m = Integer.parseInt(scanner.nextLine());
        Iterator<Student> iterator = students.iterator();
        double ceil = 0;
        while (iterator.hasNext() && m > 0) {
            Student temp = iterator.next();
            temp.setResult("TRUNG TUYEN");
            ceil = temp.getSumGrade();
            m--;
        }
        while(iterator.hasNext()) {
            Student temp = iterator.next();
            if (temp.getSumGrade() == ceil) {
                temp.setResult("TRUNG TUYEN");
            } else {
                temp.setResult("TRUOT");
            }
        }
        System.out.println(ceil);
        students.forEach(e -> System.out.println(e));
    }
}

enum Region {

    KV1(0.5), KV2(1.0), KV3(2.5);

    private double bonus;

    Region(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }
}

class Student {

    private String id;
    private String name;
    private double maths;
    private double physics;
    private double chemistry;
    private double bonus;
    private String result;

    public Student(String id, String name, double maths, double physics, double chemistry) {
        this.id = id;
        this.name = formatName(name);
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
        this.bonus = makeBonus(id);
    }

    private double makeBonus(String id) {
        return Region.valueOf(id.substring(0, 3)).getBonus();
    }

    private String formatName(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : words) {
            stringBuilder.append(
                word.substring(0, 1).toUpperCase() + 
                word.substring(1).toLowerCase() + " "
            );
        }
        return stringBuilder.toString().trim();
    }

    public String getId() {
        return this.id;
    }

    public double getSumGrade() {
        return this.maths * 2 + this.physics + this.chemistry + bonus;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder(id + " " + name);

        boolean flag1 = false;
        boolean flag2 = false;

        if (bonus == (double) ((int) bonus)) {
            flag1 = true;
        }

        double sum = getSumGrade();
        if (sum == (double) ((int) sum)) {
            flag2 = true;
        }

        if (flag1 && flag2) {
            stringBuilder.append(" " + (int) bonus + " " + (int) sum + " " + result);
        } else if (flag1 && !flag2) {
            stringBuilder.append(" " + (int) bonus + " " + sum + " " + result);
        }else if (!flag1 && flag2) {
            stringBuilder.append(" " + bonus + " " + (int) sum + " " + result);
        } else {
            stringBuilder.append(" " + bonus + " " + sum + " " + result);
        }

        return stringBuilder.toString();
    }

}