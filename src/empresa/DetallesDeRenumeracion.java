package empresa;

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


    public Double getAporteSocialTemporal(Double sueldo, Integer anios_de_aporte){
        return (sueldo * aporte_social_empleado_temporal) + ((anios_de_aporte >= 50) ? adicional_por_antiguedad : 0);
    }

    public Double getAporteSocialPermanente(Double sueldoBruto, Integer cantHijos) {
        return (sueldoBruto * this.aporte_social_empleado_permanente) + (cantHijos * aporte_social_por_hijo);
    }

    public Double getAporteJubilatorioTemporal(Double sueldoBruto, Double horasExtra) {
        return  (sueldoBruto * aporte_jubilatorio_planta_temporal) + (horasExtra * jubilacionAdicionalPorHora);
    }

    public Double getAsignacionPorHijo(Integer cant_hijos) {
        return (cant_hijos * asignacion_por_hijo);
    }

    public Double getAdicionalPorConyuge(EstadoCivil estado_civil){
        if(estado_civil.estaCasado()){
            return this.asignacion_por_conyuge;
        }

        return (double) 0;
    }

    public Double getAdicionalPorHora(Double horas_extra){
        return  (horas_extra * adicional_por_hora);
    }
    public Double getAporteJubilatorioPermanente(Double sueldoBruto) {
        return  (sueldoBruto * this.aporte_jubilatorio_planta_permanente);
    }


    public  Double getAportePorAntiguedad(Integer antiguedad){
        return  antiguedad * adicional_por_antiguedad;
    }
}
