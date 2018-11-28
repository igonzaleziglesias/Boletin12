package boletin12_1;

import javax.swing.JOptionPane;

public class Boletin12_1 {

    public static void main(String[] args) {
        Garaxe unCoche = new Garaxe("ABDS234");
        Garaxe dosCoche = new Garaxe("ABDS234");
        /*Garaxe tresCoche = new Garaxe("ABDS234");
        Garaxe cuatroCoche = new Garaxe("ABDS234");
        Garaxe cincoCoche = new Garaxe("ABDS234");
        Garaxe coche = new Garaxe("ABDS234");
        cincoCoche.retirarCoche();
        JOptionPane.showMessageDialog(null, cincoCoche.toString());
        cincoCoche.aparcar("ABDS234");*/

        boolean condicion = false;
        do {
            String[] opciones = {"APARCAR", "RETIRAR VEHICULO", "SALIR"};
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "QUE ACCION DESEA REALIZAR?",
                    null,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    null
            );

            switch (opcion) {
                case 0:
                    if (unCoche.getNumeroCoches()<5) {
                        unCoche.aparcar(unCoche.pedirMatricula());
                        break;
                    }else {
                        System.out.println("NUMERO DE COCHES EN EL APARCAMIENTO: " + unCoche.getNumeroCoches());
                        JOptionPane.showMessageDialog(null, "COMPLETO");
                        break;
                    }
                    
                case 1:
                    unCoche.retirarCoche();
                    break;
                case 2:
                    condicion = true;
                    break;
            }
        } while (condicion != true);

    }
}
