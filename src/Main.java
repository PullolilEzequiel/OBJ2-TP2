import empleado.*;
import empresa.DetallesDeRenumeracion;
import empresa.Empresa;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.platform.commons.JUnitException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final DetallesDeRenumeracion renumeracionEnunciado = new DetallesDeRenumeracion(
            40.0,
            150.0,
            100.0,
            50.0,
            0.15,
            0.10,
            0.10,
            0.10,
            20.0,
            5.0,
            50.0
    );

    private static final Empresa empresa_enunciado= new Empresa("Empresa enunciado", "20441113339", renumeracionEnunciado);
    private static final EstadoCivil soltero = new EstadoCivil("soltero");
    private static final EmpleadoContratado empleadoContratado = new EmpleadoContratado(
            "domingo",
            1000.0,
            "casa 3",
            new GregorianCalendar(),
            soltero
    );
    private static final EmpleadoPermanente empleadoPermanente = new EmpleadoPermanente(
            "Ezequiel",
            1000.0,
            "casa2",
            new GregorianCalendar(),
            soltero,
            0,
            0);
    private static final EmpleadoTemporal empleadoTemporal = new EmpleadoTemporal(
            "Juan",
            1000.0,
            "casa falsa2",
            new GregorianCalendar(),
            soltero,
            2.0,
            new GregorianCalendar(),
            2
    );



    public static void main(String[] args) {
        Double empleadoContratadoSueldoNeto = empleadoContratado.getSueldoNeto(renumeracionEnunciado);
        Double empleadoContratadoSueldoBruto = empleadoContratado.getSueldoBruto(renumeracionEnunciado);
        Double empleadoTemporalSueldoNeto = empleadoTemporal.getSueldoNeto(renumeracionEnunciado);
        Double empleadoTemporaSueldoBruto = empleadoTemporal.getSueldoBruto(renumeracionEnunciado);

        Double empleadoPermanenteSueldoNeto = empleadoPermanente.getSueldoNeto(renumeracionEnunciado);
        Double empleadoPermanenteSueldoBruto = empleadoPermanente.getSueldoBruto(renumeracionEnunciado);

        Assertions.assertEquals(0, empresa_enunciado.montoTotalEnSueldosBrutos());
        Assertions.assertEquals(0, empresa_enunciado.montoTotalEnConceptoDeSueldos());
        Assertions.assertEquals(0, empresa_enunciado.montoTotalEnRetenciones());



        empresa_enunciado.agregarEmpleado(empleadoPermanente);
        empresa_enunciado.agregarEmpleado(empleadoTemporal);
        empresa_enunciado.agregarEmpleado(empleadoContratado);
        Assertions.assertEquals(empleadoPermanenteSueldoBruto + empleadoTemporaSueldoBruto + empleadoContratadoSueldoBruto,empresa_enunciado.montoTotalEnSueldosBrutos());
        Assertions.assertEquals(empleadoPermanenteSueldoNeto + empleadoTemporalSueldoNeto + empleadoContratadoSueldoNeto,empresa_enunciado.montoTotalEnConceptoDeSueldos());

        empresa_enunciado.liquidarSueldos();

        Assertions.assertTrue(empresa_enunciado.liquidoSueldoDe(empleadoTemporal));
        Assertions.assertTrue(empresa_enunciado.liquidoSueldoDe(empleadoTemporal));
        Assertions.assertTrue(empresa_enunciado.liquidoSueldoDe(empleadoContratado));
    }


}