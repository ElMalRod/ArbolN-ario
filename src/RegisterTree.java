/* Clase RegisterTree
 Clase que representa un arbol n-ario de registros
* */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RegisterTree {
    // Mapa de registros
    private Map<Integer, Nodo> mapRegister;

    public RegisterTree() {
        this.mapRegister = new HashMap<>();
    }
    // Metodo para agregar un registro al arbol
    // Se agrega un registro al mapa de registros y se agrega el nodo al arbol
    public void addRegister(Register register) {
        Nodo nodo = new Nodo(register);
        mapRegister.put(register.id, nodo);
        if (register.idPadre != 0) {
            Nodo nodoPadre = mapRegister.get(register.idPadre);
            nodoPadre.hijos.add(nodo);
        }
    }
    // Metodo para obtener los nodos raiz del arbol
    // Se recorre el mapa de registros y se agregan los nodos que no tienen padre
    public List<Nodo> getRoots() {
        List<Nodo> roots = new ArrayList<>();
        for (Nodo nodo : mapRegister.values()) {
            if (nodo.data.idPadre == 0) {
                roots.add(nodo);
            }
        }
        return roots;
    }
    // Metodo para imprimir el arbol
    // Se recorre el arbol recursivamente
    public void printRoot(Nodo nodo, int level){
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(nodo.data.name);
        for (Nodo hijo : nodo.hijos) {
            printRoot(hijo, level + 1);
        }
    }
    // Metodo para imprimir el arbol
    // Se obtienen los nodos raiz y se llama al metodo printRoot
    public void printTree(){
        for (Nodo root : getRoots()) {
            printRoot(root, 0);
        }
    }
    public static void main(String[] args) {
        RegisterTree registerTree = new RegisterTree();

        registerTree.addRegister(new Register(1, "Mascotas", 0));
        registerTree.addRegister(new Register(2, "Gato", 1));
        registerTree.addRegister(new Register(3, "Perro", 1));
        registerTree.addRegister(new Register(4, "Plantas", 0));
        registerTree.addRegister(new Register(5, "Arbol", 4));
        registerTree.addRegister(new Register(6, "Flores", 3));
        registerTree.addRegister(new Register(7, "Micu", 2));
        registerTree.addRegister(new Register(8, "Sasy", 2));
        registerTree.addRegister(new Register(9, "Fido", 3));
        registerTree.addRegister(new Register(10, "Bobby", 3));
        registerTree.addRegister(new Register(11, "Roble", 5));
        // Tarea 1
        registerTree.addRegister(new Register(12, "Bigote", 2));
        registerTree.addRegister(new Register(13, "Pino", 5));
        // Tarea 2
        /*
        El Registro  id 6  Flores No tiene relacion con el registro id 5 Arbol el cual
        es su Nodo padre, por lo tanto no se muestra en el arbol de salida correcto.
        para la solucion de este problema se debe cambiar el idPadre del registro 6 Flores
        de 3 a 4, ya que el registro id 4 Plantas es su Nodo padre.

           registerTree.addRegister(new Register(6, "Flores", 4));

        * */

        //Tarea 3.a
        // Tomar en cuenta que la tabla puede crecer en n cantidad de registros y n cantidad de
        //niveles anidados.

        registerTree.addRegister(new Register(14, "Comida", 0));
        registerTree.addRegister(new Register(15, "Frutas", 14));
        registerTree.addRegister(new Register(16, "Manzana", 15));
        registerTree.addRegister(new Register(17, "Pera", 15));
        registerTree.addRegister(new Register(18, "Verduras", 14));
        registerTree.addRegister(new Register(19, "Zanahoria", 18));
        registerTree.addRegister(new Register(20, "Lechuga", 18));


        registerTree.printTree();

    }
}