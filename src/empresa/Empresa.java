package empresa;

import empleado.Empleado;

import java.util.ArrayList;
import java.util.Objects;

public class Empresa {
    private String nombre;
    private String CUIT;
    private ArrayList<Empleado> empleados;
    private DetallesDeRenumeracion detalle_renumeracion;

    private ArrayList<ReciboDeHaberes> recibos_de_haberes = new ArrayList<>();
    public Empresa(String nombre, String CUIT, DetallesDeRenumeracion detalle_renumeracion){
        this.nombre = nombre;
        this.CUIT = CUIT;
        this.detalle_renumeracion = detalle_renumeracion;
        this.empleados = new ArrayList<Empleado>();
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
            montoTotal += empleado.getSueldoBruto(detalle_renumeracion);
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

    public void liquidarSueldos(){
        for(Empleado empleado: this.empleados){
            Double sueldo_neto = empleado.getSueldoNeto(detalle_renumeracion);
            Double sueld_bruto = empleado.getSueldoBruto(detalle_renumeracion);
            ReciboDeHaberes recibo_tmp = new ReciboDeHaberes(empleado.getNombre(), empleado.getDireccion(), sueld_bruto, sueldo_neto);
            this.recibos_de_haberes.add(recibo_tmp);
        }
    }

    public boolean liquidoSueldoDe(Empleado empleado){

        for(ReciboDeHaberes recibo: this.recibos_de_haberes){
            if (Objects.equals(recibo.getNombre(), empleado.getNombre())){
                return true;
            }
        }

        return  false;
    }
}
