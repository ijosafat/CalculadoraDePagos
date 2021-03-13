package calculadoradepagos;

public class CalculadoraSueldos {

    double porcentajeISSS, porcentajeAFP, porcentajeRenta;
    double isss, afp, renta;
    double horaBase, horaAumentada;
    double sueldoBase, sueldoLiquido, bono;
    String cargo;

    public CalculadoraSueldos(int cantidadDeHorasTrabajadas, String cargo) {
        this.cargo = cargo.toLowerCase();
        this.inicializarMontos();
        this.calcularSueldoBase(cantidadDeHorasTrabajadas);
        this.calcularDescuentos();
        this.calcularSueldoLiquido();
        this.calcularBonos();
    }

    /* metodos publicos */
    private void inicializarMontos() {
        this.porcentajeISSS = 0.0525;
        this.porcentajeAFP = 0.0688;
        this.porcentajeRenta = 0.10;
        this.horaBase = 9.75;
        this.horaAumentada = 11.50;
        this.isss = 0;
        this.afp = 0;
        this.renta = 0;
        this.sueldoBase = 0;
        this.sueldoLiquido = 0;
        this.bono = 0;
    }

    private void calcularSueldoBase(int cantidadHoras) {
        double sueldoAPagar = 0;
        int horasRestantes = 0;
        if (cantidadHoras <= 160) {
            sueldoAPagar = cantidadHoras * this.horaBase;
        } else {
            horasRestantes = cantidadHoras - 160;
            sueldoAPagar = cantidadHoras * this.horaBase;
            sueldoAPagar += horasRestantes * this.horaAumentada;
        }
        this.sueldoBase = sueldoAPagar;
    }

    private void calcularDescuentos() {
        this.isss = this.sueldoBase * this.porcentajeISSS;
        this.afp = this.sueldoBase * this.porcentajeAFP;
        this.renta = this.sueldoBase * this.porcentajeRenta;
    }

    private void calcularSueldoLiquido() {
        double descuentos = this.isss + this.afp + this.renta;
        this.sueldoLiquido = this.sueldoBase - descuentos;
    }

    private void calcularBonos() {
        switch (this.cargo) {
            //si es gerente
            case "gerente":
                this.bono =( this.sueldoLiquido * 1.10) - this.sueldoLiquido;
                break;
            //si es asistente
            case "asistente":
                this.bono =( this.sueldoLiquido * 1.05) - this.sueldoLiquido;
                break;
            //si es secretaria
            case "secretaria":
               this.bono =( this.sueldoLiquido * 1.03) - this.sueldoLiquido;
            //cualquier otro caso
            default:
                this.bono =( this.sueldoLiquido * 1.02) - this.sueldoLiquido;
        }
    }

    /* metodos publicos */
    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getSueldoLiquido() {
        return sueldoLiquido;
    }

    public double getBono() {
        return bono;
    }

    public double getIsss() {
        return isss;
    }

    public double getAfp() {
        return afp;
    }

    public double getRenta() {
        return renta;
    }

    public void setBono(double nuevoBono) {
        this.bono = nuevoBono;
    }

}
