package calculadoradepagos;

public class Empleado {

    String nombre, apellido, cargo;
    int horasTrabajadas;
    CalculadoraSueldos calculadora;

    public Empleado(String nombre, String apellido, String cargo, int horas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.horasTrabajadas = horas;
        this.calculadora = new CalculadoraSueldos(horas, cargo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
    
    public CalculadoraSueldos getCalculadora(){
        return this.calculadora;
    }

    public void setHorasTrabajadas(int nuevasHorasTrabajadas) {
        this.horasTrabajadas = nuevasHorasTrabajadas;
    }
}
