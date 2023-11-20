import java.util.ArrayList;

public class DestinosCad {
    public ArrayList<Destino> destinos;

    public DestinosCad(){
        this.destinos = new ArrayList<>();
    }

    public void add(Destino d){
        if(destinos.contains(d)){
            System.out.println("ja cadastrado");
            return;
        }else{
            destinos.add(d);
            sort(destinos);
        }
    }

    public Destino serchDestino(Integer cod){
        for(Destino d : destinos){
            if(d.getCod()==cod){

                return d;
            }
        }
        System.out.println("Destino não encontrado");
        return null;
    }
    private void sort(ArrayList<Destino> Destinos) {
        Destinos.sort((o1, o2) -> o1.getCod().compareTo(o2.getCod()));
    }


}
