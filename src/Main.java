import java.util.GregorianCalendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empleado test = new EmpleadoTemporal("Ezequiel", 100f, "Av. Mitre", new GregorianCalendar(2002, 3, 5));
        System.out.println(test.getEdad());

        System.out.println(test.getSueldoBruto());
    }
}