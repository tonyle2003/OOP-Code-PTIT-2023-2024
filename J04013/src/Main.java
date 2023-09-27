import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
            new Attendance(
                scanner.nextLine(), 
                scanner.nextLine(), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine())
            )
        );
    }
}

enum Bonus {

    KV1(0.5), KV2(1.0), KV3(2.5);

    private double bonus;

    private Bonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }
}

class Attendance {

    private String id;
    private String fullName;
    private double maths;
    private double physics;
    private double chemicals;

    public Attendance(String id, String fullName, double maths, double physics, double chemicals) {
        this.id = id;
        this.fullName = fullName;
        this.maths = maths;
        this.physics = physics;
        this.chemicals = chemicals;
    }

    public String getStatus() {
        if (this.getTotal() + getBonus() >= 24) {
            return "TRUNG TUYEN";
        } else {
            return "TRUOT";
        }
    }

    public double getTotal() {
        return this.maths * 2 + this.physics + this.chemicals;
    }

    public double getBonus() {
        return Bonus.valueOf(this.id.substring(0, 3)).getBonus();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemicals() {
        return chemicals;
    }

    public void setChemicals(double chemicals) {
        this.chemicals = chemicals;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.id + " " + this.fullName + " ");
        if (this.getBonus() == (double) ((int) this.getBonus())) {
            stringBuffer.append((int) this.getBonus() + " ");
        } else {
            stringBuffer.append(this.getBonus() + " ");
        }
        if (this.getTotal() == (double) ((int) this.getTotal())) {
           stringBuffer.append((int) this.getTotal() + " ");
        } else {
            stringBuffer.append(this.getTotal() + " ");
        }
        return stringBuffer.append(this.getStatus()).toString();
    }
}