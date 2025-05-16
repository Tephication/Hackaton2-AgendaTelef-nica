import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Agenda agenda = new Agenda();
    private JTextField nombre = new JTextField(10);
    private JTextField apellido = new JTextField(10);
    private JTextField telefono = new JTextField(10);
    private JTextArea salida = new JTextArea(10,20);

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

        JPanel botones = new JPanel();
        JButton agregarButton = new JButton("Agregar");
        JButton eliminarButton = new JButton("Eliminar");
        JButton modificarButton = new JButton("Modificar");
        JButton llenaButton = new JButton("Espacios");
        JButton libreButton = new JButton("Disponibilidad");
        JButton mostrarTodo = new JButton("Mostrar contactos");
        JButton buscar = new JButton("Buscar contacto");


        botones.add(agregarButton);
        botones.add(eliminarButton);
        botones.add(modificarButton);
        botones.add(llenaButton);
        botones.add(libreButton);
        botones.add(mostrarTodo);
        botones.add(buscar);


        salida.setEditable(false);
        JScrollPane scroll = new JScrollPane(salida);

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

            for (Contacto c : agenda.getContactos()){
                if (c.getNombre().equalsIgnoreCase(nombreS) && c.getApellido().equalsIgnoreCase(apellidoS)){
                    salida.setText("✅ Contacto encontrado, su teléfono es: " + c.getTelefono());
                } else {
                    salida.setText("❌ Este contacto no se ha encontrado");
                }
            }
            nombre.setText("");
            apellido.setText("");
            telefono.setText("");
        });

        add(panelEntrada, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
        MainPrueba consola = new MainPrueba();
        //consola.mostrarConsola();
    }

}
