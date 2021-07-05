import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.SocketHandler;


public class NWA {

    ArrayList<double[]> dates;
    ArrayList<Double> result;
    public NWA() {}

    //hier nutzwertanalyse bitte
    public void nutzwertMultiply(){
        ArrayList<double[]> multnwa = new ArrayList<>();
        //alle Gewichte mit Bewertungen multiplizieren

        for (int i = 0; i<dates.size(); i++) {
            double[] multiplied = new double[dates.get(2).length-2];
            for (int j = 2; j <dates.get(2).length; j++) {
                if(dates.get(i)[j] != 42.42) {
                    multiplied[j - 2] = dates.get(i)[0] * dates.get(i)[j];
                }
            }
            multnwa.add(multiplied);
        }

/*
        System.out.println("NWA multipliziert");
        for (int j = 0; j <multnwa.size() ; j++) {
            System.out.println(Arrays.toString(multnwa.get(j)));
        }
*/
        nutzwertAdd(multnwa);

    }
    void nutzwertAdd(ArrayList<double[]> multnwa){
        double singelSum = 0.0;
        result = new ArrayList<>();
        for (int i = 0; i < multnwa.get(0).length; i++) {
            for (int j = 0; j <multnwa.size() ; j++) {
                if(multnwa.get(j)[i] != 42.42){
                    singelSum += multnwa.get(j)[i];
                }
            }
            //Daten Formatieren (Manuelles runden :[)
            singelSum *=100;
            int caster = (int) singelSum;
            if(singelSum - caster > 0.5){
                caster+=1;
            }
            singelSum = caster;
            singelSum /=100;
            //Summen zur Ergebnisliste adden
            result.add(singelSum);
            singelSum = 0;
        }
        /*
        System.out.println("NWA FINALY");
        System.out.println(result.toString());
         */
    }

    public void prepareNWA(ArrayList<double[]> AGG, ArrayList<ArrayList<Double>> rndmWeteAGG){
        // um die alte AGG zu behalten brauchen wir ein deep copy
        ArrayList<double[]> newAGG = new ArrayList<>();
        for (int i = 0; i <AGG.size() ; i++) {
            double[] row = Arrays.copyOf(AGG.get(i),AGG.get(i).length);
            newAGG.add(row);
        }
        //neue AGG durchgehen und einen passenden Zufallswert inserten
        for (int i = 0; i < newAGG.size(); i++) {
            for (int j = 0; j <newAGG.get(i).length ; j++) {
                if(newAGG.get(i)[j] > 1 && newAGG.get(i)[j] != 42.42){
                    int index = (int) newAGG.get(i)[j];
                    //index des random Werts aussuchen
                    int chooseRndmWert = (int) (Math.random()*10)%rndmWeteAGG.get(index).size();
                    newAGG.get(i)[j] = rndmWeteAGG.get(index).get(chooseRndmWert);
                }
            }
        }
        //Output der Matrix mit den eingesetzten Zufallzahlen
/*
        System.out.println("READY FOR SOME NWA ACTION");
        for (int i = 0; i < AGG.size(); i++) {
            System.out.println(Arrays.toString(AGG.get(i)));
        }
*/
        this.dates = newAGG;

    }

    public ArrayList<double[]> getDates() {
        return dates;
    }

    public ArrayList<Double> getResult() {
        return result;
    }
}
