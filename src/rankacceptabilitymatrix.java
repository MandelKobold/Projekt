import java.util.ArrayList;
import java.util.Arrays;

public class rankacceptabilitymatrix {

    Double[] dataForRanking;
    int[][] rankAcceptability;

    public rankacceptabilitymatrix(ArrayList<Double> result, int[][] rankAcceptability) {
        dataForRanking = result.toArray(new Double[result.size()]);
        this.rankAcceptability = rankAcceptability;
    }

    public rankacceptabilitymatrix(ArrayList<Double> result) {
        dataForRanking = result.toArray(new Double[result.size()]);
        rankAcceptability = new int[dataForRanking.length][dataForRanking.length];
        for (int i = 0; i < rankAcceptability.length; i++) {
            for (int j = 0; j < rankAcceptability.length; j++) {
                rankAcceptability[i][j] = 0;
            }
        }
    }

    //Die Daten, aus der NWA aufarbeiten
    int[][] ranking() {

        for (int i = 0; i < dataForRanking.length; i++) {
            ArrayList<Integer> index = highest();
            //Liste mit den akzeptierten Alternativen
            while (index.size() > 0 && index.get(0) != -1){
                rankAcceptability[index.get(0)][i]++;
                dataForRanking[index.get(0)] = -10.0;
                index.remove(0);
            }

        }
/*
        System.out.println("Ranka");
        System.out.println(Arrays.deepToString(rankAcceptability));
*/
        return rankAcceptability;
    }

    //den highest Wert finden
    ArrayList<Integer> highest() {
        double max = 0.0;
        int inMax = -1;
        //Liste mit den indexen der Alternativen, die am ehesten Akzeptiert werden
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < dataForRanking.length; i++) {
            if (dataForRanking[i] > max) {
                max = dataForRanking[i];
                inMax = i;
            }
        }
        index.add(inMax);
        //testen, ob der max Wert noch mal vorkommt und in Liste aufnehmen
        for (int i = 0; i < dataForRanking.length; i++) {
            if (dataForRanking[i] == max) {
                if(!index.contains(i)){
                    index.add(i);
                }
            }
        }
        //System.out.println(index.toString());
        return index;
    }

    public int[][] getRankAcceptability() {
        return rankAcceptability;
    }
}
