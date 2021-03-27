package persistence;

import java.io.*;
import java.util.ArrayList;

public class ManagerFiles {
    FileReader fileReader;
    FileWriter fileWriter;

    public ArrayList<String> readFile(String nameFile) throws IOException {
        ArrayList<String> linesReading = new ArrayList<>();
        fileReader = new FileReader(nameFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineRead;

        while ((lineRead = bufferedReader.readLine())!= null){
            linesReading.add(lineRead);
        }
        bufferedReader.close();
        return linesReading;
    }

    public void writeFile(ArrayList<String> cyclistsList, String file){
        try {
            OutputStream outputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (int i=0; i<cyclistsList.size(); i++){
                bufferedWriter.write(cyclistsList.get(i));
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
