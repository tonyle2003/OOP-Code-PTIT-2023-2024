import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MakeFile {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream("DATA.in"));
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 19; i++) {
            list.add(997);
        }
        for (int i = 1; i <= 6; i++) {
            list.add(29);
        }
        for (int i = 1; i <= 41; i++) {
            list.add(23);
        }
        for (int i = 1; i <= 13; i++) {
            list.add(19);
        }
        for (int i = 1; i <= 17; i++) {
            list.add(17);
        }
        for (int i = 1; i <= 88; i++) {
            list.add(13);
        }
        for (int i = 1; i <= 230; i++) {
            list.add(11);
        }
        for (int i = 1; i <= 49; i++) {
            list.add(7);
        }
        for (int i = 1; i <= 169; i++) {
            list.add(5);
        }
        for (int i = 1; i <= 1321; i++) {
            list.add(3);
        }
        fileOutputStream.writeObject(list);
        fileOutputStream.close();
    }
}
