import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CSVOutput {
    //Die Daten sinvoll ausgeben

    private int rueckgabeWert;

    public void OutputCSV(int[][]ram) throws IOException {
        int[] gewichtungPlatzierung = gewichtungPlatzierung(ram);
        System.out.println(Arrays.toString(gewichtungPlatzierung));
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        List<String[]> datalines = new ArrayList<>();
        datalines.add(new String[]{"Rank Acceptability Matrix"});
        int variante = 1;
        String[] platzierung = new String[ram[0].length+1];
        platzierung[0] = "";
        for (int k = 1; k < platzierung.length; k++) {
            platzierung[k] = "Platz " + k;
        }
        datalines.add(platzierung);
        // Dialog zum Speichern von Dateien anzeigen
        rueckgabeWert = chooser.showSaveDialog(null);

        if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();

            File csvOutputFile = new File(path);

            for (int[] element : ram) {
                String[] convert = new String[element.length+1];

                for (int i = 0; i < element.length; i++) {
                    convert[0]= "Alternative "+ variante;

                    convert[i+1] = Integer.toString(element[i]);

                }
                variante ++;
                datalines.add(convert);
            }
            //pruefen ob Alternative ausgeschlossen werden kann
            ArrayList<Integer> ausschluss = new ArrayList<>();
            ArrayList<Integer> akzeptiert = new ArrayList<>();
            boolean ausgeschlossen = false;
            for (int i = 0; i <gewichtungPlatzierung.length ; i++) {
                //Ausschlusskriterium: heaelfte der Replikationen multipliziert mit dem hoechsten Platz
                if(gewichtungPlatzierung[i] > 5000*ram.length+1) {
                    ausschluss.add(i+1);
                    ausgeschlossen = true;
                }else{
                    akzeptiert.add(i+1);
                }
            }
            if(ausgeschlossen && ausschluss.size() != ram.length) {
                datalines.add(new String[]{"Die Alternativen " + akzeptiert.toString() + " werden akzeptiert." });
                datalines.add(new String[]{"Die Alternativen " + ausschluss.toString() + " werden nicht akzeptiert"});
            }else{
                datalines.add(new String[]{"Es konnte keine Alternative ausgeschlossen werden."});
            }
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                datalines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            }

        }
    }
    private String convertToCSV(String[] data){
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(";"));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    private int[] gewichtungPlatzierung(int[][]ram){
        int[] gewichtungPlatzierung = new int[ram.length];
        for (int i = 0; i <ram.length ; i++) {
            for (int j = 0; j < ram[i].length; j++) {
                gewichtungPlatzierung[i] += (j+1)*ram[i][j];
            }
        }
        return gewichtungPlatzierung;
    }
}
