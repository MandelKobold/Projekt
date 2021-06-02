import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class NWA {

    public NWA(ArrayList<String[]> dates) {
    }

    public NWA() {

    }

    //hier nutzwertanalyse bitte
    public void nutzwertAnalyse(ArrayList<String[]> dates){
        ArrayList<Double> ret = new ArrayList<>();
        int i1;
        int i2 = 3;
        //double weight;

        for (i1 =2; i1<dates.size(); i1++) {
            if (i1 % 7 == 0) {
                i1 = i1 + 2;
            }
            for (i2 = 2; i2 <= 9; i2++) {
                BigDecimal weight = new BigDecimal(Double.parseDouble(dates.get(i1)[0].replace(",", "."))).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("weight:"+weight.toString());
                BigDecimal value = new BigDecimal(Double.parseDouble(dates.get(i1)[i2].replace(",", "."))).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("value:"+value.toString());
                BigDecimal multiply = new BigDecimal(weight.doubleValue() * value.doubleValue()).setScale(2, RoundingMode.HALF_UP);
                //System.out.println("multiply:"+multiply);
                ret.add(multiply.doubleValue());
            }

        }
        for (int j = 0; j < dates.size(); j++) {
            System.out.println(ret.get(j).toString());
        }

    }
}
