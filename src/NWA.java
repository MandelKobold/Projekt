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
    public void nutzwertMultiply(ArrayList<String[]> dates){
        ArrayList<double[]> ret = new ArrayList<>();
        double[] multiplied = new double[dates.get(2).length-2];
        double[] platz = new double[multiplied.length];
        for (int i = 0; i < platz.length; i++) {
            platz[i] = -1.0;
        }
        int i1;
        int i2;

        for (i1 =2; i1<dates.size(); i1++) {
            if (i1 % 7 == 0) {
                ret.add(platz);
                i1 = i1 + 2;
            }

            for (i2 = 2; i2 <dates.get(2).length; i2++) {
                BigDecimal weight = new BigDecimal(Double.parseDouble(dates.get(i1)[0].replace(",", "."))).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("weight:"+weight.toString());
                BigDecimal value = new BigDecimal(Double.parseDouble(dates.get(i1)[i2].replace(",", "."))).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("value:"+value.toString());
                BigDecimal multiply = new BigDecimal(weight.doubleValue() * value.doubleValue()).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("multiply:"+multiply);

                multiplied[i2-2] = multiply.doubleValue();
            }
            ret.add(multiplied);

        }
        for (int j = 0; j < ret.size(); j++) {
           System.out.println(Arrays.toString(ret.get(j)));
        }
        nutzwertAdd(ret);

    }
    public void nutzwertAdd(ArrayList<double[]> dates){

        double addition;
        ArrayList<double[]> ret = new ArrayList<>();
        double[] add = new double[dates.get(2).length];
        int round;

        for (int i = 0; i < dates.get(2).length; i++){
            addition = 0.0;
            int j = 0;

            while(dates.get(j)[i] != -1.0){
                round = (int)(dates.get(j)[i]*100);
                addition += round;
                j++;
            }
            add[i] = addition/100;
            ret.add(add);
        }
        for (int k = 0; k < ret.size(); k++) {
            System.out.println(Arrays.toString(ret.get(k)));
        }
        this.nwa = ret;
    }

    public ArrayList<double[]> getNwa() {
        return nwa;
    }
}
