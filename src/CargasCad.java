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
        for (Carga c1: cargas) {
            if (c1.getCodigo()==c.getCodigo()) {
                System.out.println("ja cadastrado");
                throw new IllegalArgumentException("Carga já cadastrada");
            }
        }
            if(c.getSituacao()!=Situacoes.Finalizada){
                q.offer(c);
            }
            cargas.add(c);
            sort(cargas);


    }
    public String toStringarray(){
       return cargas.toString();
    }
    public String tosString(){
        return cargas.toString();
    }
    public void cargasTable(){
        cargas.forEach(c -> System.out.println(c.toString()));
    }

    public Carga searchCarga(Integer codigo){
        for(Carga c : cargas){
            if(c.getCodigo()==codigo){
                return c;
            }
        }
        System.out.println("Carga não encontrada");
        return null;
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

    public ArrayList<Carga> getCargas(){
        return cargas;
    }

    public String[] getCargasString(){
        String[] cargasString = new String[cargas.size()];
        for(int i = 0; i < cargas.size(); i++){
            cargasString[i] = cargas.get(i).toString();
        }
        return cargasString;
    }
    private void sort(ArrayList<Carga> cargas) {
        cargas.sort((o1, o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
    }



}
