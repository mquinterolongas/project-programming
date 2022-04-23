
/**
 * Write a description of class Principal here.
 * 
 * @author Felipe Arcila Palacio, Manuel Quintero Longas y Santiago Quintero Longas 
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //declaración de los arreglos
        ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
        ArrayList<Zombie> ooAB = new ArrayList<Zombie>();
        ArrayList<Zombie> notBoomerZombie = new ArrayList<Zombie>();
        ArrayList<Ubicación> locationList = new ArrayList<Ubicación>();
        ArrayList<Ubicación> closeLocation = new ArrayList<>();

        //menú de funciones
        System.out.println("Bienvenido usuario, a continuación se le explicará que numero ingresar para acceder a las funciones del programa: \n 1  le permite ingresar un nuevo zombie a la base de datos \n 2  para ver los zombies en la base de datos \n 3  para ver la cantidad de zombies creados hatsa el momento \n 4  para ver en pantalla la información de todos los zombies que tengan tipo de sangre O+ o AB+ \n 5  para ver a los zombies nacidos tras el año 2000 \n 6  para disminuir el valor registrado de Health de cada zombie a la mitad \n 7  para registrar un nuevo lugar y sus respectivos datos \n 8  para ver las locaciones registradas hasta el momento \n 9  para ver cual es la locación mas segura registrada \n 10 para ver las locaciones según su distancia con respecto a Alexandría \n 11 para ver una frase sobre zombies \n 12 para (por definir)");

        //variables primitivas del codigo
        float power = 1;
        for (int t = 1; t <= 38; t++) { // este for solo cumple el proposito de crear una variable igual a 10^38 para crear un float masivo
            power = power * 10;
        }
        float minDist = (float) (3.4 * power);//tomará el valor de la menor distancia a Alexandría de una ubicación
        float maxDist = 0; //tomará el valor de la mayor distancia a Alexandría de una ubicación
        int maxSec = 2147483647;

        int menuOpt;
        while (true) {
            menuOpt = s.nextInt();

            if (menuOpt == 0) {
                System.exit(0);
            }
            if (menuOpt == 1) {
                Zombie x = new Zombie();

                System.out.println("dijite el nombre del zombie");
                String nombre = s.next();
                x.setNombre(nombre);

                System.out.println("dijite la Health del zombie");
                int Health = s.nextInt();
                x.setSalud(Health);

                System.out.println("dijite la fecha de nacimiento del zombie (dijitela siguiendo: dd/mm/aaaa, ejemplo: 01/01/2001");
                String fecha = s.next();
                x.setFn(fecha);

                System.out.println("dijite el tipo de sangre del zombie (en mayuscula siguiendo el ejemplo: AB-");
                String sangre = s.next();
                x.setRh(sangre);

                zombieList.add(x);
                if (x.getRh().equals("O+") || x.getRh().equals("AB+")) {
                    ooAB.add(x);
                }
                Integer año = Integer.parseInt(x.getFn().substring(6, 10));
                if (año > 2000) {
                    notBoomerZombie.add(x);
                }
            }
            if (menuOpt == 2) {
                if (zombieList.size() > 0) {
                    for (int i = 0; i <= zombieList.size() - 1; i++) {
                        System.out.println("nombre: " + zombieList.get(i).getNombre() + " Health: " + zombieList.get(i).getSalud() + " fecha de nacimiento: " + zombieList.get(i).getFn() + " tipo de sangre: " + zombieList.get(i).getRh());
                    }
                } else {
                    System.out.println("no hay zombies registados en el sistema");
                }
            }
            if (menuOpt == 3) {
                System.out.println("se han registrado " + zombieList.size() + " zombies");
            }
            if (menuOpt == 4) {
                if (ooAB.size() > 0)
                    for (int i2 = 0; i2 <= ooAB.size() - 1; i2++) {
                        System.out.println("nombre: " + ooAB.get(i2).getNombre() + " Health: " + ooAB.get(i2).getSalud() + " fecha de nacimiento: " + ooAB.get(i2).getFn() + " tipo de sangre: " + ooAB.get(i2).getRh() + "\n");
                    }
                else {
                    System.out.println("no hay zombies registrados con sangre O+ o AB+ \n");
                }
            }
            if (menuOpt == 5) {
                if (notBoomerZombie.size() > 0) {
                    for (int i3 = 0; i3 <= notBoomerZombie.size() - 1; i3++) {
                        System.out.println("nombre: " + notBoomerZombie.get(i3).getNombre() + " Health: " + notBoomerZombie.get(i3).getSalud() + " fecha de nacimiento: " + notBoomerZombie.get(i3).getFn() + " tipo de sangre: " + notBoomerZombie.get(i3).getRh());
                    }
                } else {
                    System.out.println("no hay zombies nacidos despues del año 2000 registrados");
                }
            }
            if (menuOpt == 6) {
                for (int i4 = 0; i4 <= zombieList.size() - 1; i4++) {
                    zombieList.get(i4).setSalud(zombieList.get(i4).getSalud() / 2);
                }
            }
            if (menuOpt == 7) {
                Ubicación y = new Ubicación();
                System.out.println("dijite el nombre de la ubicación");
                String nombre = s.next();
                y.setNombre(nombre);

                System.out.println("dijite la distancia desde Alexandría en metros");
                float dist = s.nextFloat();
                y.setDistancia(dist);

                System.out.println("dijite el numero de zombies presentes en la ubicación");
                int numZomb = s.nextInt();
                y.setNumZom(numZomb);

                locationList.add(y);
            }
            if (menuOpt == 8) {
                for (int i6 = 0; i6 < locationList.size(); i6++) {
                    System.out.println("nombre: " + locationList.get(i6).getNombre() + " distancia:" + locationList.get(i6).getDistancia() + "numero de zombies: " + locationList.get(i6).getNumZom());
                }
            }
            if (menuOpt == 9) {
                int safer = locationList.get(0).getNumZom();
                for (int i7 = 0; i7 < locationList.size(); i7++) {
                    if (locationList.get(i7).getNumZom() > safer) {
                        safer = locationList.get(i7).getNumZom();
                    }
                }
                System.out.println("el mas seguro es: " + safer);
            }
            if (menuOpt == 10) {
                for (int duplicator = 0; duplicator < locationList.size(); duplicator++) {
                    closeLocation.add(locationList.get(duplicator));
                }
                if (locationList.size() < 0) {
                    System.out.println("No hay ubicaciones registradas");
                } else {
                    Collections.sort(closeLocation);
                    for (int i5 = 0; i5 < locationList.size(); i5++) {
                        System.out.println("nombre: " + closeLocation.get(i5).getNombre() + " distancia:" + closeLocation.get(i5).getDistancia() + "numero de zombies: " + closeLocation.get(i5).getNumZom());
                    }
                }
            }
            if (menuOpt == 11) {
                String[] random = {"Cuando los muertos echan a andar, ¿para qué obstinarse en matarlos? No hay formas de vencerlos.", "Viven para la noche, viven para matar, y ... viven siempre.", "¡No pienso seguir hablando hasta que no te coloques la cabeza!", "No se puede usar maquillaje normal sobre la piel muerta, los poros están demasiados secos... hay que usar una paleta y prácticamente incrustarla en la piel.", "¡Odio las momias, nunca juegan limpio!"};
                Random rand = new Random();
                int num = rand.nextInt(6);
                String z = random[num];
                if (menuOpt == 11) {
                    System.out.println(z);
                }
            }
            if (menuOpt == 12) {
                int moreDang = locationList.get(0).getNumZom();
                for (int i7 = 0; i7 < locationList.size(); i7++) {
                    if (locationList.get(i7).getNumZom() < moreDang) {
                        moreDang = locationList.get(i7).getNumZom();
                    }
                }
                System.out.println("el mas seguro es: " + moreDang);
            }
        }
    }
}





