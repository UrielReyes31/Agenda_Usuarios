package uia.dapp1.agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class formulario  extends  JFrame{
    private JTextField textNombre;
    private JTextField textapellidos;
    private JTextField textedad;
    private JTextField textelfijo;
    private JTextField textelcel;
    private JTextField textFechanacimoento;
    private JButton guardarButton;
    private JPanel formulario;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private Long numerofijo;
    private Long numeroCelular;
    private String Fechanacimiento;
    Persona persona;
    private static final String LIMPIAR = "";

    public formulario() {
        createUIComponents();
    }
    void createUIComponents(){
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setNombre(textNombre.getText());
                    setApellidos(textapellidos.getText());
                    setEdad(textedad.getText());
                    setNumerofijo(textelfijo.getText());
                    setNumeroCelular(textelcel.getText());
                    setFechanacimiento(textFechanacimoento.getText());
                } catch (NumberFormatException aq){
                    JOptionPane.showMessageDialog(null,"llena los campos correctamente");

                }catch (Exception aa){
                    JOptionPane.showMessageDialog(null,"llena todos los campos correctamente");
                }
                finally {
                    JOptionPane.showMessageDialog(null, "usuario registrado correctamente.");
                    setVisible(false);
                    persona = new Persona(nombre, apellidos, edad, numerofijo, numeroCelular, Fechanacimiento);
                    textNombre.setText(LIMPIAR);
                    textapellidos.setText(LIMPIAR);
                    textedad.setText(LIMPIAR);
                    textelfijo.setText(LIMPIAR);
                    textelcel.setText(LIMPIAR);
                    textFechanacimoento.setText(LIMPIAR);
                }
            }
        });
    }

    public Persona getPersona() {
        return persona;
    }
    private void setNumerofijo(String text) {
        this.numerofijo = Long.valueOf(text);
    }
    private void setNumeroCelular(String text) {
        this.numeroCelular = Long.valueOf(text);
    }
    private void setEdad(String text) {
        this.edad = Integer.valueOf(text);
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setFechanacimiento(String fechanacimiento) {
        Fechanacimiento = fechanacimiento;
    }
    public void closeeFrame(){
        this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }
    public Container getpanel(){
        formulario.getAccessibleContext();
        return formulario;
    }

}

