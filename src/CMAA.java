import java.util.ArrayList;
import java.util.Arrays;

public class CMAA {

    ArrayList<double[]> dates;
    public CMAA(ArrayList<double[]> dates) {
        this.dates = dates;
    }

    /*
    Idee:
    prüfen, ob es unterschiede gibt, bei den Bewertungen, wenn es Unterschiede gibt, den Ort und die werte merken, damit das bei der NWA beachtet werden kann
     */

    //Unterschiedliche DMs in einzelne ArrayListen werfen, damit man die vergleichen kann
    ArrayList<ArrayList<double[]>> split(){
        ArrayList<double[]> dm = new ArrayList<>();
        ArrayList<ArrayList<double[]>> cm = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            if(i == 0 || dates.get(i)[1]==-1.0) {
                dm = new ArrayList<>();
                cm.add(dm);
            }
            dm.add(dates.get(i));

        }
        System.out.println("SPLIT");
        for (int i = 0; i <cm.size() ; i++) {
            System.out.println("Herbert die ist eine Arrayliste");
            for (int j = 0; j < cm.get(i).size(); j++) {
                System.out.println(Arrays.toString(cm.get(i).get(j)));
            }
        }
        return cm;
    }

    void compare(){
        ArrayList<ArrayList<double[]>> dates = split();
        ArrayList<double[]> nwaready = new ArrayList<>();
        for (int i = 0; i <dates.size() ; i++) {
            double[] date = new double[dates.get(0).get(0).length];
            nwaready.add(date);
            for (int j = 0; j < date.length; j++) {
                date[j] = -5;
            }
        }
        ArrayList<ArrayList<Double>> rndm = new ArrayList<>();
        ArrayList<Double> f = new ArrayList<>(); //filler to begin ArrayList with index 2
        rndm.add(f);
        rndm.add(f);
        double cmpr = -1;
        int count = 2;
        for (int i = 0; i < dates.get(0).size() -1; i++) //inner ArrayList ablaufen
        {
            for (int j = 0; j <dates.get(0).get(0).length ; j++) //Array ablaufen
            {
                for (int k = 0; k < dates.size(); k++) //outer ArryList ablaufen
                {
                    cmpr = dates.get(0).get(i)[j];
                    //wenn das Gewicht/die Bewertung vom ersten dm von einem anderen dm abweicht neue ArrayList erstellen und Gewicht aufnehmen
                    boolean different = false;
                    if(dates.get(k).get(i)[j] != cmpr){
                        ArrayList<Double> d = new ArrayList<>();
                        if(!different) {
                            d.add(cmpr);
                            different = true;
                        }
                        d.add(dates.get(k).get(i)[j]);
                        rndm.add(d);
                    }
                }
            }
        }
        for (int i = 0; i <nwaready.size() ; i++) {
            System.out.println(Arrays.toString(nwaready.get(i)));
        }

    }

}
