import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class formatDates {

    ArrayList<double[]> ret = new ArrayList<>();

    void format(ArrayList<String[]> dates){
        double[] platz = new double[dates.get(2).length];
        //Platzhalter zwischen den DMs
        platz[0] = 1.0;
        int z = 1;
        for (int i = 1; i < platz.length; i++) {
            platz[i] = -1.0;
        }
        //beginnend mit den Bewertungen vom ersten dm jede Zeile durch gehen
        //wann der Platzhalter eingesetzt wird, muss variabel gemacht werden
        while((dates.get(z)[0].charAt(0)) !=  'D'){
            z++;
        }
        for (int i =2; i<dates.size(); i++) {
            //Platzhalter insert nach jedem dm

            if (i % z == 0) {
                ret.add(platz);
                i = i + 2;
            }
            //neues Array erstellen
            double[] werte = new double[platz.length];
            //gewicht in double umwandeln, komma durch Punkt ersetzen und aufrunden
            if(!dates.get(i)[0].isEmpty()) {
                werte[0] = BigDecimal.valueOf(Double.parseDouble(dates.get(i)[0].replace(",", "."))).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }else{
                werte[0] = 42.42;
            }
                werte[1] = -2;
                for (int j = 2; j < dates.get(2).length; j++) {
                    //bewertungen in double umwandeln, komma durch Punkt ersetzen und aufrunden
                    if(!dates.get(i)[j].isEmpty()) {
                        werte[j] = BigDecimal.valueOf(Double.parseDouble(dates.get(i)[j].replace(",", "."))).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    }else{
                        werte[j] = 42.42;
                    }
                }

            ret.add(werte);
        }
        //Output der Matrix in der nur noch Double drin stehen
        /*
        System.out.println("Herbert diese Werte sind formatiert");
        for (int k = 0; k < ret.size(); k++) {

            System.out.println(Arrays.toString(ret.get(k)));
        }
        */
    }

    public boolean gewichtungenPruefen(){
        boolean gewichtung = false;
        for (int i = 0; i <ret.size() ; i++) {
            if(ret.get(i)[0] < 0 || ret.get(i)[0] > 1 && ret.get(i)[0] != 42.42) {
                gewichtung = true;
                break;
            }
        }
        return gewichtung;
    }

    public boolean bewertungenPruefen(){
        boolean bewertung = false;
        for (int i = 0; i <ret.size() ; i++) {
            for (int j = 2; j <ret.get(i).length ; j++) {
                if((ret.get(i)[j] < 0 || ret.get(i)[j] > 1)&&ret.get(i)[j] != 42.42){
                    if(ret.get(i)[1] == -2) {
                        bewertung = true;
                        break;
                    }
                }
            }
        }
        return bewertung;
    }

    public ArrayList<double[]> getRet() {
        return ret;
    }
}
