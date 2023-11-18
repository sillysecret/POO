import java.util.ArrayList;

public class DestinosCad {
    private ArrayList<Destino> destinos;

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
    private void sort(ArrayList<Destino> Destinos) {
        Destinos.sort((o1, o2) -> o1.getCod().compareTo(o2.getCod()));
    }


}
