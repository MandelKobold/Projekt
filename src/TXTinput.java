import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.StringBuilder;

public class TXTinput {

    String csvFile;

    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = "\t";
    public ArrayList<String[]> dates = new ArrayList<>();

    public TXTinput() {
        //this.csvFile = "C:\\Users\\cicho\\Desktop\\SoftwareProjekt\\Softwareprojekt-main\\Daten\\scenario_1.csv";
        //this.csvFile = "G:\\Studium\\Semester4\\Softwareprojekt\\Projekt\\Daten\\scenario_1.csv";
    }
    public TXTinput(String path) {
        this.csvFile = path;
    }
    public void read(){
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;

            while ((line = br.readLine()) != null) {
                if (line.length() > 2 && !line.isEmpty() && !line.trim().equals("") && !line.trim().equals("\n")) {
                    // use comma as separator

                    dates.add(line.trim().split(cvsSplitBy));
                    //System.out.println(Arrays.toString(dates.get(i)));
                    i++;
                }else {
                    i++;
                }
            }
            //Daten formatieren, um sie verarbeitbar zu machen

            for (int k = 0; k < dates.size(); k++){
                for (int l = 0; l < dates.get(k).length; l++) {
                    char[] leerzeichenArray = dates.get(k)[l].toCharArray();
                    String leerzeichenloserString = "";
                    for (int m = 0; m < leerzeichenArray.length; m++) {

                        if(leerzeichenArray[m] >= '0'&& leerzeichenArray[m] <= '9'||leerzeichenArray[m] == ','||leerzeichenArray[m] == 'D'||leerzeichenArray[m] == 'G'||leerzeichenArray[m] == 'c'||leerzeichenArray[m] == 'a'){
                            leerzeichenloserString += leerzeichenArray[m];
                            System.out.println(leerzeichenArray[m]);
                        }
                    }
                    //System.out.println(leerzeichenloserString);
                    dates.get(k)[l] = leerzeichenloserString;
                    //System.out.println(dates.get(k)[l]);
                }
            }



            for (int j = 0; j <dates.size(); j++){
                System.out.println(Arrays.toString(dates.get(j)));
            }


            //System.out.println(dates.get(6)[0]);
            //System.out.println(dates.get(0)[0]);

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

    public ArrayList<String[]> getDates() {
        return dates;
    }
}
