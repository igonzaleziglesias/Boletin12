package boletin12_1;

import PedirDatos.pedir;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Garaxe {

    private static int numeroCoches = 0;
    private String[] matricula = new String[5];
    private float precio = 0;
    private Date fechaIni;
    private Date fechaFin;
    private long transcurrido;
    private long horas;
    private long minutos;
    private long segundos;
    private float cartosRecividos;
    private float cartosDevoltos;

    public void aparcar(String matricula) {
            JOptionPane.showMessageDialog(null, "PLAZAS DISPOÑIBLES");

            fechaIni = new Date();//hora de ingreso del vehiculo

            this.matricula[numeroCoches] = matricula;//introduce la matricula en el array
            this.numeroCoches++;//aumenta el numero de coches

            System.out.println("NUMERO DE COCHES EN EL APARCAMIENTO: " + numeroCoches);//muestra cuantos coches hay en el garaje

    }

    public Garaxe(String matricula) {
        //aparcar(matricula);
    }

    public void retirarCoche() {
        if (getNumeroCoches() == 0) {//comprobacion si garaje vacio
            JOptionPane.showMessageDialog(null, "O APARCADOIRO ESTA VACIO");
        } else {
           
            fechaFin = new Date();//hora de salida del vehiculo
            System.out.println("segundos: "+tiempo());//calcula el tiempo transcurrido y me lo muestra
            
            do {
                cartosRecividos = pedir.pedirFloat("PRECIO = " + precio2() + " EUROS" + "\nINGRESE OS CARTOS: ");//indica el precio y pide ingreso de dinero
                cartosDevoltos = cartosRecividos - precio2();//calcula el dienero a devolver
                if (cartosDevoltos < 0) {//comprobacion saldo suficiente
                    JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE, INGRESE MAS DINERO");
                }
            } while (cartosDevoltos < 0);//repite mientras saldo insuficiente

            this.numeroCoches--;//retira un coche
            JOptionPane.showMessageDialog(null, toString());//muestra factura
            System.out.println("NUMERO DE COCHES EN EL APARCAMIENTO: " + numeroCoches);//muestra numero de coches en el aparcamiento
              
        }

    }

    public String tiempo() {//calcula el tiempo real transcurrido en horas/minutos/segundos
        this.transcurrido = this.fechaFin.getTime() - this.fechaIni.getTime();
        this.segundos = (transcurrido / 1000) % 60;
        this.minutos = (transcurrido / (60 * 1000)) % 60;
        this.horas = (transcurrido / (3600 * 1000)) % 60;

        DecimalFormat formato = new DecimalFormat("00");

        return formato.format(horas) + "-" + formato.format(minutos) + "-" + formato.format(segundos);//tiempo transcurrido en horas/minutos/segundos

    }
   

    public void setNumeroCoches(int numeroCoches) {
        this.numeroCoches = numeroCoches;
    }

    public String pedirMatricula() {
        if (getNumeroCoches() < 5) {
            this.matricula[getNumeroCoches()] = JOptionPane.showInputDialog("INTRODUZCA A MATRICULA");//pide matricula
        }
        return matricula[getNumeroCoches()];
    }

    public int getNumeroCoches() {
        return numeroCoches;
    }

    public float precio() {//calcula el precio 3 h -> 1.5 euros +0.20 por hora

        if (horas >= 3) {
            return 1.5f + (horas - 3) * 0.20f;//calcula el precio
        }else{
            return 1.5f;
        }

    }
    
    public float precio2() {//calcula el precio 3 s -> 1.5 euros +0.20 por segundo 

        if (segundos >= 3) {
            return 1.5f + (segundos - 3) * 0.20f;//calcula el precio
        }else{
            return 1.5f;
        }
  
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("0.00");
        return "FACTURA\n" //muestra la factura 
                + "\nMATRICULA COCHE " + matricula[getNumeroCoches()]
                + "\nTEMPO " + tiempo()
                + "\nPRECIO " + precio2()
                + "\nCARTOS RECIBIDOS " + formato.format(cartosRecividos) + " EUROS"
                + "\nCARTOS DEVOLTOS " + formato.format(cartosDevoltos) + " EUROS"
                + "\n" + "\n"
                + "GRAZAS POR USAR O NOSO APARCADOIRO";
    }

    /*public int localizarCoche(String matricula){
        int localizado=0;
        for (int i = 0; i<=4; i++){
            if (this.matricula[i].equalsIgnoreCase(matricula)){
                localizado =  i;
            }
        }
        return localizado;    
    }*/
}
