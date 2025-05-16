import java.util.Scanner;

public class MainPrueba {
    public static void mostrarConsola() {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion;
        do {
            System.out.println("\n---🔣 Bienvenido(a) a tu agenda telefónica 🔣---");
            System.out.println("Menú de opciones");
            System.out.println("1. Agregar contacto✅✏️");
            System.out.println("2. Eliminar contacto❌📒");
            System.out.println("3. Modificar teléfono🔁📲");
            System.out.println("4. Ver si la agenda está llena 👀‼️📝");
            System.out.println("5. Ver espacios libres en la agenda 👀🆓📝");
            System.out.println("6. Ver tus contactos 👀📝🔠");
            System.out.println("7. Buscar contacto 👀📝");
            System.out.println("8. Salir🔄️");
            System.out.println("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre ✏️: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el apellido ✏️: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingresa el teléfono ✏️: ");
                    String telefono = scanner.nextLine();



                    if (nombre.isEmpty() || apellido.isEmpty()){
                        System.out.println("🚫Dedes ingresar nombre y apellido, estos no pueden quedar vacíos");
                    } else {
                        Contacto nuevoC = new Contacto(nombre,apellido,telefono);
                        if (agenda.agregarContacto(nuevoC)){
                            System.out.println("Contacto agregado exitosamente 📲");
                        } else {
                            System.out.println("Contacto NO agregado, este nombre/apellido ya existe o el espacio está lleno");
                        }
                    }
                    break;
                case 2:
                    System.out.println("📝❌Ingresa el nombre del contacto a eliminar: ");
                    String nombrex = scanner.nextLine();
                    System.out.println("📝❌ Ingresa el apellido: ");
                    String apellidox = scanner.nextLine();
                    Contacto contactox = new Contacto(nombrex,apellidox,"");
                    if (agenda.eliminarContacto(contactox)){
                        System.out.println("Contacto eliminado exitosamente");
                    } else {
                        System.out.println("El contacto ingresado no existe o los espacios están vacíos");
                    }
                    break;


                case 3:
                    System.out.println("Ingresa el nombre del contacto al que deseas cambiar el teléfono: ");
                    String nombreT = scanner.nextLine();
                    System.out.println("Ingresa el apellido del contacto al que deseas cambiar el teléfono: ");
                    String apellidoT = scanner.nextLine();
                    System.out.println("Ingresa el nuevo número de teléfono: ");
                    String telefonoT = scanner.nextLine();
                    boolean contactoT = agenda.modificarContacto(nombreT,apellidoT,telefonoT);
                    if (contactoT){
                        System.out.println("Contacto modificado exitosamente");
                    } else {
                        System.out.println("No hubo modificación ya que el contacto no existe");
                    }
                    break;

                case 4:
                    if (agenda.agendaLlena()){
                        System.out.println("Tu agenda está llena, no tienes espacio para agregar nuevos contactos 😑⛔");
                    } else {
                        System.out.println("Tu agenda aún tiene espacio 👌🏽📝");
                    }
                    break;
                case 5:
                    System.out.println("Espacios disponibles en tu agenda: " + agenda.espacioLibre());
                    break;
                case 6:
                    System.out.println("Tus contactos son: ");
                    for (Contacto contactTodos : agenda.getContactos()){
                        System.out.println(contactTodos.toString());
                    }
                    break;
                case 7:
                    System.out.println("Ingresa el nombre que quieres buscar: ");
                    String nombreS = scanner.nextLine();
                    System.out.println(" Ingresa el apellido que quieres buscar: ");
                    String apellidoS = scanner.nextLine();

                    for (Contacto c : agenda.getContactos()){
                        if (c.getNombre().equalsIgnoreCase(nombreS) && c.getApellido().equalsIgnoreCase(apellidoS)){
                            System.out.println("✅ Contacto encontrado, su teléfono es: " + c.getTelefono());
                        } else {
                            System.out.println("❌ Este contacto no se ha encontrado");
                        }
                    }

                case 8:
                    System.out.println("👋🏽 Gracias por utilizar el menú. Nos vemos después 👋🏽");
                    break;
                default:
                    System.out.println("Ingresaste una opción inválida ❌");
            }

        } while (opcion != 8);
        scanner.close();

    }
}