import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.zip.DeflaterOutputStream;

public class Tests {

    @Test
    public void alwaysTrueTest() {
        Assert.assertEquals(0,0);
    }


    //NWA tests

    @Test
    public void NWATestOhnerndmWerte(){
        NWA nwa = new NWA();
        ArrayList<double[]> AGG = new ArrayList<>();                //AGG zum testen
        ArrayList<ArrayList<Double>> rndmAGG = new ArrayList<>();   //Liste mit den random Werten
        ArrayList<Double> idealErgebnisse = new ArrayList<>();      // Werte zum vergleichen
        ArrayList<Double> berechneteErgebnisse;
        // AGG mit Werten fuettern
        double[] e1 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e2 = new double[]{0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2};
        double[] e3 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e4 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e5 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1};
        double[] e6 = new double[]{0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6};
        AGG.add(e1);
        AGG.add(e2);
        AGG.add(e3);
        AGG.add(e4);
        AGG.add(e5);
        AGG.add(e6);
        //idealErgebnis mit per Hand berechneter NWA Ergebnissen fuellen
        idealErgebnisse.add(1.08);
        idealErgebnisse.add(0.91);
        idealErgebnisse.add(1.19);
        idealErgebnisse.add(1.18);
        idealErgebnisse.add(1.28);
        idealErgebnisse.add(0.81);
        idealErgebnisse.add(0.94);
        //Berechnung durchfuehren
        nwa.prepareNWA(AGG,rndmAGG);
        nwa.nutzwertMultiply();
        berechneteErgebnisse = nwa.getResult();

        //Werte vergleichen
        ArrayList<double[]> prepAGG = nwa.getDates();
        for (int i = 0; i <AGG.size() ; i++) {
            for (int j = 0; j <AGG.get(i).length ; j++) {
                Assert.assertEquals(AGG.get(i)[j], nwa.getDates().get(i)[j]);
            }
        }
        Assert.assertEquals(idealErgebnisse,berechneteErgebnisse);
    }
    @Test
    public void NWATestMitrndmWerte(){
        NWA nwa = new NWA();
        ArrayList<double[]> AGG = new ArrayList<>();                //AGG zum testen
        ArrayList<ArrayList<Double>> rndmAGG = new ArrayList<>();   //Liste mit den random Werten
        ArrayList<Double> idealErgebnisse = new ArrayList<>();      // Werte zum vergleichen
        ArrayList<Double> berechneteErgebnisse;
        // AGG mit Werten fuettern
        double[] c1 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] c2 = new double[]{0.3,-2.0,0.3,2,0.5,0.6,0.7,0.3,0.2};
        double[] c3 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] c4 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] c5 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,3,0.1,0.1};
        double[] c6 = new double[]{0.2,-2.0,0.5,4,0.8,0.5,0.7,0.5,0.6};
        AGG.add(c1);
        AGG.add(c2);
        AGG.add(c3);
        AGG.add(c4);
        AGG.add(c5);
        AGG.add(c6);
        //idealErgebnis mit per Hand berechneter NWA Ergebnissen fuellen
        idealErgebnisse.add(1.08);
        idealErgebnisse.add(0.91);
        idealErgebnisse.add(1.19);
        idealErgebnisse.add(1.18);
        idealErgebnisse.add(1.28);
        idealErgebnisse.add(0.81);
        idealErgebnisse.add(0.94);
        //rndmWere
        ArrayList<Double> f = new ArrayList<>();
        rndmAGG.add(f);
        rndmAGG.add(f);
        ArrayList<Double> rndm2 = new ArrayList<>();
        rndm2.add(0.5);
        rndm2.add(0.5);
        rndm2.add(0.5);
        ArrayList<Double> rndm3 = new ArrayList<>();
        rndm3.add(0.4);
        rndm3.add(0.4);
        rndm3.add(0.4);
        ArrayList<Double> rndm4 = new ArrayList<>();
        rndm4.add(0.5);
        rndm4.add(0.5);
        rndm4.add(0.5);
        rndmAGG.add(rndm2);
        rndmAGG.add(rndm3);
        rndmAGG.add(rndm4);
        //Berechnung durchfuehren
        nwa.prepareNWA(AGG,rndmAGG);
        nwa.nutzwertMultiply();
        berechneteErgebnisse = nwa.getResult();

        //Werte vergleichen
        AGG.get(1)[3] = 0.5;
        AGG.get(4)[6] = 0.4;
        AGG.get(5)[3] = 0.5;

        ArrayList<double[]> prepAGG = nwa.getDates();
        for (int i = 0; i <AGG.size() ; i++) {
            for (int j = 0; j <AGG.get(i).length ; j++) {
                Assert.assertEquals(AGG.get(i)[j], nwa.getDates().get(i)[j]);
            }
        }
        Assert.assertEquals(idealErgebnisse,berechneteErgebnisse);


    }

    //CMMA tests
    @Test
    public void CMAATest2gleicheDMs(){
        ArrayList<double[]> dates = new ArrayList<>();

        double[] e11 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e21 = new double[]{0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2};
        double[] e31 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e41 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e51 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1};
        double[] e61 = new double[]{0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6};
        double[] splitter = new double[]{-0.1,-0.1,-0.1,-0.1,-0.1,-0.1,-0.1,-0.1,-0.1};
        dates.add(e11);
        dates.add(e21);
        dates.add(e31);
        dates.add(e41);
        dates.add(e51);
        dates.add(e61);
        dates.add(splitter);
        dates.add(e11);
        dates.add(e21);
        dates.add(e31);
        dates.add(e41);
        dates.add(e51);
        dates.add(e61);
        ArrayList<ArrayList<double[]>> gesplittet = new ArrayList<>();

        CMAA cmaa = new CMAA(dates);


    }
    @Test
    public void CMAATest2verschDMs(){
        ArrayList<double[]> dates = new ArrayList<>();

        double[] e11 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e21 = new double[]{0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2};
        double[] e31 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e41 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e51 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1};
        double[] e61 = new double[]{0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6};
        double[] splitter = new double[]{-0.1,-0.1,-0.1,-0.1,-0.1,-0.1,-0.1,-0.1,-0.1};
        double[] e12 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e22 = new double[]{0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2};
        double[] e32 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e42 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e52 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1};
        double[] e62 = new double[]{0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6};
        dates.add(e11);

        CMAA cmaa = new CMAA(dates);

    }
    //formatDates tests

    //rankacceptabilitymatrix tests
}
