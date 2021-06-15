import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class NWA {

    ArrayList<double[]> dates;
    ArrayList<double[]> nwa;

    public NWA(ArrayList<double[]> dates) {
        this.dates = dates;
    }

    public NWA() {

    }

    //hier nutzwertanalyse bitte
    public void nutzwertMultiply(){
        ArrayList<double[]> multnwa = new ArrayList<>();
        //alle Gewichte mit Bewertungen multiplizieren
        for (int i = 0; i<dates.size(); i++) {
            double[] multiplied = new double[dates.get(2).length-2];
            for (int j = 2; j <dates.get(2).length; j++) {
                multiplied[j-2] = dates.get(i)[0]*dates.get(i)[j];
            }
            multnwa.add(multiplied);
        }
        for (int j = 0; j <multnwa.size() ; j++) {
            System.out.println(Arrays.toString(multnwa.get(j)));
        }
        //nutzwertAdd();

    }
    public void nutzwertAdd(){
        double addition;
        ArrayList<double[]> ret = new ArrayList<>();
        int round;
        double[] add = new double[dates.get(2).length];

        for (int i = 0; i < dates.get(2).length; i++){
            addition = 0.0;
            int j = 0;

            while(dates.get(j)[i] != 1.0){
                round = (int)(dates.get(j)[i]*100);
                addition += round;
                j++;
            }
            add[i] = addition/100;

        }
        ret.add(add);
        for (int k = 0; k < ret.size(); k++) {
            System.out.println(Arrays.toString(ret.get(k)));
        }
        this.nwa = ret;
    }

    public ArrayList<double[]> getNwa() {
        return nwa;
    }
}
