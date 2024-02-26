import java.util.ArrayList;

public class DestinosCad {
    public ArrayList<Destino> destinos;

    public DestinosCad(){
        this.destinos = new ArrayList<>();
    }

    public void add(Destino d){
        for (Destino destino : destinos) {
            if (destino.getCod() == d.getCod()) {
                throw new IllegalArgumentException("Carga já cadastrada");

            }
        }

        destinos.add(d);
        sort(destinos);

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

    public String[] getDestinosString(){
        String[] destinosString = new String[destinos.size()];
        for(int i = 0; i < destinos.size(); i++){
            destinosString[i] = destinos.get(i).toString();
        }
        return destinosString;
    }

}
