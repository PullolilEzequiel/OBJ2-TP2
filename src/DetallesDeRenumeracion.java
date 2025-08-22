public class DetallesDeRenumeracion {
    private  Double adicional_por_hora;
    private  Double asignacion_por_hijo;
    private  Double asignacion_por_conyuge;
    private  Double adicional_por_antiguedad;
    private  Double aporte_jubilatorio_planta_permanente;
    private  Double aporte_jubilatorio_planta_temporal;
    private  Double aporte_social_empleado_permanente;
    private  Double aporte_social_empleado_temporal;


    public DetallesDeRenumeracion(Double adicionalPorHora,
                                  Double asignacionPorHijo,
                                  Double asignacionPorConyuge,
                                  Double adicionalPorAntiguedad,
                                  Double aporteJubilatorioPlantaPermanente,
                                  Double aporteJubilatorioPlantaTemporal,
                                  Double aporteSocialEmpleadoPermanente,
                                  Double aporteSocialEmpleadoTemporal){
        adicional_por_hora = adicionalPorHora;
        asignacion_por_hijo = asignacionPorHijo;
        asignacion_por_conyuge = asignacionPorConyuge;
        adicional_por_antiguedad = adicionalPorAntiguedad;
        aporte_jubilatorio_planta_permanente = aporteJubilatorioPlantaPermanente;
        aporte_jubilatorio_planta_temporal = aporteJubilatorioPlantaTemporal;
        aporte_social_empleado_permanente = aporteSocialEmpleadoPermanente;
        aporte_social_empleado_temporal = aporteSocialEmpleadoTemporal;
    }


    public Double getAporteSocialTemporal(Double sueldo, Integer anios_de_aporte){
        return (sueldo * 0.1) + ((anios_de_aporte >= 50) ? 25 : 0);
    }

    public Double getAporteJubilatorioTemporal(Double sueldoBruto, Double horasExtra) {
        return  (sueldoBruto * 0.1) + (horasExtra * adicional_por_hora);
    }
}
