import java.util.ArrayList;

public class Agenda {
    //Atributos
    private ArrayList<Contacto> contactos;
    private int capacidad;

    //Constructores
    public Agenda(int capacidad){
        this.capacidad = capacidad;
        this.contactos = new ArrayList<>();
    }

    public Agenda(){
        this(10);
    }
    //MÉTODOS

    public boolean agregarContacto( Contacto c){
        if (contactos.size() >= capacidad){
            return false;
        }
        if (c.getNombre().isEmpty() || c.getApellido().isEmpty()){
            return false;
        }
        if(contactos.contains(c)){
            return false;
        }
        contactos.add(c);
        return true;
    }

    public boolean eliminarContacto(Contacto c){
        return  contactos.remove(c);
    }

    public boolean modificarContacto(String nombre, String apellido, String nuevoTelefono){
        for (Contacto c : contactos){
            if(c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)){
                c.setTelefono(nuevoTelefono);
                return true;
            }

        }
        return false;
    }

    public boolean agendaLlena(){
        return contactos.size() >= capacidad;
    }
    public int espacioLibre(){
        return capacidad - contactos.size();
    }
    public  ArrayList<Contacto> getContactos(){
        return contactos;
    }
}
