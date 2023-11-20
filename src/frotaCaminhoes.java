import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class frotaCaminhoes {
    public ArrayList<Caminhao> frota;

    public frotaCaminhoes(){
        this.frota = new ArrayList<>();
    }

    public void add(Caminhao c){
        if(frota.contains(c)){
            System.out.println("ja cadastrado");
            return;
        }else{
            frota.add(c);
            sort(frota);
        }




    }
    public Caminhao searchCaminhao(Integer codigo){
        for(Caminhao c : frota){
            if(c.getCodigo()==codigo){
                return c;
            }
        }
        System.out.println("Caminhao não encontrado");
        return null;
    }

    private void sort(ArrayList<Caminhao> frota) {
        frota.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
    }



}
