import java.util.ArrayList;

public class ClienteCad {
    public ArrayList<Cliente> clientes;

    public ClienteCad(){
        this.clientes = new ArrayList<>();
    }

    public void add(Cliente c){
        for (Cliente cliente : clientes) {
            if(cliente.getCod()==c.getCod()){

                throw new IllegalArgumentException("Cliente já cadastrado");

            }
        }

            clientes.add(c);
            sort(clientes);

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

    public String[] getClientesString(){
        String[] clientesString = new String[clientes.size()];
        for(int i = 0; i < clientes.size(); i++){
            clientesString[i] = clientes.get(i).toString();
        }
        return clientesString;
    }
}
