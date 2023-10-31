import javax.swing.JOptionPane;

/**
 * AUTORES: 
 * Daniel Perez
 * Camilo Ospina
 * Cristhian Osorio
 */

public class Principal {
    public static void main(String[] args) {
        // el menu va a ser de la siguiente manera:

        /**
         * MENU 
         * 1. Crear torneo
         * 2. Entrar a torneo
         * 3. salir
         * 
         * 1. en crear torneo se va a llamar al constructor por asi decirlo 
         * 
         * 2.
         *  a. Añadir equipo, cuando se unda añadir equipo se llama comparar fecha
         *  b. modificar fechas
         *    
         *  c. enfrentamientos 
         *  d. equipos 
         *  e. jueces 
         *  f. volver 
         * 
         * C. en c se llenarian los campos referente a los equipos y todo lo demas
         * 
         * 1. general 
         * 2. buscar por equipos  
         * 3. buscar por juez 
         * 4. resultados  
         * 5. modificar enfrentamientos 
         * 
         */

        int op = 0; 
        do {
            op = Integer.parseInt(pedir("1. Crear torneo\n 2. Entrar al torneo\n 3. salir"));

            if (op == 1) {


            }
            if (op == 2) {

                int option = 0;
                do {
                    option = Integer.parseInt(pedir(
                            "1. Añadir equipo\n 2. modificar fechas\n 3. enfrentamientos\n 4. equipos\n 5. jueces\n 6. volver"));
                    
                    if (option == 1) {

                    }
                    if (option == 2) {

                    }
                    if (option == 3) {
                        int optionn = 0;

                        do {
                            optionn = Integer.parseInt(pedir(
                            "1. general\n 2. buscar por equipos\n 3. buscar por juez\n 4. resultados\n 5. modificar enfrentamientos\n 6. volver"));
                        } while (optionn != 6);

                        if (option == 4) {

                         }
                         if (option == 5) {

                         }
                         if (option == 6) {

                         }
                         if (option == 4) {

                        }
                         if (option == 5) {

                        }
                         if (option == 6) {
                        
                         }
                    }
                    if (option == 4) {

                    }
                    if (option == 5) {

                    }
                    if (option == 6) {
                        
                    }
                } while (option != 6);

            }
            if (op == 3) {
                System.exit(0);    
            }    
         } while (op != 3);



    }

    public static String pedir(String msj){
        return JOptionPane.showInputDialog(null, msj);
    }
    
}
