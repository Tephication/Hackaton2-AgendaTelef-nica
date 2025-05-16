public class Contacto {
    //Atributos
    private String nombre;
    private String apellido;
    private String telefono;

    //Constructores
    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //MÉTODOS

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto c = (Contacto) obj;
            return nombre.equalsIgnoreCase(c.nombre) && apellido.equalsIgnoreCase(c.apellido);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre+   "  --  " + "Apellido: " + apellido +   "  --  " + "Teléfono: " + telefono;
    }

    }

