package TryCatchFileHandling;

import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        String readline;
        String sourceFile = "TryCatchFileHandling/input.txt";
        String destinationFile = "TryCatchFileHandling/copy.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            while ((readline = reader.readLine()) != null) {
                writer.write(readline);
                writer.newLine();
            }

            System.out.println("File had been copied.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
