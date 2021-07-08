import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class CSVOutput {
    //Die Daten sinvoll ausgeben

    private int rueckgabeWert;

    void OutputCSVNORMAL(int[][] ram) throws IOException {

        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        ArrayList<String[]> datalines = createFile(ram);

        // Dialog zum Speichern von Dateien anzeigen
        rueckgabeWert = chooser.showSaveDialog(null);

        if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            File csvOutputFile;

            //testen, ob .csv dahinter geschrieben wurde und wenn nicht, das dann dahinter schreiben
            if(path.endsWith(".csv")){
                csvOutputFile = new File(path);
            }else{
                csvOutputFile = new File(path + ".csv");
            }

            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                datalines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            }catch (IOException e){
                e.printStackTrace();
            }

        }else if(rueckgabeWert == JFileChooser.CANCEL_OPTION){
            System.exit(0);
        }
    }



    void OutputCSVMAC(int[][] ram) throws IOException {

        System.setProperty("apple.awt.fileDialogForDirectories", "true");
        FileDialog chooser = new FileDialog(new JFrame(), "", FileDialog.SAVE);

        ArrayList<String[]> datalines = createFile(ram);

        // Dialog zum Speichern von Dateien anzeigen
        chooser.setDirectory(System.getProperty("user.home"));
        chooser.setVisible(true);
        String rueckgabeWertMAC = chooser.getDirectory() + chooser.getName();


        if (rueckgabeWertMAC != null) {
            File csvOutputFile;

            //testen, ob .csv dahinter geschrieben wurde und wenn nicht, das dann dahinter schreiben
            if (rueckgabeWertMAC.endsWith(".csv")) {
                csvOutputFile = new File(rueckgabeWertMAC);
            } else {
                csvOutputFile = new File(rueckgabeWertMAC + ".csv");
            }

            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                datalines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.setProperty("apple.awt.fileDialogForDirectories", "true");
    }









    private ArrayList<String[]> createFile(int[][]ram){
        int[] gewichtungPlatzierung = gewichtungPlatzierung(ram);
        ArrayList<String[]> datalines = new ArrayList<>();
        datalines.add(new String[]{"Rank Acceptability Matrix"}); // Ueberschrift
        int variante = 1;
        String[] platzierung = new String[ram[0].length+1];
        // in der Ersten Zeile die Plaetze aufzaelen
        platzierung[0] = "";
        for (int k = 1; k < platzierung.length; k++) {
            platzierung[k] = "Platz " + k;
        }
        datalines.add(platzierung);
        // Zeilen mit den Ergebnissen in das Ergebnisdokument schreiben
        for (int[] element : ram) {
            String[] convert = new String[element.length+1];
            for (int i = 0; i < element.length; i++) {
                convert[0]= "Alternative "+ variante;           // in der ersten Spalte sagen um welche Alternative es sich handelt
                convert[i+1] = Integer.toString(element[i]);    // die Zahlen in einen String werfen
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
            if(gewichtungPlatzierung[i] > 5000*ram.length+1 || gewichtungPlatzierung[i] < 10000) {
                ausschluss.add(i+1);
                ausgeschlossen = true;
            }else{
                akzeptiert.add(i+1);
            }
        }

        //Zeilen an das Ende des Dokuments mit Ergebnissen
        if(ausgeschlossen && ausschluss.size() != ram.length) {
            datalines.add(new String[]{""});
            datalines.add(new String[]{"Die Alternativen " + akzeptiert.toString() + " werden akzeptiert." });
            datalines.add(new String[]{"Die Alternativen " + ausschluss.toString() + " werden nicht akzeptiert"});
        }else{
            datalines.add(new String[]{""});
            datalines.add(new String[]{"Es konnte keine Alternative ausgeschlossen werden."});
        }
        return datalines;
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
