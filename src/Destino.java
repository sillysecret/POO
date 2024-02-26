
public class Destino {
    private Integer cod;
    private String nomeCidade;

    public Destino(int cod, String nomeCidade) {
        this.cod = cod;
        this.nomeCidade = nomeCidade;
    }

    public Integer getCod() {
        return cod;
    }
    public String getNomeCidade() {
        return nomeCidade;
    }

    public String toString() {
        return "\nInformações do destino: "
        + "\nCod: " + cod
        + "\nNome da cidade: " + nomeCidade;
    }
    public String toCSV() {
        return this.cod+";"+this.nomeCidade;
    }
}
