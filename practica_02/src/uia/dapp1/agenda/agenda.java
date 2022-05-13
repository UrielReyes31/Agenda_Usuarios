package uia.dapp1.agenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class agenda {
    private JButton registrarContactoButton;
    private JButton salirButton;
    private JPanel agenda;
    private JTable tablacontactos;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textEdad;
    private JTextField textTelfijo;
    private JTextField textTelcel;
    private JTextField textFechacum;
    private JButton ActualizarButton;
    DefaultTableModel modelo = new DefaultTableModel();
    formulario contactos = new formulario();
    List<Persona> personas = new ArrayList<Persona>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("agenda");
        frame.setContentPane(new agenda().agenda);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public agenda() {
        crearmodelotabla();
        acciones();
    }
    public void acciones() {
        registrarContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                contactos.setContentPane(contactos.getpanel());
                contactos.setVisible(true);
                contactos.setLocationRelativeTo(null);
                contactos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                contactos.setSize(700, 400);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ActualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personas.add(contactos.getPersona());
                llenartabla();
            }
        });
        tablacontactos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);//mostrar los datos del usuario que le damos click
                int seleccionar = tablacontactos.rowAtPoint(e.getPoint());
                textNombre.setText(String.valueOf(tablacontactos.getValueAt(seleccionar,0)));
                textApellidos.setText(String.valueOf(tablacontactos.getValueAt(seleccionar,1)));
                textEdad.setText(String.valueOf(tablacontactos.getValueAt(seleccionar,2)));
                textTelfijo.setText(String.valueOf(tablacontactos.getValueAt(seleccionar,3)));
                textTelcel.setText(String.valueOf(tablacontactos.getValueAt(seleccionar,4)));
                textFechacum.setText(String.valueOf(tablacontactos.getValueAt(seleccionar,5)));
            }
        });
    }

    public void crearmodelotabla() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Edad");
        modelo.addColumn("Tel. Fijo");
        modelo.addColumn("Tel. Celular");
        modelo.addColumn("Fecha Nacimiento");
        this.tablacontactos.setModel(modelo);
    }

    public void llenartabla() {
        modelo.setRowCount(0);
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < personas.size(); i++) {
            fila[0] = personas.get(i).getNombre();
            fila[1] = personas.get(i).getApellidos();
            fila[2] = personas.get(i).getEdad();
            fila[3] = personas.get(i).getNumerofijo();
            fila[4] = personas.get(i).getNumeroCelular();
            fila[5] = personas.get(i).getFechanacimiento();
            modelo.addRow(fila);
        }
    }
}

