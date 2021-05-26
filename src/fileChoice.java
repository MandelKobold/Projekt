import javax.swing.*;

public class fileChoice {
    /*
    User kann Pfad auwaelen
    Endung der Datei betrachten
    Passende input klasse aufrufen
     */
    // JFileChooser-Objekt erstellen
    private JFileChooser chooser = new JFileChooser();
    private int rueckgabeWert;
    private String end = "";
    private String path;
    public fileChoice()
    {
        // Dialog zum Oeffnen von Dateien anzeigen
        rueckgabeWert = chooser.showOpenDialog(null);
        /* Abfrage, ob auf "Open" geklickt wurde */
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
            //
            String t = chooser.getSelectedFile().getName();
            char[] tl = t.toCharArray();
            path = chooser.getSelectedFile().getAbsolutePath();
            for (int i = tl.length-3; i < tl.length ; i++) {
                end += tl[i];
            }
        }
    }

    public String getEnd() {
        return end;
    }

    public String getPath() {
        return path;
    }
}
