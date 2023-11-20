
public class Cliente {
    private Integer cod;
    private String nome;
    private String telefone;

    public Cliente(int cod, String nome, String telefone) {
        this.cod = cod;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getCod() {
        return cod;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "\nInformações do cliente: " 
        + "\nCod: " + cod
        + "\nNome: " + nome
        + "\nTelefone: " + telefone;
    }

    public String toCSV() {
        return this.cod+";"+this.nome+";"+this.telefone;
    }
    
    
}
