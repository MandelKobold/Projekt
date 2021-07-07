import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tests {

    @Test
    public void alwaysTrueTest() {
        Assert.assertEquals(0,0);
    }

    //formatDates tests
    @Test
    public void FormatDateTest(){
        ArrayList<double[]> checking = new ArrayList<>();

        //Erstellen von Daten, mit denen abgeglichen werden soll (Scenario 1)
        double[] e1 = new double[]{0.1,-2,0.5,0.5,0.5,0.5,0.5,0.7,0.5,0.7};
        double[] e2 = new double[]{0.2,-2,0.2,0.2,0.2,0.2,0.2,0.1,0.2,0.2};
        double[] e3 = new double[]{0.3,-2,0.3,0.3,0.3,0.3,0.3,0.1,0.3,0.3};
        double[] e4 = new double[]{0.4,-2,0.4,0.4,0.4,0.4,0.4,0.1,0.4,0.4};
        double[] e5 = new double[]{0.5,-2,0.5,0.5,0.5,0.1,0.1,0.7,0.5,0.1};
        double[] e6 = new double[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        double[] e7 = new double[]{0.1,-2,0.5,0.5,0.5,0.5,0.5,0.7,0.5,0.7};
        double[] e8 = new double[]{0.2,-2,0.2,0.2,0.2,0.2,0.2,0.1,0.2,0.2};
        double[] e9 = new double[]{0.3,-2,0.3,0.3,0.3,0.3,0.3,0.1,0.3,0.3};
        double[] e10= new double[]{0.4,-2,0.4,0.4,0.4,0.4,0.4,0.1,0.4,0.4};
        double[] e111= new double[]{0.5,-2,0.5,0.5,0.5,0.1,0.1,0.7,0.5,0.1};
        double[] e121= new double[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        double[] e13= new double[]{0.1,-2,0.5,0.5,0.5,0.5,0.5,0.7,0.5,0.7};
        double[] e14 = new double[]{0.2,-2,0.2,0.2,0.2,0.2,0.2,0.1,0.2,0.2};
        double[] e15 = new double[]{0.3,-2,0.3,0.3,0.3,0.3,0.3,0.1,0.3,0.3};
        double[] e16 = new double[]{0.4,-2,0.4,0.4,0.4,0.4,0.4,0.1,0.4,0.4};
        double[] e17 = new double[]{0.5,-2,0.5,0.5,0.5,0.1,0.1,0.7,0.5,0.1};
        double[] e18 = new double[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        double[] e19 = new double[]{0.5,-2,0.5,0.5,0.5,0.5,0.5,0.7,0.5,0.1};
        double[] e20 = new double[]{0.4,-2,0.2,0.2,0.2,0.2,0.2,0.1,0.2,0.2};
        double[] e211 = new double[]{0.3,-2,0.3,0.3,0.3,0.3,0.3,0.1,0.3,0.3};
        double[] e221 = new double[]{0.2,-2,0.4,0.4,0.1,0.4,0.1,0.1,0.1,0.4};
        double[] e23 = new double[]{0.1,-2,0.5,0.5,0.5,0.1,0.1,0.7,0.5,0.1};
        double[] e24= new double[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        double[] e25 = new double[]{0.5,-2,0.5,0.5,0.1,0.5,0.1,0.7,0.5,0.7};
        double[] e26 = new double[]{0.4,-2,0.2,0.2,0.2,0.2,0.2,0.1,0.2,0.2};
        double[] e27 = new double[]{0.3,-2,0.3,0.3,0.3,0.3,0.3,0.1,0.3,0.3};
        double[] e28 = new double[]{0.2,-2,0.1,0.4,0.1,0.4,0.4,0.1,0.4,0.1};
        double[] e29 = new double[]{0.1,-2,0.5,0.5,0.5,0.1,0.1,0.7,0.5,0.1};
        double[] e30 = new double[]{1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        double[] e311 = new double[]{0.5,-2,0.5,0.5,0.7,0.7,0.5,0.7,0.5,0.7};
        double[] e321 = new double[]{0.4,-2,0.2,0.2,0.2,0.2,0.2,0.1,0.2,0.2};
        double[] e33= new double[]{0.3,-2,0.3,0.3,0.3,0.3,0.3,0.1,0.3,0.3};
        double[] e34 = new double[]{0.2,-2,0.4,0.4,0.4,0.4,0.4,0.1,0.4,0.4};
        double[] e35 = new double[]{0.1,-2,0.5,0.1,0.1,0.1,0.1,0.7,0.5,0.1};

        checking.add(e1);
        checking.add(e2);
        checking.add(e3);
        checking.add(e4);
        checking.add(e5);
        checking.add(e6);
        checking.add(e7);
        checking.add(e8);
        checking.add(e9);
        checking.add(e10);
        checking.add(e111);
        checking.add(e121);
        checking.add(e13);
        checking.add(e14);
        checking.add(e15);
        checking.add(e16);
        checking.add(e17);
        checking.add(e18);
        checking.add(e19);
        checking.add(e20);
        checking.add(e211);
        checking.add(e221);
        checking.add(e23);
        checking.add(e24);
        checking.add(e25);
        checking.add(e26);
        checking.add(e27);
        checking.add(e28);
        checking.add(e29);
        checking.add(e30);
        checking.add(e311);
        checking.add(e321);
        checking.add(e33);
        checking.add(e34);
        checking.add(e35);

        //Testen mithilfe der automatischen CSV funktion (ließt scenario 1 aus)
        CSVinput test = new CSVinput();
        test.read();
        formatDates umwandler = new formatDates();
        umwandler.format(test.getDates());


        //Vergleich
        for (int i = 0; i <umwandler.ret.size() ; i++) {
            for (int j = 0; j <umwandler.ret.get(i).length ; j++) {
                Assert.assertEquals(checking.get(i)[j], umwandler.getRet().get(i)[j]);
            }
        }
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
        ArrayList<double[]> tdates = new ArrayList<>();
        double[] e11 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e21 = new double[]{0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2};
        double[] e31 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e41 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e51 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1};
        double[] e61 = new double[]{0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6};
        double[] splitter = new double[]{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0};
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
        tdates.add(e11);
        tdates.add(e21);
        tdates.add(e31);
        tdates.add(e41);
        tdates.add(e51);
        tdates.add(e61);
        gesplittet.add(tdates);
        gesplittet.add(tdates);
        CMAA cmaa = new CMAA(dates);
        cmaa.compare();

        for (int i = 0; i < gesplittet.size(); i++) {
            for (int j = 0; j <gesplittet.get(i).size() ; j++) {
                Assert.assertEquals(gesplittet.get(i).get(j), cmaa.split().get(i).get(j));
            }
        }
        for (int i = 0; i < tdates.size(); i++) {
            for (int j = 0; j <tdates.get(i).length ; j++) {
                Assert.assertEquals(tdates.get(i)[j],cmaa.getAGG().get(i)[j]);
            }
        }
        ArrayList<ArrayList<Double>> rndmWeteAGG = new ArrayList<>();
        ArrayList<Double> f = new ArrayList<>(); //filler to begin ArrayList with index 2
        rndmWeteAGG.add(f);
        rndmWeteAGG.add(f);

        for (int i = 0; i <rndmWeteAGG.size() ; i++) {
            Assert.assertEquals(rndmWeteAGG,cmaa.getRndmWeteAGG());
        }

    }
    @Test
    public void CMAATest2verschDMs(){
        ArrayList<double[]> dates = new ArrayList<>();
        ArrayList<double[]> tdates1 = new ArrayList<>();
        ArrayList<double[]> tdates2 = new ArrayList<>();
        ArrayList<double[]> AGGTest = new ArrayList<>();
        double[] e11 = new double[]{0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e21 = new double[]{0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2};
        double[] e31 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e41 = new double[]{0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e51 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1};
        double[] e61 = new double[]{0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6};
        double[] splitter = new double[]{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0};
        double[] e12 = new double[]{0.1,-2.0,0.6,0.4,0.5,0.5,0.3,0.5,0.7};
        double[] e22 = new double[]{0.3,-2.0,0.3,0.6,0.5,0.6,0.7,0.3,0.2};
        double[] e32 = new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6};
        double[] e42 = new double[]{0.2,-2.0,0.2,0.5,0.5,0.9,0.7,0.5,0.7};
        double[] e52 = new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,0.2,0.1,0.1};
        double[] e62 = new double[]{0.2,-2.0,0.1,0.2,0.8,0.5,0.7,0.5,0.6};
        dates.add(e11);
        dates.add(e21);
        dates.add(e31);
        dates.add(e41);
        dates.add(e51);
        dates.add(e61);
        dates.add(splitter);
        dates.add(e12);
        dates.add(e22);
        dates.add(e32);
        dates.add(e42);
        dates.add(e52);
        dates.add(e62);
        ArrayList<ArrayList<double[]>> gesplittet = new ArrayList<>();
        tdates1.add(e11);
        tdates1.add(e21);
        tdates1.add(e31);
        tdates1.add(e41);
        tdates1.add(e51);
        tdates1.add(e61);
        gesplittet.add(tdates1);
        tdates2.add(e12);
        tdates2.add(e22);
        tdates2.add(e32);
        tdates2.add(e42);
        tdates2.add(e52);
        tdates2.add(e62);
        gesplittet.add(tdates2);

        AGGTest.add(new double[]{0.1,-2.0,2,0.4,0.5,0.5,0.3,0.5,0.7});      // {0.1,-2.0,0.5,0.4,0.5,0.5,0.3,0.5,0.7}  {0.1,-2.0,0.6,0.4,0.5,0.5,0.3,0.5,0.7}
        AGGTest.add(new double[]{0.3,-2.0,0.3,3,0.5,0.6,0.7,0.3,0.2});      // {0.3,-2.0,0.3,0.5,0.5,0.6,0.7,0.3,0.2}  {0.3,-2.0,0.3,0.6,0.5,0.6,0.7,0.3,0.2}
        AGGTest.add(new double[]{0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6});    // {0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6}  {0.8,-2.0,0.5,0.3,0.3,0.4,0.6,0.5,0.6}
        AGGTest.add(new double[]{0.2,-2.0,4,0.5,0.5,0.9,0.7,0.5,0.7});      // {0.2,-2.0,0.8,0.5,0.5,0.9,0.7,0.5,0.7}  {0.2,-2.0,0.2,0.5,0.5,0.9,0.7,0.5,0.7}
        AGGTest.add(new double[]{0.7,-2.0,0.4,0.4,0.7,0.5,5,0.1,0.1});      // {0.7,-2.0,0.4,0.4,0.7,0.5,0.4,0.1,0.1}  {0.7,-2.0,0.4,0.4,0.7,0.5,0.2,0.1,0.1}
        AGGTest.add(new double[]{0.2,-2.0,6,7,0.8,0.5,0.7,0.5,0.6});        // {0.2,-2.0,0.5,0.5,0.8,0.5,0.7,0.5,0.6}  {0.2,-2.0,0.1,0.2,0.8,0.5,0.7,0.5,0.6}

        CMAA cmaa = new CMAA(dates);
        cmaa.compare();

        for (int i = 0; i < gesplittet.size(); i++) {
            for (int j = 0; j <gesplittet.get(i).size() ; j++) {
                Assert.assertEquals(gesplittet.get(i).get(j), cmaa.split().get(i).get(j));
            }
        }

        for (int i = 0; i < AGGTest.size(); i++) {
            for (int j = 0; j <AGGTest.get(i).length ; j++) {
                Assert.assertEquals(AGGTest.get(i)[j],cmaa.getAGG().get(i)[j]);
            }
        }

        ArrayList<ArrayList<Double>> rndmWeteAGG = new ArrayList<>();
        ArrayList<Double> f = new ArrayList<>(); //filler to begin ArrayList with index 2
        rndmWeteAGG.add(f);
        rndmWeteAGG.add(f);
        ArrayList<Double> rndm2 = new ArrayList<>();
        rndm2.add(0.5);
        rndm2.add(0.6);
        ArrayList<Double> rndm3 = new ArrayList<>();
        rndm3.add(0.5);
        rndm3.add(0.6);
        ArrayList<Double> rndm4 = new ArrayList<>();
        rndm4.add(0.8);
        rndm4.add(0.2);
        ArrayList<Double> rndm5 = new ArrayList<>();
        rndm5.add(0.4);
        rndm5.add(0.2);
        ArrayList<Double> rndm6 = new ArrayList<>();
        rndm6.add(0.5);
        rndm6.add(0.1);
        ArrayList<Double> rndm7 = new ArrayList<>();
        rndm7.add(0.5);
        rndm7.add(0.2);
        rndmWeteAGG.add(rndm2);
        rndmWeteAGG.add(rndm3);
        rndmWeteAGG.add(rndm4);
        rndmWeteAGG.add(rndm5);
        rndmWeteAGG.add(rndm6);
        rndmWeteAGG.add(rndm7);

        for (int i = 0; i <rndmWeteAGG.size() ; i++) {
            Assert.assertEquals(rndmWeteAGG,cmaa.getRndmWeteAGG());
        }

    }


    //rankacceptabilitymatrix tests
    @Test
    public void RankAcceptabilityMatrixTest(){

        ArrayList<Double> testdata = new ArrayList<>();

        //füllen eines Arrays zum Vergleich
        int[][] accTest = new int[7][7];
        for (int i = 0; i <7 ; i++) {
            for (int j = 0; j < 7; j++) {
                accTest[i][j] = 0;
            }
        }
        accTest[4][0]=1;
        accTest[2][1]=1;
        accTest[3][2]=1;
        accTest[0][3]=1;
        accTest[6][4]=1;
        accTest[1][5]=1;
        accTest[5][6]=1;


        //Übergabe fake-Daten (normalerweise aus NWA)
        testdata.add(1.08);
        testdata.add(0.91);
        testdata.add(1.19);
        testdata.add(1.18);
        testdata.add(1.28);
        testdata.add(0.81);
        testdata.add(0.94);

        //Ranking erstellen
        rankacceptabilitymatrix raa = new rankacceptabilitymatrix(testdata);
        raa.ranking();

        //Vergleich
        for (int i = 0; i < raa.getRankAcceptability().length ; i++) {
            for (int j = 0; j <raa.getRankAcceptability()[0].length ; j++) {
                Assert.assertEquals(raa.getRankAcceptability()[i][j], accTest[i][j]);
            }
        }

    }
}
