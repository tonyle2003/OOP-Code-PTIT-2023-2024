import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private final static String FILE_NAME = "CATHI.in";
    private static List<Examination> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        int n = Integer.parseInt(reader.readLine());
        while (n > 0) {
            n--;
            list.add(new Examination(reader.readLine(), reader.readLine(), reader.readLine()));
        }
        reader.close();
        list.stream()
            .sorted(Comparator.comparing(Examination::getDate)
                    .thenComparing(Examination::getTime)
                    .thenComparing(Examination::getId))
            .forEach(e -> System.out.println(e.getId() + " " + e.getDate() + " " + e.getTime() + " " + e.getRoomId()));
    }

}

class Examination {

    private static int autoIncrese = 0;
    private String id;
    private String date;
    private String time;
    private String roomId;

    public Examination(String date, String time, String roomId) {
        this.id = String.format("C%03d", ++autoIncrese);
        this.date = date;
        this.time = time;
        this.roomId = roomId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setId(String id) {
        this.id = id;
    }
}