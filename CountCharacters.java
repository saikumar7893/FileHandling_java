import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Characters {
    public static void main(String[] args) {
        BufferedReader reader = null;
        int count = 0;
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Input:filePath ");
            String path=sc.next();
            reader = new BufferedReader(new FileReader(path));

            int ch = reader.read();

            while (ch != -1) {
                count++;
                ch = reader.read();
                System.out.print((char)ch);
            }
            System.out.println("No of characters in the file are" + count);
        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("error:" + e.getMessage());
            }
        }
    }
}