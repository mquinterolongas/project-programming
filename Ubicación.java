
/**
 * Clase del objeto Ubicaciónes con la cual el usuario podrá registrar ubicaciones y posteriormente organizarlas en orden de distancia a Alexandría y ver cual es más segura o más insegura.
 * 
 * @author Felipe Arcila Palacio, Manuel Quintero Longas y Santiago Quintero Longas
 * @version (a version number or a date)
 */
public class Ubicación implements Comparable<Ubicación>{
   //las propiedades de cada ubicación
    private String name;
    private float distance;
    private int numZom;

    //métodos para asignar la información correspondiente de cada característica
    public void setNombre(String name) {
        this.name = name;
    }
    public void setDistancia(float distance) {
        this.distance = distance;
    }
    public void setNumZom(int numZom) {
        this.numZom = numZom;
    }
    
    //métodos para retornar las caracteristicas de una ubicación
    public String getNombre() {
        return name;
    }
    public float getDistancia() {
        return  distance;
    }
    public int getNumZom() {
        return numZom;
    }

    @Override
    public int compareTo(Ubicación e){ //este método crea un nuevo arreglo según la distancia en orden ascendente
        if(e.getDistancia() > distance){
            return -1;
        }else if(e.getDistancia() == distance){
            return 0;
        }else{
            return 1;
        }
    }
}

