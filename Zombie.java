
/**
 * Clase del objeto zombie con la cual el usuario podrá registrar información de zombies en los arreglos de la clase Principal
 * 
 * @author (Felipe Arcila Palacio, Manuel Quintero Longas y Santiago Quintero Longas) 
 */
public class Zombie {

        //datos de los zombies (variables nativas de la clase)
        private String nombre;
        private int salud;
        private String fn;
        private String rh;

        //setters para las propiedades de cada zombie
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setSalud(int salud) {
            this.salud = salud;
        }

        public void setFn(String fn) {
            this.fn = fn;
        }

        public void setRh(String rh) {
            this.rh = rh;
        }

        //getters para las propiedades de los zombies
        public String getNombre() {
            return nombre;
        }

        public String getFn() {
            return fn;
        }

        public String getRh() {
            return rh;
        }

        public int getSalud() {
            return salud;
        }
}

