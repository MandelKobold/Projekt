import java.util.ArrayList;
import java.util.Arrays;

public class CMAA {

    ArrayList<double[]> dates;
    ArrayList<double[]> AGG;
    ArrayList<ArrayList<Double>> rndmWeteAGG;

    public CMAA(ArrayList<double[]> dates) {
        this.dates = dates;
    }

    /*
    Idee:
    prüfen, ob es unterschiede gibt, bei den Bewertungen, wenn es Unterschiede gibt, den Ort und die werte merken, damit das bei der NWA beachtet werden kann
     */

    //Unterschiedliche DMs in einzelne ArrayListen werfen, damit man die vergleichen kann
    ArrayList<ArrayList<double[]>> split(){
        ArrayList<double[]> dmMatrix = new ArrayList<>();
        ArrayList<ArrayList<double[]>> listeMitDMMatritzen = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            if(i == 0 || dates.get(i)[1]==-1.0) {
                if(dates.get(i)[1]==-1.0){
                    i++;
                }
                dmMatrix = new ArrayList<>();
                listeMitDMMatritzen.add(dmMatrix);
            }
            dmMatrix.add(dates.get(i));

        }
        /*
        System.out.println("SPLIT");
        for (int i = 0; i <listeMitDMMatritzen.size() ; i++) {
            System.out.println("Herbert dies ist eine Arrayliste");
            for (int j = 0; j < listeMitDMMatritzen.get(i).size(); j++) {
                System.out.println(Arrays.toString(listeMitDMMatritzen.get(i).get(j)));
            }
        }
        */
        return listeMitDMMatritzen;
    }

    void compare(){
        ArrayList<ArrayList<double[]>> listeMitDMMatritzen = split();
        AGG = new ArrayList<>();
        for (int i = 0; i <listeMitDMMatritzen.get(0).size() ; i++) {
            double[] date = new double[listeMitDMMatritzen.get(0).get(0).length];
            AGG.add(date);
            Arrays.fill(date,-5);
        }
        rndmWeteAGG = new ArrayList<>();
        ArrayList<Double> f = new ArrayList<>(); //filler to begin ArrayList with index 2
        rndmWeteAGG.add(f);
        rndmWeteAGG.add(f);
        double cmpr;
        int count = 2;
        boolean different = false;
        for (int i = 0; i < listeMitDMMatritzen.get(0).size(); i++) //inner ArrayList ablaufen
        {
            for (int j = 0; j <listeMitDMMatritzen.get(0).get(0).length ; j++) //Array ablaufen
            {
                ArrayList<Double> listeDerWerteDieSichUnterscheiden = new ArrayList<>();
                for (int k = 0; k < listeMitDMMatritzen.size(); k++) //outer ArryList ablaufen
                {
                    //ersten Wert als vergleichswert speichern
                    cmpr = listeMitDMMatritzen.get(0).get(i)[j];
                    //wenn das Gewicht/die Bewertung vom ersten dm von einem anderen dm abweicht neue ArrayList erstellen und Gewicht aufnehmen
                    if(listeMitDMMatritzen.get(k).get(i)[j] != cmpr && listeMitDMMatritzen.get(k).get(i)[j] != -1 ){
                        //wenn ein Unterschied gefunden wurde, muss der Wert aus der ersten Matrix beim ersten mal mit in die Liste der gemerkten Unterschiede
                        if(!different) {
                            listeDerWerteDieSichUnterscheiden.add(cmpr);
                            different = true;
                        }
                        //verhindern, dass doppelte Werte gespeichert werden
                        if(!listeDerWerteDieSichUnterscheiden.contains(listeMitDMMatritzen.get(k).get(i)[j])) {
                            listeDerWerteDieSichUnterscheiden.add(listeMitDMMatritzen.get(k).get(i)[j]);
                        }
                        rndmWeteAGG.add(listeDerWerteDieSichUnterscheiden);
                    }
                }
                //wenn wir einen unterschied gefunden haben müssen wir an die Stelle den Marker für die Liste setzen, ansonsten den Wert
                if(different){
                    AGG.get(i)[j] = count;
                    count++;
                }else {
                    AGG.get(i)[j] = listeMitDMMatritzen.get(0).get(i)[j];
                }
                //for next field in the matrix the difference ist false
                different = false;
            }
        }
        /*
        System.out.println("AGG mit Platzhalter");
        for (int i = 0; i <AGG.size() ; i++) {
            System.out.println(Arrays.toString(AGG.get(i)));
        }
         */
        /*
        System.out.println("rndm werte fuer AGG");
        for (int i = 0; i < rndmWeteAGG.size(); i++) {
            System.out.println(rndmWeteAGG.get(i).toString());
        }
         */

    }

    public ArrayList<ArrayList<Double>> getRndmWeteAGG() {
        return rndmWeteAGG;
    }

    public ArrayList<double[]> getAGG() {
        return AGG;
    }
}
