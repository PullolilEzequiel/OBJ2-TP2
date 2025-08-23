package empleado;

import empresa.DetallesDeRenumeracion;

import java.util.GregorianCalendar;

public class EmpleadoPermanente extends  Empleado{
    private Integer cantHijos;
    private Integer antiguedad;

    public void agregarHijo(){
        this.cantHijos += 1;
    }

    public void aumentarAntiguedad() {
        this.antiguedad += 1;
    }
    public EmpleadoPermanente(String nombre,
                              Double sueldo_basico,
                              String direccion,
                              GregorianCalendar fecha_nacimiento,
                              EstadoCivil estadoCivil,
                              Integer cant_hijos,
                              Integer antiguedad){
        super(nombre, sueldo_basico, direccion, fecha_nacimiento, estadoCivil);

        this.cantHijos = cant_hijos;
        this.antiguedad = antiguedad;

    }

    @Override
    public Double getAporteJubilatorio(DetallesDeRenumeracion detalle_renumeracion) {
        return detalle_renumeracion.getAporteJubilatorioPermanente(this.getSueldoBruto(detalle_renumeracion));
    }

    @Override
    public Double getAporteObraSocial(DetallesDeRenumeracion detalle_renumeracion) {
        return detalle_renumeracion.getAporteSocialPermanente(this.getSueldoBruto(detalle_renumeracion), this.cantHijos);
    }

    @Override
    public Double getSueldoFamiliar(DetallesDeRenumeracion detalle_renumeracion) {
        return detalle_renumeracion.getAsignacionPorHijo(this.cantHijos) + detalle_renumeracion.getAdicionalPorConyuge(this.getEstadoCivil()) + detalle_renumeracion.getAportePorAntiguedad(this.antiguedad);
    }

    @Override
    public Double getRetencionDeSueldo(DetallesDeRenumeracion detalle_renumeracion) {
        return this.getAporteObraSocial(detalle_renumeracion) + this.getAporteJubilatorio(detalle_renumeracion);
    }


}
