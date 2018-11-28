package boletin12_1_1;

import PedirDatos.pedir;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Garaxe {
    private static int numCoches = 0;
    private Coche unCoche;
    private int capacidad=0;
    private Coche[] parking ;
    private Date fechaIni;
    private Date fechaFin;
    private long transcurrido;
    private long horas;
    private long minutos;
    private long segundos;
    private float cartosRecividos;
    private float cartosDevoltos;
    
    public void pedirCapacidad(){
        this.capacidad=Integer.parseInt(JOptionPane.showInputDialog("INDIQUE LA CAPACIDAD DEL PARKING"));
        parking = new Coche[capacidad];
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public void aparcar(Coche unCoche){
        fechaIni = new Date();
        this.unCoche=unCoche;
        this.parking[numCoches]=this.unCoche;
        numCoches++;
        System.out.println("NUMERO DE COCHES EN EL APARCAMIENTO: " + numCoches);//muestra cuantos coches hay en el garaje
    }
       public void retirarCoche() {
        if (getNumeroCoches() == 0) {//comprobacion si garaje vacio
            JOptionPane.showMessageDialog(null, "O APARCADOIRO ESTA VACIO");
        } else {
           
            fechaFin = new Date();//hora de salida del vehiculo
            System.out.println("segundos: "+tiempo());//calcula el tiempo transcurrido y me lo muestra
            
            do {
                cartosRecividos = pedir.pedirFloat("PRECIO = " + precio() + " EUROS" + "\nINGRESE OS CARTOS: ");//indica el precio y pide ingreso de dinero
                cartosDevoltos = cartosRecividos - precio();//calcula el dienero a devolver
                if (cartosDevoltos < 0) {//comprobacion saldo suficiente
                    JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE, INGRESE MAS DINERO");
                }
            } while (cartosDevoltos < 0);//repite mientras saldo insuficiente

            this.numCoches--;//retira un coche
            JOptionPane.showMessageDialog(null, toString());//muestra factura
            System.out.println("NUMERO DE COCHES EN EL APARCAMIENTO: " + numCoches);//muestra numero de coches en el aparcamiento
              
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
    
    public float precio() {//calcula el precio 3 s -> 1.5 euros +0.20 por segundo 

        if (segundos >= 3) {
            return 1.5f + (segundos - 3) * 0.20f;//calcula el precio
        }else{
            return 1.5f;
        }
  
    }
    
    public int getNumeroCoches() {
        return numCoches;
    }
    
    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("0.00");
        return "FACTURA\n" //muestra la factura 
                + "\nMATRICULA COCHE "+parking[numCoches].getMatricula()
                + "\nTEMPO "+ tiempo() 
                + "\nPRECIO " + precio()
                + "\nCARTOS RECIBIDOS " + cartosRecividos + " EUROS"
                + "\nCARTOS DEVOLTOS "  + cartosDevoltos + " EUROS"
                + "\n" + "\n"
                + "GRAZAS POR USAR O NOSO APARCADOIRO";
    }
    
}
