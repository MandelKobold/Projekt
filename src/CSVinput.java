import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class CSVinput {

    private String csvFile;
    private BufferedReader br = null;
    private String line = "";
    private String cvsSplitBy = ";";
    private ArrayList<String[]> dates = new ArrayList<>();

    CSVinput() {
        //this.csvFile = "D:\\UniVideos\\Semester_4\\Programmierparadigmen\\Übungen\\Programmieraufgaben\\Scala\\Woche_7\\SoftwareProjekt\\Daten\\scenario_1.csv";
        //this.csvFile = "G:\\Studium\\Semester4\\Softwareprojekt\\Projekt\\Daten\\scenario_1.csv";
    }
    CSVinput(String path) {
        this.csvFile = path;
    }
    void read(){
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                dates.add(line.split(cvsSplitBy));
                //System.out.println(Arrays.toString(dates.get(i)));
                i++;
            }

            Iterator<String[]> iterator = dates.iterator();
            while (iterator.hasNext()) {
                String[] strings = iterator.next();
                if (shouldRemoveCSVSingleLine(strings)) {
                    iterator.remove();
                }

            }

            System.out.println("CSV Input");
            for (int j = 0; j <dates.size(); j++){
                System.out.println(Arrays.toString(dates.get(j)));
            }


        } catch (FileNotFoundException e) {
            ErrorMessage er = new ErrorMessage(false, "Diese Datei konnte nicht gefunden werden");
            er.setVisible(true);
            e.printStackTrace();
        } catch (IOException e) {
            ErrorMessage er = new ErrorMessage(false, "Diese Datei konnte nicht gelesen werden");
            er.setVisible(true);
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    ErrorMessage er = new ErrorMessage(false, "Beim Lesen der Datei ist ein Fehler aufgetreten");
                    er.setVisible(true);
                    e.printStackTrace();
                }
            }
        }

    }

    boolean shouldRemoveCSVSingleLine(String[] csvSingleLine) {
        for (String str : csvSingleLine) {
            if (str != null && !str.equals("")) {
                return false;
            }
        }
        return true;
    }

    ArrayList<String[]> getDates() {
        return dates;
    }
}


