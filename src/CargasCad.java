import java.util.ArrayList;

public class CargasCad {

    private ArrayList<Carga> cargas;

    public  CargasCad(){
        this.cargas = new ArrayList<>();
    }

    public void add(Carga c){
        if(cargas.contains(c)){
            System.out.println("ja cadastrado");
            return;
        }else{
            cargas.add(c);
            sort(cargas);
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
