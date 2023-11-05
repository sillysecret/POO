public class Perecivel extends Carga {
    private String origem;
    private String validade;
    private int numero;
    private String descricao;

    public Perecivel(int codigo, int peso, double valorDeclarado, int tempoMaximo, String origem, String validade, int numero,String descricao) {
        super(codigo, peso, valorDeclarado, tempoMaximo);
        this.origem = origem;
        this.validade = validade;
        this.numero = numero;
        this.descricao = descricao;
    }

    public void calculaPeso(int peso) {
        this.peso = peso * 2;
    }

    public String getOrigem() {
        return origem;
    }
    public String getValidade() {
        return validade;
    }
    public int getNumero() {
        return numero;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nInformações da carga:" 
        + "\nCódigo: " + codigo
        + "\nPeso: " + peso 
        + "\nValor declarado: " + valorDeclarado
        + "\nTempo Maximo: " + tempoMaximo
        + "\nOrigem: " + origem
        + "\nValidade: " + validade
        + "\nNumero: " + numero
        + "\nDescrição : " + descricao;
    }
    
}
