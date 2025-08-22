import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private String CUIT;
    private ArrayList<Empleado> empleados;
    private DetallesDeRenumeracion detalle_renumeracion;
    public Empresa(String nombre, String CUIT, DetallesDeRenumeracion detalle_renumeracion){
        this.nombre = nombre;
        this.CUIT = CUIT;
        this.detalle_renumeracion = detalle_renumeracion;
    }


    public void agregarEmpleado(Empleado e) throws RuntimeException {
        if (!this.empleados.add(e))
            throw new RuntimeException("El empleado ya esta dentro de la empresa");

    }

    public void bulkEmpleados(ArrayList<Empleado> empleados) throws RuntimeException{
        empleados.forEach(this::agregarEmpleado);
    }


    public Double montoTotalEnConceptoDeSueldos(){
        Double montoTotal = (double) 0;

        for (Empleado empleado : this.empleados) {
            montoTotal += empleado.getSueldoNeto(detalle_renumeracion);
        }

        return  montoTotal;
    }

    public Double montoTotalEnSueldosBrutos(){
        Double montoTotal = (double) 0;

        for (Empleado empleado : this.empleados) {
            montoTotal += empleado.getSueldoBruto();
        }

        return  montoTotal;
    }

    public Double montoTotalEnRetenciones(){
        Double montoTotal = (double) 0;

        for (Empleado empleado : this.empleados) {
            montoTotal += empleado.getRetencionDeSueldo(detalle_renumeracion);
        }

        return  montoTotal;
    }
}
