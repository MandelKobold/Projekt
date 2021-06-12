import java.util.ArrayList;
import java.util.Arrays;

public class CMAA {

    ArrayList<double[]> nwa;
    public CMAA(ArrayList<double[]> nwa) {
        this.nwa = nwa;
    }

    /*
    Idee:
    prüfen, ob es unterschiede gibt, bei den Bewertungen, wenn es unterschiede gibt, den Ort merken.


     */

    void test (ArrayList<String[]> test){
        for (int i = 0; i < test.size(); i++) {

            System.out.println(Arrays.toString(test.get(i)));

        }
    }

}
