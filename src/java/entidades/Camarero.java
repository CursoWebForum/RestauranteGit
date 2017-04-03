
package entidades;


public class Camarero {
    
    int idCamarero; 
    String nombre; 
    String apellido;
    
    public Camarero(){
    }

    public Camarero(int idCamarero, String nombre, String apellido) {
        this.idCamarero = idCamarero;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    

    public void setIdCamarero(int idCamarero) {
        this.idCamarero = idCamarero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    

    public int getIdCamarero() {
        return idCamarero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    
    
    
    
}
