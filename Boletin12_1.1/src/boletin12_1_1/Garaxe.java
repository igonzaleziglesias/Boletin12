package boletin12_1_1;

import PedirDatos.pedir;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Garaxe {

    private static int numCoches = 0;
    private Coche unCoche;
    private int capacidad = 0;
    private Coche[] parking;
    private Date fechaFin;
    private long transcurrido;
    private long horas;
    private float cartosRecividos;
    private float cartosDevoltos;

    public void pedirCapacidad() {
        this.capacidad = Integer.parseInt(JOptionPane.showInputDialog("INDIQUE LA CAPACIDAD DEL PARKING"));
        parking = new Coche[capacidad];
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void aparcar(Coche unCoche) {
        this.unCoche = unCoche;
        this.unCoche.iniciarHoraIni();
        this.parking[numCoches] = this.unCoche;
        numCoches++;
        //System.out.println("\nNUMERO DE COCHES EN EL APARCAMIENTO: " + numCoches);//muestra cuantos coches hay en el garaje
        visualizarArray();
    }

    public void visualizarArray() {
        for (int i = 0; i < numCoches; i++) {
            System.out.print("\n" + i + " Elemento del array: " + parking[i].getMatricula() + " numero de coches: " + numCoches);
        }
    }

    public float precio(int i) {//calcula el precio 3 s -> 1.5 euros +0.20 por segundo 

        if (parking[i].getTiempo() >= 3) {
            return 1.5f + (parking[i].getTiempo() - 3) * 0.20f;//calcula el precio
        } else {
            return 1.5f;
        }

    }

    public int getNumeroCoches() {
        return numCoches;
    }

    public String toString(int i) {
        DecimalFormat formato = new DecimalFormat("0.00");
        //System.out.println("POSICIONDEL ARRAY: " + i);
        return "FACTURA\n" //muestra la factura 
                + "\nMATRICULA COCHE " + parking[i].getMatricula()
                + "\nTEMPO " + formato.format(parking[i].getTiempo()) + "s"
                + "\nPRECIO " + formato.format(precio(i))
                + "\nCARTOS RECIBIDOS " + formato.format(cartosRecividos) + " EUROS"
                + "\nCARTOS DEVOLTOS " + formato.format(cartosDevoltos) + " EUROS"
                + "\n" + "\n"
                + "GRAZAS POR USAR O NOSO APARCADOIRO";
    }

    public int localizarCoche(String matricula) {
        int localizado = 0;
        for (int i = 0; i <= numCoches - 1; i++) {
            if (this.parking[i].getMatricula().equalsIgnoreCase(matricula)) {
                localizado = i;
            }
        }
        //System.out.println("\nPOSICION DEL ARRAY: " + localizado);
        return localizado;
    }

    public void retirar() {
        DecimalFormat formato = new DecimalFormat("0.00");

        if (numCoches == 0) {//comprobacion si garaje vacio
            JOptionPane.showMessageDialog(null, "O APARCADOIRO ESTA VACIO");
        } else {
            String matricula = JOptionPane.showInputDialog("INDIQUE A MATRICULA: ");
            int indicador = localizarCoche(matricula);

            parking[indicador].iniciarHoraFin();//hora de salida del vehiculo
            //System.out.println("\nSEGUNDOS: " + parking[indicador].getTiempo());//calcula el tiempo transcurrido y me lo muestra
            //System.out.println("PRECIO: " + precio(indicador));

            do {
                cartosRecividos = pedir.pedirFloat("PRECIO = " + formato.format(precio(indicador)) + " EUROS" + "\nINGRESE OS CARTOS: ");
                cartosDevoltos = cartosRecividos - precio(indicador);
                if (cartosDevoltos < 0) {//comprobacion saldo suficiente
                    JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE, INGRESE MAS DINERO");
                }
            } while (cartosDevoltos < 0);

            JOptionPane.showMessageDialog(null, toString(indicador));//muestra factura

            for (int i = indicador; i < parking.length - 1; i++) {
                parking[i] = parking[i + 1];
            }
            this.numCoches--;
            visualizarArray();
            //System.out.println("\nNUMERO DE COCHES EN EL APARCAMIENTO: " + numCoches);//muestra numero de coches en el aparcamiento

        }

    }

}
