package boletin12_1_1;

import java.util.Date;
import javax.swing.JOptionPane;

public class Coche {

    private String matricula;
    private String marca;
    private Date fechaIni;
    private Date fechaFin;

    public Coche() {
    }

    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public void iniciarHoraIni() {
        fechaIni = new Date();
    }

    public void iniciarHoraFin() {
        fechaFin = new Date();
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public long getTiempo() {
        return (fechaFin.getTime() - fechaIni.getTime()) / 1000 % 60;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String Matricula) {
        this.matricula = Matricula;
    }

    public void pedirMatricula() {
        this.matricula = JOptionPane.showInputDialog("INTRODUCIR MATRICULA: ");
    }

}
