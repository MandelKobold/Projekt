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

    void test (ArrayList<String[]> test){
        for (int i = 0; i < test.size(); i++) {

            System.out.println(Arrays.toString(test.get(i)));

        }
    }

}
