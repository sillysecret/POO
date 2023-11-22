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
            throw new IllegalArgumentException("Carga já cadastrada");
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

    public String[] getFrotaString(){
        String[] frotaString = new String[frota.size()];
        for(int i = 0; i < frota.size(); i++){
            frotaString[i] = frota.get(i).toString();
        }
        return frotaString;
    }

}
