package boletin12_1_1;

import javax.swing.JOptionPane;

public class Boletin12_1 {

    public static void main(String[] args) {
        Coche unCoche ;
        Garaxe unGaraje = new Garaxe();
        /*Garaxe tresCoche = new Garaxe("ABDS234");
        Garaxe cuatroCoche = new Garaxe("ABDS234");
        Garaxe cincoCoche = new Garaxe("ABDS234");
        Garaxe coche = new Garaxe("ABDS234");
        cincoCoche.retirarCoche();
        JOptionPane.showMessageDialog(null, cincoCoche.toString());
        cincoCoche.aparcar("ABDS234");*/
        unGaraje.pedirCapacidad();
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
                    if (unGaraje.getNumeroCoches() < unGaraje.getCapacidad()) {
                        unCoche= new Coche();
                        unCoche.pedirMatricula();
                        unGaraje.aparcar(unCoche);
                        break;
                    } else {
                        System.out.println("NUMERO DE COCHES EN EL APARCAMIENTO: " + unGaraje.getNumeroCoches());
                        JOptionPane.showMessageDialog(null, "COMPLETO");
                        break;
                    }

                case 1:
                    unGaraje.retirarCoche();
                    break;
                case 2:
                    condicion = true;
                    break;
            }
        } while (condicion != true);

    }
}
