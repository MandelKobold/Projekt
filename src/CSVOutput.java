import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CSVOutput {
    //Die Daten sinvoll ausgeben

    private int rueckgabeWert;

    public void OutputCSV(int[][]ram) throws IOException {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        List<String[]> datalines = new ArrayList<>();
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
}
