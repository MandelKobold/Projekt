import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class NWA {

    ArrayList<double[]> nwa;

    public NWA(ArrayList<String[]> dates) {
    }

    public NWA() {

    }

    //hier nutzwertanalyse bitte
    public void nutzwertMultiply(ArrayList<double[]> dates){
        ArrayList<double[]> ret = new ArrayList<>();
        double[] platz = new double[dates.get(2).length-2];
        for (int i = 0; i < platz.length; i++) {
            platz[i] = -1.0;
        }

        for (int i = 0; i<dates.size(); i++) {

            double[] multiplied = new double[dates.get(2).length-2];
            for (int j = 2; j <dates.get(2).length; j++) {
            /*
                BigDecimal weight = new BigDecimal(Double.parseDouble(dates.get(i1)[0].replace(",", "."))).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("weight:"+weight.toString());
                BigDecimal value = new BigDecimal(Double.parseDouble(dates.get(i1)[i2].replace(",", "."))).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("value:"+value.toString());
                BigDecimal multiply = new BigDecimal(weight.doubleValue() * value.doubleValue()).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("multiply:"+multiply);

                multiplied[i2-2] = multiply.doubleValue();
            */
                multiplied[j-2] = dates.get(i)[0]*dates.get(i)[j];

            }
            ret.add(multiplied);

        }
        System.out.println("NWA");
        for (int j = 0; j < ret.size(); j++) {
           System.out.println(Arrays.toString(ret.get(j)));
        }
        nutzwertAdd(ret);

    }
    public void nutzwertAdd(ArrayList<double[]> dates){
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
