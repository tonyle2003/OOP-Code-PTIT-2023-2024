import java.util.ArrayList;
import java.util.Scanner;

import view.InvoiceView;
import vn.edu.ptit.Invoice;
import vn.edu.ptit.Rule;
import vn.edu.ptit.Student;
import vn.edu.ptit.Subject;

public class Main {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        // Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}

class PaymentController {
    static Scanner scanner = new Scanner(System.in, "UTF-8");

    Invoice invoice;

    public PaymentController() {
        this.invoice = createInvoice();
    }

    public Invoice createInvoice() {
        Invoice newInvoice = new Invoice(new Rule());
        newInvoice.setSt(getStudent());
        newInvoice.setAlSubject(getSubjects(Integer.parseInt(scanner.nextLine())));
        newInvoice.setRule(getRule());
        int count = 0;
        for (int i = 0; i < newInvoice.getAlSubject().size(); i++) {
            count += newInvoice.getAlSubject().get(i).getCredit();
        }
        newInvoice.setAmount(count * newInvoice.getRule().getCreditPrice());
        return newInvoice;
    }

    public Student getStudent() {
        return new Student(
            scanner.nextLine(), 
            scanner.nextLine()
        );
    }

    public Rule getRule() {
        return new Rule(
            scanner.nextLine(), 
            scanner.nextLine(), 
            Double.parseDouble(scanner.nextLine())
        );
    }
    
    public ArrayList<Subject> getSubjects(int size) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String name, code;
        int credit;
        for (int i = 0; i < size; i++) {
            code = scanner.nextLine();
            name = scanner.nextLine();
            credit = Integer.parseInt(scanner.nextLine());
            subjects.add(
                new Subject(name, code, credit)
            );
        }
        return subjects;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }
}
