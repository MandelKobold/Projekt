import java.io.IOException;
import java.util.Arrays;

public class main {

    /*
    gucken, ob wir eine CSV Datei haben
    dann:
        CSV Datei einlesen -> NWA -> CMAA -> Ausgabe
    sonst:
        gucken ob wir eine txt Datei haben
        dann:
            txt Datei einlesen -> NWA -> CMAA -> Ausgabe
            sonst:
                Fehlermeldung
     */

    public static void  main(String[] args) throws IOException {

        fileChoice f = new fileChoice();

        if(f.getEnd().equals("csv")){
            System.out.println("CSV");
            //Datei einlesen
            CSVinput w = new CSVinput(f.getPath());
            w.read();
            //Datei zum verarbeiten vorbereiten
            formatDates form = new formatDates();
            form.format(w.getDates());
            if(form.gewichtungenPruefen()){
                ErrorMessage er = new ErrorMessage(true, "Bitte die Gewichtungen Prüfen");
                er.setVisible(true);
            }else if(form.bewertungenPruefen()){
                ErrorMessage er = new ErrorMessage(true, "Bitte die Bewertungen Prüfen");
                er.setVisible(true);
            }else {
                //AGG erstellen
                CMAA cmaa = new CMAA(form.getRet());
                cmaa.compare();
                //NWA aufrufen mit zufälligen Werten aus der AGG
                NWA nwa = new NWA();
                nwa.prepareNWA(cmaa.getAGG(), cmaa.getRndmWeteAGG());
                nwa.nutzwertMultiply();
                //zaelen wer akzeptiert wurde
                rankacceptabilitymatrix ram = new rankacceptabilitymatrix(nwa.getResult());
                int[][] rankAcceptability = ram.ranking();
                //System.out.println(nwa.getResult().toString());

                for (int i = 1; i < 10000; i++) {
                    nwa = new NWA();
                    nwa.prepareNWA(cmaa.getAGG(), cmaa.getRndmWeteAGG());
                    nwa.nutzwertMultiply();
                    //zaelen wer akzeptiert wurde
                    ram = new rankacceptabilitymatrix(nwa.getResult(), rankAcceptability);
                    ram.ranking();
                    //System.out.println(nwa.getResult().toString());
                }
                System.out.println("Rank Acceptability Matrix:");
                System.out.println(Arrays.deepToString(ram.getRankAcceptability()));
                CSVOutput ret = new CSVOutput();
                ret.OutputCSV(ram.getRankAcceptability());
            }

            }else if(f.getEnd().equals("txt")) {
                System.out.println("TXT");
                TXTinput w = new TXTinput(f.getPath());
                w.read();
                formatDates form = new formatDates();
                form.format(w.getDates());
            if(form.gewichtungenPruefen()){
                ErrorMessage er = new ErrorMessage(true, "Bitte die Gewichtungen Prüfen");
                er.setVisible(true);
            }else if(form.bewertungenPruefen()){
                ErrorMessage er = new ErrorMessage(true, "Bitte die Bewertungen Prüfen");
                er.setVisible(true);
            }else {
                //AGG erstellen
                CMAA cmaa = new CMAA(form.getRet());
                cmaa.compare();
                //NWA aufrufen mit zufälligen Werten aus der AGG

                NWA nwa = new NWA();
                nwa.prepareNWA(cmaa.getAGG(), cmaa.getRndmWeteAGG());
                nwa.nutzwertMultiply();
                //zaelen wer akzeptiert wurde
                rankacceptabilitymatrix ram = new rankacceptabilitymatrix(nwa.getResult());
                int[][] rankAcceptability = ram.ranking();
                //System.out.println(nwa.getResult().toString());

                for (int i = 1; i < 10000; i++) {
                    nwa = new NWA();
                    nwa.prepareNWA(cmaa.getAGG(), cmaa.getRndmWeteAGG());
                    nwa.nutzwertMultiply();
                    //zaelen wer akzeptiert wurde
                    ram = new rankacceptabilitymatrix(nwa.getResult(), rankAcceptability);
                    ram.ranking();
                    //System.out.println(nwa.getResult().toString());
                }
                System.out.println("Rank Acceptability Matrix:");
                System.out.println(Arrays.deepToString(ram.getRankAcceptability()));
                CSVOutput ret = new CSVOutput();
                ret.OutputCSV(ram.getRankAcceptability());
            }

        }else if(!f.getCancel()){
            //Wenn Cancel gedrueckt wurde wird das Programm beendet
            ErrorMessage er = new ErrorMessage(true, "Dieses Dateiformat ist nicht gültig, bitte TXT oder CSV Datei auswählen");
            er.setVisible(true);
            System.out.println("HERBERT Dieses Dateiformat ist nicht gültig");
        }

    }


}
