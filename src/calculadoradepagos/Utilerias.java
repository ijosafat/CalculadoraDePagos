/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoradepagos;

import java.util.Scanner;

/**
 *
 * @author lachi
 */
public class Utilerias {

    public static Empleado recolectarInformacionEmpleado(int num) {
        Scanner teclado = new Scanner(System.in);
        String nombre, apellido, cargo;
        Empleado emp;
        int horas;
        System.out.println("\n************************************************");
        System.out.println("Ingresar primer nombre de empleado " + num + ":");
        nombre = teclado.nextLine();
        System.out.println("Ingresar primer apellido de empleado " + num + ":");
        apellido = teclado.nextLine();
        System.out.println("Ingresar cargo de empleado " + num + ":");
        cargo = teclado.nextLine();
        System.out.println("Ingresar horas trabajadas al mes de empleado " + num + ":");
        horas = teclado.nextInt();
        System.out.println("************************************************\n");
        emp = new Empleado(nombre, apellido, cargo, horas);
        return emp;
    }

    public static boolean habraBono(String cargo1, String cargo2, String cargo3) {
        boolean hayBono = true;
        if (cargo1.equals("gerente")) {
            if (cargo2.equals("asistente")) {
                if (cargo3.equals("secretaria")) {
                    hayBono = false;
                }
            }
        }
        return hayBono;
    }

    public static Empleado empleadoMayorSalario(Empleado[] empleados) {
        Empleado emp = null;
        double salarioMayor = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getCalculadora().getSueldoLiquido() > salarioMayor) {
                emp = empleados[i];
                salarioMayor = empleados[i].getCalculadora().getSueldoLiquido();
            }
        }
        return emp;
    }

    public static Empleado empleadoMenorSalario(Empleado[] empleados) {
        Empleado emp = null;
        double salarioMenor = empleados[0].getCalculadora().getSueldoLiquido();
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getCalculadora().getSueldoLiquido() < salarioMenor) {
                emp = empleados[i];
                salarioMenor = empleados[i].getCalculadora().getSueldoLiquido();
            }
        }
        return emp;
    }

    public static void empleadosConSalarioMayorA300(Empleado[] empleados) {
        
        for (int i = 0; i < empleados.length; i++) {
            if(empleados[i].getCalculadora().getSueldoLiquido() > 300){
                System.out.println(empleados[i].getNombre() + " " + empleados[i].getApellido());
            }
        }

    }

    public static void imprimirInformacionEmpleados(Empleado[] empleados, boolean hayBono) {
        Empleado empSalarioMayor, empSalarioMenor;
        empSalarioMayor = empleadoMayorSalario(empleados);
        empSalarioMenor = empleadoMenorSalario(empleados);
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("*******************************");
            System.out.println("Informacion del empleado " + empleados[i].getNombre() + " " + empleados[i].getApellido());
            System.out.println("Salario Base: " + empleados[i].getCalculadora().getSueldoBase());
            System.out.println("ISSS: " + empleados[i].getCalculadora().getIsss());
            System.out.println("AFP: " + empleados[i].getCalculadora().getAfp());
            System.out.println("Renta: " + empleados[i].getCalculadora().getRenta());
            System.out.println("Salario Liquido: " + empleados[i].getCalculadora().getSueldoLiquido());
            if (hayBono) {
                System.out.println("Bono: " + empleados[i].getCalculadora().getBono());
            }
            System.out.println("*******************************");
        }
        if (!hayBono) {
            System.out.println("************   NO HAY BONO");
        }

        System.out.println("*******************************");
        System.out.println("El empleado con mayor salario es: " + empSalarioMayor.getNombre() + " " + empSalarioMayor.getApellido());
        System.out.println("El empleado con menor salario es: " + empSalarioMenor.getNombre() + " " + empSalarioMenor.getApellido());
        System.out.println("*******************************");
        System.out.println("Los empleados que ganan mas de 300 son: ");
        empleadosConSalarioMayorA300(empleados);

    }
}
