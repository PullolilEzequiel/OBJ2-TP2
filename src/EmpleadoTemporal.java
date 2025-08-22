import java.util.GregorianCalendar;

public class EmpleadoTemporal extends Empleado {

    private Integer anios_aporte;
    private GregorianCalendar fecha_designacion;
    private Double horas_extra;

    public EmpleadoTemporal(String nombre,
                            Double sueldo_basico,
                            String direccion,
                            GregorianCalendar fecha_nacimiento,
                            Double horas_extra,
                            GregorianCalendar fecha_designacion,
                            Integer anios_aporte){
        super(nombre, sueldo_basico, direccion, fecha_nacimiento);

        this.horas_extra = horas_extra;
        this.fecha_designacion = fecha_designacion;
        this.anios_aporte = anios_aporte;
    }

    @Override
    public Double getAporteJubilatorio(DetallesDeRenumeracion detalle_renumeracion) {
        return detalle_renumeracion.getAporteJubilatorioTemporal(this.getSueldoBruto(), this.horas_extra);
    }

    @Override
    public Double getAporteObraSocial(DetallesDeRenumeracion detalle_renumeracion) {
        return detalle_renumeracion.getAporteSocialTemporal(this.getSueldoBruto(), this.anios_aporte);
    }

    @Override
    public Double getSueldoFamiliar(DetallesDeRenumeracion detalle_renumeracion) {return 0.0;}

    @Override
    public Double getRetencionDeSueldo(DetallesDeRenumeracion detalle_renumeracion) {
        return this.getAporteJubilatorio(detalle_renumeracion) + this.getAporteObraSocial(detalle_renumeracion) + this.getSueldoFamiliar(detalle_renumeracion);
    }
}
