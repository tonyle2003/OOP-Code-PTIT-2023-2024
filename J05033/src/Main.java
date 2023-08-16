import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static List<Time> timeList = new ArrayList<>();

    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            timeList.add(new Time(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        timeList.sort(Comparator.naturalOrder());
        timeList.forEach(e -> {
            System.out.println(e);
        });
    }
}

interface TimeComparable extends Comparable<Time> {

    int compareMinute(Time obj);
    int compareSecond(Time obj);
}

class Time implements TimeComparable {

    int hour;
    int minute;
    int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public int compareMinute(Time obj) {
        if (this.minute == obj.minute) {
            return compareSecond(obj);
        } else if (this.minute < obj.minute) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int compareSecond(Time obj) {
        return Integer.compare(this.second, obj.second);
    }

    @Override
    public int compareTo(Time obj) {
        if (this.hour == obj.hour) {
            return compareMinute(obj);
        } else if (this.hour < obj.hour) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.hour + " " + this.minute + " " + this.second;
    }
}