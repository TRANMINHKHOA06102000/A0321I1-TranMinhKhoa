package b16_io_text_file.read_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    public static void main(String[] args) {
        String pathDemo = "D:\\WORKSPACE\\DEMO_CODEGYM\\module02\\Demo-A03\\src\\b16_io_text_file\\read_csv\\demo.csv";
        String line = "";
        final String CSVSPLITBY = ",";
        writeCsv(pathDemo);
        List<Country> countryList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathDemo));
            Country countryOb = null;
            while ((line = bufferedReader.readLine())!= null){
                String[] country = line.split(CSVSPLITBY);
                countryOb = new Country(country[0],country[1],country[2],country[3],country[4],country[5]);
                countryList.add(countryOb);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeCsv(String path){
        try {
       Country country = new Country("1.0.0.0", "1.0.7.255", "1312321321","312321321","VN", "Viet Nam");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write(country.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
