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

    public Cliente serchCliente(Integer cod){
        for(Cliente c : clientes){
            if(c.getCod()==cod){
                return c;
            }
        }
        System.out.println("Cliente não encontrado");
        return  null;
    }
    private void sort(ArrayList<Cliente> Clientes) {
        Clientes.sort((o1, o2) -> o1.getCod().compareTo(o2.getCod()));
    }

}
