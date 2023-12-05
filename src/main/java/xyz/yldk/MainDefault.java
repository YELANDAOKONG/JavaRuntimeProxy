package xyz.yldk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try (BufferedReader reader = new BufferedReader(new FileReader("proxy.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Process process = Runtime.getRuntime().exec(line);
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.err.println("Process exited with code " + exitCode);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error reading or executing proxy.txt: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
