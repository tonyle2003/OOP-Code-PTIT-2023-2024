import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    private static final String FILE_NAME = "MATRIX.in";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int test = Integer.parseInt(scanner.nextLine());
        while (test > 0) {
            test--;
            String[] temp = scanner.nextLine().trim().split("\\s+");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int index = Integer.parseInt(temp[2]);
            int[][] matrix = new int[n][m];
            String[] data = scanner.nextLine().trim().split("\\s+");
            int pointer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(data[pointer]);
                    pointer++;
                }
            }
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (matrix[j][index - 1] > matrix[k][index - 1]) {
                        int swapper = matrix[j][index - 1];
                        matrix[j][index - 1] = matrix[k][index - 1];
                        matrix[k][index - 1] = swapper;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
