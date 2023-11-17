package src;
public class Destino {
    private int cod;
    private String nomeCidade;

    public Destino(int cod, String nomeCidade) {
        this.cod = cod;
        this.nomeCidade = nomeCidade;
    }

    public int getCod() {
        return cod;
    }
    public String getNomeCidade() {
        return nomeCidade;
    }
}
