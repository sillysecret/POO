import java.util.ArrayList;

public class ClienteCad {
    public ArrayList<Cliente> clientes;

    public ClienteCad(){
        this.clientes = new ArrayList<>();
    }

    public void add(Cliente c){
        if(clientes.contains(c)){
            System.out.println("ja cadastrado");
            return;
        }else{
            clientes.add(c);
            sort(clientes);
        }
    }
    private void sort(ArrayList<Cliente> Clientes) {
        Clientes.sort((o1, o2) -> o1.getCod().compareTo(o2.getCod()));
    }

}
