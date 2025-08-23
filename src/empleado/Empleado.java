package empleado;

import empresa.DetallesDeRenumeracion;

import java.util.Calendar;
import java.util.GregorianCalendar;
public abstract class Empleado {
    private String nombre, direccion;
    private GregorianCalendar fecha_nacimiento;
    private Double sueldo_basico;
    private EstadoCivil estado_civil;

    public void cambiarEstadoCivil(EstadoCivil estado_civil){
        this.estado_civil = estado_civil;
    }
    public Empleado(String nombre, Double sueldo_basico, String direccion, GregorianCalendar fecha_nacimiento, EstadoCivil estado_civil){
        this.direccion = direccion;
        this.nombre = nombre;
        this.sueldo_basico = sueldo_basico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado_civil = estado_civil;
    }

    public EstadoCivil getEstadoCivil(){
        return  this.estado_civil;
    }

    public Double getSueldoBruto(DetallesDeRenumeracion detalle_renumeracion) {
        return this.sueldo_basico + this.getSueldoFamiliar(detalle_renumeracion);
    }

    public int getEdad() {
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - this.fecha_nacimiento.get(Calendar.YEAR);
        if (hoy.get(Calendar.DAY_OF_YEAR) < this.fecha_nacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad;
    }

    public abstract Double getAporteJubilatorio(DetallesDeRenumeracion detalle_renumeracion);
    public abstract Double getAporteObraSocial(DetallesDeRenumeracion detalle_renumeracion);
    public abstract Double getSueldoFamiliar(DetallesDeRenumeracion detalle_renumeracion);
    public abstract Double getRetencionDeSueldo(DetallesDeRenumeracion detalle_renumeracion);

    public Double getSueldoNeto(DetallesDeRenumeracion detalle_renumeracion){
        return  this.getSueldoBruto(detalle_renumeracion) - this.getRetencionDeSueldo(detalle_renumeracion);
    }


}
