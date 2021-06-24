import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TXTinput {

    String csvFile;
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = "\t";
    public ArrayList<String[]> dates = new ArrayList<>();

    public TXTinput() {
        //this.csvFile = "C:\\Users\\cicho\\Desktop\\SoftwareProjekt\\Softwareprojekt-main\\Daten\\scenario_1.csv";
        this.csvFile = "G:\\Studium\\Semester4\\Softwareprojekt\\Projekt\\Daten\\scenario_1.csv";
    }
    public TXTinput(String path) {
        this.csvFile = path;
    }
    public void read(){
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator

                dates.add(line.split(cvsSplitBy));
                //System.out.println(Arrays.toString(dates.get(i)));
                i++;
            }
            //TODO Daten formatieren, um sie verarbeitbar zu machen

            Iterator<String[]> iterator = dates.iterator();
            while (iterator.hasNext()) {
                String[] strings = iterator.next();
                if (shouldRemoveCSVSingleLine(strings)) {
                    iterator.remove();
                }

            }

            for (int j = 0; j <dates.size(); j++){
                System.out.println(Arrays.toString(dates.get(j)));
            }


            //System.out.println(dates.get(6)[0]);
            //System.out.println(dates.get(0)[0]);

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

    boolean shouldRemoveCSVSingleLine(String[] csvSingleLine) {
        for (String str : csvSingleLine) {
            if (str != null && !str.equals(" ") || !str.equals(",")) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String[]> getDates() {
        return dates;
    }
}
