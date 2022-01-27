/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ditemp;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TemporizadorBean extends JLabel implements ActionListener, Serializable {
    
    private FinCuentaAtrasListener receptor;
    protected int tiempo;
    private final Timer t;
    public static final String PROP_TIEMPO = "tiempo";

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        int oldTiempo = this.tiempo;
        this.tiempo = tiempo;
        setText(Integer.toString(tiempo));
        repaint();
    }
    public final void setActivo(boolean valor) {
            if (valor == true)
            t.start();
            else
            t.stop();
            }
            public boolean getActivo() {
            return t.isRunning();
            }
            

    //Constructor sin argumentos. Se establece como tiempo por defecto 5 segundos.
    public TemporizadorBean() {
        //propertySupport = new PropertyChangeSupport(this);
        tiempo = 5;
        t = new Timer(1000, this);
        setText(Integer.toString(tiempo));
        setActivo(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
            setText(Integer.toString(tiempo));
            repaint(); tiempo--; if(tiempo == 0){ setActivo(false); receptor.capturarFinCuentaAtras(
            new FinCuentaAtrasEvent(this)); } }
    public void addFinCuentaAtrasListener(FinCuentaAtrasListener receptor){
            this.receptor = receptor;
            }
            public void removeFinCuentaAtrasListener(FinCuentaAtrasListener receptor){
            this.receptor=null;
            }
            
}



