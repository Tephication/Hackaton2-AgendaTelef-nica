import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    //Instanciado el objeto agenda de la clase Agenda
    Agenda agenda = new Agenda();

    //Creando campos de formulario
    private JTextField nombre = new JTextField(16);
    private JTextField apellido = new JTextField(16);
    private JTextField telefono = new JTextField(16);
    private JTextArea salida = new JTextArea(10,20);

    //Constructor
    public Main(){
        setTitle("Agenda telefónica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Aca se organiza Nombre, Apellido y Telefono
        JPanel panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Nombre: "));
        panelEntrada.add(nombre);
        panelEntrada.add(new JLabel("Apellido: "));
        panelEntrada.add(apellido);
        panelEntrada.add(new JLabel("Teléfono: "));
        panelEntrada.add(telefono);

        //Creación de panel de botones
        JPanel botones = new JPanel();
        JButton agregarButton = new JButton("Agregar");
        JButton eliminarButton = new JButton("Eliminar");
        JButton modificarButton = new JButton("Modificar");
        JButton llenaButton = new JButton("Disponibilidad");
        JButton libreButton = new JButton("Espacios libres");
        JButton mostrarTodo = new JButton("Mostrar contactos");
        JButton buscar = new JButton("Buscar contacto");


        botones.add(agregarButton);
        botones.add(eliminarButton);
        botones.add(modificarButton);
        botones.add(llenaButton);
        botones.add(libreButton);
        botones.add(mostrarTodo);
        botones.add(buscar);

        //Estilo de botones
        estilosBotones(agregarButton, new Color(138,243,143));
        estilosBotones(eliminarButton, new Color(250,198,191));
        estilosBotones(modificarButton, new Color(234,234,67));
        estilosBotones(llenaButton, new Color(157,216,197));
        estilosBotones(libreButton, new Color(116, 172, 222));
        estilosBotones(mostrarTodo, new Color(200,184,231));
        estilosBotones(buscar, new Color(158, 252, 231));

        //Estilo de inputs
        nombre.setFont(new Font("Poppins", Font.BOLD, 14));
        apellido.setFont(new Font("Poppins", Font.BOLD, 14));
        telefono.setFont(new Font("Poppins", Font.BOLD, 14));

        //Para mostrar mensaje
        salida.setEditable(false);
        JScrollPane scroll = new JScrollPane(salida);

        //Instanciación de métodos para cada botón
        agregarButton.addActionListener(e -> {
            Contacto nuevoC = new Contacto(nombre.getText(), apellido.getText(), telefono.getText());
            if (agenda.agregarContacto(nuevoC)){
                salida.setText("✅¡¡¡ Contacto agregado exitosamente !!!");

            } else {
                salida.setText("❌Contacto NO agregado,este nombre/apellido ya existe o la agenda no tiene espacio");
            }
            nombre.setText("");
            apellido.setText("");
            telefono.setText("");
        });

        eliminarButton.addActionListener(e -> {
            Contacto contactox = new Contacto(nombre.getText(), apellido.getText(), "");
            if (agenda.eliminarContacto(contactox)){
                salida.setText("✅Contacto eliminado exitosamente");
            } else {
                salida.setText("❌El contacto ingresado no existe o los campos no están diligenciados");
            }
        });

        modificarButton.addActionListener(e -> {
            boolean contactoT = agenda.modificarContacto(nombre.getText(), apellido.getText(), telefono.getText());
            if (contactoT){
                salida.setText("✅ Contacto modificado exitosamente");
            } else {
                salida.setText("❌ No hubo modificación ya que el contacto no existe");
            }
        });

        llenaButton.addActionListener(e -> {
            if (agenda.agendaLlena()){
                salida.setText("😑⛔ Tu agenda está llena, no tienes espacio para agregar nuevos contactos ");
            } else {
                salida.setText("✅ Tu agenda aún tiene espacio");
            }
        });

        libreButton.addActionListener(e -> {
            salida.setText("✅ Espacios disponibles en tu agenda: " + agenda.espacioLibre());

        });

        mostrarTodo.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Tus contactos son:\n");
            for (Contacto contactTodos : agenda.getContactos()) {
                sb.append(contactTodos).append("\n");
            }
            salida.setText(sb.toString());
        });

        buscar.addActionListener(e -> {
            String nombreS = nombre.getText();
            String apellidoS = apellido.getText();

            boolean encontrado = false;

            for (Contacto c : agenda.getContactos()) {
                if (c.getNombre().equalsIgnoreCase(nombreS) && c.getApellido().equalsIgnoreCase(apellidoS)) {
                    salida.setText("✅ Contacto encontrado, su teléfono es: " + c.getTelefono());
                    encontrado = true;
                    break; // ya lo encontramos, salimos del bucle
                }
            }

            if (!encontrado) {
                salida.setText("❌ Este contacto no se ha encontrado");
            }

            nombre.setText("");
            apellido.setText("");
            telefono.setText("");
        });

        //Organización panel de entrada
        add(panelEntrada, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }
    //Método para estilos de botones
    private void  estilosBotones (JButton btn, Color fondo){
        btn.setBackground(fondo);
        btn.setForeground(Color.black);
        btn.setFont(new Font("Poppins", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
//        btn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));



    }

    //Punto de ejecución
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
        MainPrueba consola = new MainPrueba();
        //consola.mostrarConsola();
    }

}
