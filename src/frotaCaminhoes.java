import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class frotaCaminhoes {
    private ArrayList<Caminhao> frota;

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
    private void sort(ArrayList<Caminhao> frota) {
        frota.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
    }



}
