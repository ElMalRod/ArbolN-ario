
/* Clase que representa un registro de la tabla de la base de datos
    * id: identificador del registro
    * name: nombre del registro
    * idPadre: identificador del registro padre
* */

public class Register {
    int id;
    String name;
    int idPadre;

    public Register(int id, String name, int idPadre) {
        this.id = id;
        this.name = name;
        this.idPadre = idPadre;
    }
}
