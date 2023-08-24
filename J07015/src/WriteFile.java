import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteFile {
    static ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
            11, 997, 997, 997, 997, 997, 997, 997, 997));
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream("SONGUYEN.in"));
        objectInputStream.writeObject(arrayList);
        objectInputStream.close();
    }
}
