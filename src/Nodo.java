import java.util.List;
import java.util.ArrayList;
/**
 * Clase Nodo para Arbol n-ario
 */
public class Nodo {
    Register data;
    List<Nodo> hijos;

    public Nodo(Register data){
        this.data = data;
        this.hijos = new ArrayList<>();
    }
}
