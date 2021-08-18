package b16_io_text_file.copy_file;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        File inputFile = new File("src/b16_io_text_file/copy_file/input.txt");
        File outputFile = new File("src/b16_io_text_file/copy_file/output.txt");

        if (!inputFile.exists()){
            System.out.println("File not found");
        }else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    bufferedWriter.write(line + "\n");
                }
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
