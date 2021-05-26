import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVinput {

    String csvFile;
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ";";
    ArrayList<String[]> dates = new ArrayList<>();

    public CSVinput() {
        this.csvFile = "G:\\Studium\\Semester 4\\Softwareprojekt\\Projekt\\Daten\\scenario_1.csv";
    }
    public CSVinput(String path) {
        this.csvFile = path;
    }
    public void read(){
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                dates.add(line.split(cvsSplitBy));
                System.out.println(Arrays.toString(dates.get(i)));
                i++;
            }
            System.out.println(dates.get(2)[0]);
            System.out.println(dates.get(0)[0]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public ArrayList<String[]> getDates() {
        return dates;
    }
}
