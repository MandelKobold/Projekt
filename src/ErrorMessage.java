import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ErrorMessage extends JFrame implements ActionListener {
    JPanel panel;
    JButton buttonOk;           //der Ok Button wird verwendet, wenn der Fehler nicht durch einen Neustart des Programms behoben werden kann
    JButton buttonAgain;
    JButton buttonCancel;
    JLabel errmsg;

    ErrorMessage(boolean usererror, String fehler){
        fenster();
        addErrmsg(fehler);
        if(usererror){
            addButtonRetryCancel();
        }else{
            addButtonOk();
        }
        panel.setLayout(null);
        this.add(panel);
    }
    void fenster (){
        this.setTitle("Es ist ein Fehler Aufgetreten");
        this.setBounds(10,10,500,150);  //groesse des Fensters
        this.setLocationRelativeTo(null);                   //Fenster zentrieren
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);                                    //Panel auf das Fenster
    }

    void addErrmsg(String s ){
        errmsg = new JLabel();
        errmsg.setBounds(20,30,500,20);
        //errmsg.setText("Dies ist der Fehler der Aufgetreten ist");
        errmsg.setText(s);
        panel.add(errmsg);
    }

    void addButtonOk(){
        buttonOk = new JButton("Ok");
        buttonOk.setBounds(200,80,100,25);
        buttonOk.addActionListener(this);
        panel.add(buttonOk);
    }

    void addButtonRetryCancel(){
        buttonAgain = new JButton("Wiederholen");
        buttonAgain.setBounds(100,80,120,25);
        buttonAgain.addActionListener(this);
        buttonCancel = new JButton("Abbrechen");
        buttonCancel.setBounds(300,80,100,25);
        buttonCancel.addActionListener(this);
        panel.add(buttonAgain);
        panel.add(buttonCancel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.buttonOk || e.getSource() == this.buttonCancel){
            //Programm beenden
            System.exit(0);
        }else if(e.getSource() == this.buttonAgain){
            //Programm neustarten
            this.dispose();
            try {
                main.main(null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
