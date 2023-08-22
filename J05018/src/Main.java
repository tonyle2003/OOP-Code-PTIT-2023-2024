import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        n = scanner.nextInt();
        scanner.nextLine();
        while (n > 0) {
            n--;
            students.add(
                new Student(
                    scanner.nextLine(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble(), 
                    scanner.nextDouble()
                )
            );
            scanner.nextLine();
        }
        students.sort(Comparator.naturalOrder());
        students.forEach(e -> System.out.println(e));
    }
}

class Student implements Comparable<Student> {
    private static int hiddenId = 1;
    private String id;
    private String fullName;
    private double toan;
    private double tiengViet;
    private double ngoaiNgu;
    private double vatLy;
    private double hoaHoc;
    private double sinhHoc;
    private double lichSu;
    private double diaLy;
    private double gdcd;
    private double congNghe;
    private double averageScore;
    private String xepLoai;

    public Student() {
    }

    public Student(String fullName, double toan, double tiengViet, double ngoaiNgu, double vatLy, double hoaHoc,
            double sinhHoc, double lichSu, double diaLy, double gdcd, double congNghe) {
        this.id = createId();
        this.fullName = fullName;
        this.toan = toan;
        this.tiengViet = tiengViet;
        this.ngoaiNgu = ngoaiNgu;
        this.vatLy = vatLy;
        this.hoaHoc = hoaHoc;
        this.sinhHoc = sinhHoc;
        this.lichSu = lichSu;
        this.diaLy = diaLy;
        this.gdcd = gdcd;
        this.congNghe = congNghe;
        this.averageScore = calculateAverage();
        this.xepLoai = setXepLoai();
    }
    
    private String setXepLoai() {
        if (averageScore >= 9) {
            return "XUAT SAC";
        } else if (averageScore >= 8) {
            return "GIOI";
        } else if (averageScore >= 7) {
            return "KHA";
        } else if (averageScore >= 5) {
            return "TB";
        } else {
            return "YEU";
        }
    }

    private double calculateAverage() {
        return Math.round((toan * 2 + tiengViet * 2 + ngoaiNgu + vatLy + hoaHoc + sinhHoc + lichSu + diaLy + gdcd + congNghe) / 12 *  10) / (double) 10;
    }
    
    private String createId() {
        String result = "HS";
        if (hiddenId < 10) {
            result += "0" + hiddenId;
        } else {
            result += hiddenId;
        }
        hiddenId++;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", id, fullName, averageScore, xepLoai);
    }

    private int compareId(Student other) {
        return this.id.compareTo(other.id);
    }
    
    @Override
    public int compareTo(Student other) {
        if (this.averageScore == other.averageScore) {
            return compareId(other);
        } else {
            return Double.compare(other.averageScore, this.averageScore);
        }
    }
}
