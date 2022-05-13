package uia.dapp1.agenda;

public class Persona {
    private String nombre;
    private String apellidos;
    private Integer edad;
    private Long numerofijo;
    private Long numeroCelular;
    private String Fechanacimiento;

    public Persona(String nombre, String apellidos, Integer edad, Long numerofijo, Long numeroCelular, String fechanacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.numerofijo = numerofijo;
        this.numeroCelular = numeroCelular;
        Fechanacimiento = fechanacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public Integer getEdad() {
        return edad;
    }
    public Long getNumerofijo() {
        return numerofijo;
    }
    public Long getNumeroCelular() {
        return numeroCelular;
    }
    public String getFechanacimiento() {
        return Fechanacimiento;
    }

}
