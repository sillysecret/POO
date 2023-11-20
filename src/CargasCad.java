import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Comparator;

public class CargasCad {

    public ArrayList<Carga> cargas;
    Queue<Carga> q;

    public CargasCad(){
        this.q = new LinkedList<Carga>();
        this.cargas = new ArrayList<>(100);
    }

    public void add(Carga c){
        if(cargas.contains(c)){
            System.out.println("ja cadastrado");
            return;
        }else{
            if(c.getSituacao()!=Situacoes.Finalizada){
                q.offer(c);
            }
            cargas.add(c);
            sort(cargas);
            return;
        }
    }

    public void cargasTable(){
        cargas.forEach(c -> System.out.println(c.toString()));
    }

    public void changeCargaSit(int codigo,Situacoes st){
       for(Carga c : cargas){
           if(c.getCodigo()==codigo){
               if(c.getSituacao()==Situacoes.Finalizada){
                   System.out.println("Carga finalizada");
                   break;
               }else{
                   c.setSituacao(st);
                   System.out.println("Situacao alterada");
                   break;
               }

           }
       }
        System.out.println("Carga não encontrada");
    }

    private void sort(ArrayList<Carga> cargas) {
        cargas.sort((o1, o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
    }



}
