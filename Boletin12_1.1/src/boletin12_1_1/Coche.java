package boletin12_1_1;

import javax.swing.JOptionPane;

public class Coche {

    String matricula;
    String marca;

    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public Coche() {
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
