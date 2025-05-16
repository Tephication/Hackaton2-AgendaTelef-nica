public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
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

    /* revisar por si tocar hacer overide con algun metodo de la clase agenda o main*/

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

    /* revisar si esto se debe volver override

     */






    }

