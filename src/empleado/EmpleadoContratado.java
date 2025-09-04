package empleado;

import empresa.DetallesDeRenumeracion;

import java.util.GregorianCalendar;

public class EmpleadoContratado extends Empleado{

    public  EmpleadoContratado(String nombre, Double sueldo_basico, String direccion, GregorianCalendar fecha_nacimiento, EstadoCivil estado_civil){
        super(nombre, sueldo_basico,direccion, fecha_nacimiento, estado_civil);
    }
    @Override
    public Double getAporteJubilatorio(DetallesDeRenumeracion detalle_renumeracion) {
        return 0.0;
    }

    @Override
    public Double getAporteObraSocial(DetallesDeRenumeracion detalle_renumeracion) {
        return 0.0;
    }

    @Override
    public Double getSueldoFamiliar(DetallesDeRenumeracion detalle_renumeracion) {
        return 0.0;
    }

    @Override
    public Double getRetencionDeSueldo(DetallesDeRenumeracion detalle_renumeracion) {
        return detalle_renumeracion.getGastosAdministrativos();
    }
}
