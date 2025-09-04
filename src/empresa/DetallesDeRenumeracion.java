package empresa;

import empleado.EmpleadoPermanente;
import empleado.EmpleadoTemporal;
import empleado.EstadoCivil;

public class DetallesDeRenumeracion {
    private  Double adicional_por_hora;
    private  Double asignacion_por_hijo;
    private  Double asignacion_por_conyuge;
    private  Double adicional_por_antiguedad;
    private  Double aporte_jubilatorio_planta_permanente;
    private  Double aporte_jubilatorio_planta_temporal;
    private  Double aporte_social_empleado_permanente;
    private  Double aporte_social_empleado_temporal;
    private  Double aporte_social_por_hijo;
    private  Double jubilacionAdicionalPorHora;


    public DetallesDeRenumeracion(Double adicionalPorHora,
                                  Double asignacionPorHijo,
                                  Double asignacionPorConyuge,
                                  Double adicionalPorAntiguedad,
                                  Double aporteJubilatorioPlantaPermanente,
                                  Double aporteJubilatorioPlantaTemporal,
                                  Double aporteSocialEmpleadoPermanente,
                                  Double aporteSocialEmpleadoTemporal,
                                  Double aporte_social_por_hijo,
                                  Double jubilacion_adicional_por_hora){
        this.adicional_por_hora = adicionalPorHora;
        this.asignacion_por_hijo = asignacionPorHijo;
        this.asignacion_por_conyuge = asignacionPorConyuge;
        this.adicional_por_antiguedad = adicionalPorAntiguedad;
        this.aporte_jubilatorio_planta_permanente = aporteJubilatorioPlantaPermanente;
        this.aporte_jubilatorio_planta_temporal = aporteJubilatorioPlantaTemporal;
        this.aporte_social_empleado_permanente = aporteSocialEmpleadoPermanente;
        this.aporte_social_empleado_temporal = aporteSocialEmpleadoTemporal;
        this.aporte_social_por_hijo = aporte_social_por_hijo;
        this.jubilacionAdicionalPorHora = jubilacion_adicional_por_hora;
    }



    public Double asignacionPorhijo(EmpleadoPermanente empleadoPermanente){
        if(empleadoPermanente.getEstadoCivil().estaCasado()){
            return this.asignacion_por_conyuge;
        }

        return (double) 0;
    }

    public Double getAdicionalPorHora(EmpleadoTemporal empleadoTemporal){
        return  (empleadoTemporal.getHorasExtra() * adicional_por_hora);
    }

    public  Double getAportePorAntiguedad(EmpleadoPermanente empleadoPermanente){
        return  empleadoPermanente.getAntiguedad() * adicional_por_antiguedad;
    }


    public Double getAporteJubilatorio(EmpleadoTemporal empleadoTemporal) {
        return (empleadoTemporal.getSueldoBruto(this) * aporte_jubilatorio_planta_temporal) + (empleadoTemporal.getHorasExtra() * jubilacionAdicionalPorHora);
    }
    public Double getAporteSocial(EmpleadoTemporal empleadoTemporal) {
        return (empleadoTemporal.getSueldoBruto(this) * aporte_social_empleado_temporal) + ((empleadoTemporal.getAniosAporte() >= 50) ? adicional_por_antiguedad : 0);
    }


    public Double getAporteJubilatorio(EmpleadoPermanente empleadoPermanente) {
        return empleadoPermanente.getSueldoBruto(this) * aporte_jubilatorio_planta_permanente;
    }

    public Double getSueldoFamiliar(EmpleadoPermanente empleadoPermanente) {
        return this.asignacionPorhijo(empleadoPermanente)
                + this.asignacionPorConyuge(empleadoPermanente)
                + this.getAportePorAntiguedad(empleadoPermanente);
    }

    private Double asignacionPorConyuge(EmpleadoPermanente empleadoPermanente) {
        return empleadoPermanente.getCantidadHijos() * aporte_social_por_hijo;
    }

    public Double getAporteSocial(EmpleadoPermanente empleadoPermanente) {
        return  (empleadoPermanente.getSueldoBruto(this) * aporte_social_empleado_permanente)
                + empleadoPermanente.getCantidadHijos() * aporte_social_por_hijo;
    }
}
