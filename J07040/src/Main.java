import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static final String FILE_NHI_PHAN = "NHIPHAN.in";
    static final String FILE_VAN_BAN = "VANBAN.in";
    static Set<String> nhiPhan;
    static Set<String> vanBan;

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        nhiPhan = getFrom_NHIPHAN(new ObjectInputStream(new FileInputStream(FILE_NHI_PHAN)));
        vanBan = getFrom_VANBAN(new Scanner(new FileInputStream(FILE_VAN_BAN)));

        for (String e : vanBan) {
            if (nhiPhan.contains(e)) {
                System.out.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    static Set<String> getFrom_NHIPHAN(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        List<String> list = (ArrayList<String>) objectInputStream.readObject();
        Set<String> temp = new LinkedHashSet<>();
        for (String e : list) {
            String[] array = e.trim().split("\\s+");
            for (int i = 0; i < array.length; i++) {
                temp.add(array[i].toLowerCase());
            }
        }
        return temp;
    }

    static Set<String> getFrom_VANBAN(Scanner scanner) {
        Set<String> temp = new LinkedHashSet<>();
        while (scanner.hasNext()) {
            temp.add(scanner.next().toLowerCase());
        }
        return temp;
    }
}
