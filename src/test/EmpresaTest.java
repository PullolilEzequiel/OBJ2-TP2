package test;

import empleado.EmpleadoPermanente;
import empleado.EstadoCivil;
import empresa.DetallesDeRenumeracion;
import empresa.Empresa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpresaTest {
    private static final Double ADICIONAL_POR_HORA = 40.0;
    private static final Double ASIGNACION_POR_HIJO = 150.0;
    private static final Double ASIGNACION_POR_CONYUGE = 100.0;
    private static final Double ADICIONAL_POR_ANTIGUEDAD = 50.0;
    private static final Double APORTE_JUBILATORIO_PLANTA_PERMANENTE = 0.15;
    private static final Double APORTE_JUBILATORIO_PLANTA_TEMPORAL = 0.10;
    private static final Double APORTE_SOCIAL_EMPLEADO_PERMANENTE = 0.10;
    private static final Double APORTE_SOCIAL_EMPLEADO_TEMPORAL = 0.10;
    private static final Double APORTE_SOCIAL_POR_HIJO = 20.0;
    private static final Double JUBILACION_ADICIONAL_POR_HORA = 5.0;
    private static final DetallesDeRenumeracion renumeracionEnunciado = new DetallesDeRenumeracion(
            ADICIONAL_POR_HORA,
            ASIGNACION_POR_HIJO,
            ASIGNACION_POR_CONYUGE,
            ADICIONAL_POR_ANTIGUEDAD,
            APORTE_JUBILATORIO_PLANTA_PERMANENTE,
            APORTE_JUBILATORIO_PLANTA_TEMPORAL,
            APORTE_SOCIAL_EMPLEADO_PERMANENTE,
            APORTE_SOCIAL_EMPLEADO_TEMPORAL,
            APORTE_SOCIAL_POR_HIJO,
            JUBILACION_ADICIONAL_POR_HORA
    );
    static EstadoCivil casado = new EstadoCivil("casado");
    static EstadoCivil soltero = new EstadoCivil("soltero");
    static Empresa empresa;
    private static List<Double> sueldos_basicos = List.of(1000.0, 2000.0, 5000.0, 6000.0, 7000.0);
    @BeforeEach
    void setup(){
        empresa = new Empresa("AAAA sa", "20204440008", renumeracionEnunciado);

    }

    @Test
    void EmpleadosPermanenteSolterosSinAntiguedadNiHijos(){
        for (Double sueldo : sueldos_basicos){
            empresa.agregarEmpleado(new EmpleadoPermanente(
                    "a",
                    sueldo,
                    "b",
                    new GregorianCalendar(1990, Calendar.MARCH, 5),
                    soltero,
                    0,
                    0));
        }



        assertEquals(sueldos_basicos.stream().mapToDouble(Double::doubleValue).sum(), empresa.montoTotalEnSueldosBrutos());
        assertEquals(15750, empresa.montoTotalEnConceptoDeSueldos());
    }

    @Test
    void EmpleadosPermanenteSolterosSinAntiguedadConHijos(){
        for (Double sueldo : sueldos_basicos){
            empresa.agregarEmpleado(new EmpleadoPermanente(
                    "a",
                    sueldo,
                    "b",
                    new GregorianCalendar(1990, Calendar.MARCH, 5),
                    soltero,
                    2,
                    0));
        }

        assertEquals(16675.0, empresa.montoTotalEnConceptoDeSueldos());
    }

}
