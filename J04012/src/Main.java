import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Staff(
                scanner.nextLine(),
                Long.parseLong(scanner.nextLine()),
                Long.parseLong(scanner.nextLine()),
                Role.valueOf(scanner.nextLine())));
    }
}

enum Role {
    GD(250000),
    PGD(200000),
    TP(180000),
    NV(150000);

    private long allowance;

    private Role(long allowance) {
        this.allowance = allowance;
    }

    public long getAllowance() {
        return this.allowance;
    }
}

class Staff {

    private String id;
    private String name;
    private long baseSalary;
    private long workdays;
    private Role role;

    public Staff(String name, long baseSalary, long workdays, Role role) {
        this.id = "NV01";
        this.name = name;
        this.baseSalary = baseSalary;
        this.workdays = workdays;
        this.role = role;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.getSalary() + " " + this.getBonus() + " " + this.getAllowance()
                + " " + this.getTotal();
    }

    public long getTotal() {
        return this.getSalary() + this.getBonus() + this.getAllowance();
    }

    public long getAllowance() {
        return this.role.getAllowance();
    }

    public long getBonus() {
        if (workdays >= 25) {
            return this.getSalary() / 5;
        } else if (workdays >= 22) {
            return this.getSalary() / 10;
        } else {
            return 0;
        }
    }

    public long getSalary() {
        return this.baseSalary * workdays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getbaseSalary() {
        return baseSalary;
    }

    public void setbaseSalary(long baseSalary) {
        this.baseSalary = baseSalary;
    }

    public long getWorkdays() {
        return workdays;
    }

    public void setWorkdays(long workdays) {
        this.workdays = workdays;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}