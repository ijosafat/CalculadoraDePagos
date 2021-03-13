package calculadoradepagos;

import static calculadoradepagos.Utilerias.imprimirInformacionEmpleados;
import static calculadoradepagos.Utilerias.recolectarInformacionEmpleado;
import java.util.Scanner;

/**
 *
 * @author Myke
 */
public class CalculadoraDePagos {

    public static void main(String[] args) {
        Empleado emp1, emp2, emp3;
        Empleado[] arrEmpleados = new Empleado[3];
        boolean sePagaBono;

        System.out.println("Bienvenido a la calculadora de planillas");
        System.out.println("Por favor siga las instrucciones correspondientes");
        try {
            emp1 = recolectarInformacionEmpleado(1);
            emp2 = recolectarInformacionEmpleado(2);
            emp3 = recolectarInformacionEmpleado(3);
            sePagaBono = Utilerias.habraBono(emp1.getCargo(), emp2.getCargo(), emp3.getCargo());
            if(!sePagaBono){
                emp1.getCalculadora().setBono(0);
                emp2.getCalculadora().setBono(0);
                emp3.getCalculadora().setBono(0);
            }
            arrEmpleados[0] = emp1;
            arrEmpleados[1] = emp2;
            arrEmpleados[2] = emp3;
            imprimirInformacionEmpleados(arrEmpleados, sePagaBono);
        } catch (Exception ex) {
            System.out.println("Ingrese los datos de manera correcta y pruebe nuevamente");
        }
    }
}
