package empleado;

public class EstadoCivil {
    private String description;

    public  EstadoCivil(String Description){
        description = Description;
    }

    public boolean estaCasado(){
        return  description.equals("casado");
    }
}
