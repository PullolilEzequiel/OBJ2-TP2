package empresa;

import empleado.Empleado;

import java.util.GregorianCalendar;

public class ReciboDeHaberes {
    private  String nombre_empleado;
    private String direccion;
    private GregorianCalendar fecha_emision;
    private Double sueldo_bruto;
    private Double sueldo_neto;


    public  ReciboDeHaberes(String nombre_empleado, String direccion, Double sueldo_bruto, Double sueldo_neto){
        this.nombre_empleado = nombre_empleado;
        this.direccion = direccion;
        this.sueldo_bruto = sueldo_bruto;
        this.sueldo_neto = sueldo_neto;
        this.fecha_emision = new GregorianCalendar();
    }

    public String getNombre() {
        return this.nombre_empleado;
    }
}
