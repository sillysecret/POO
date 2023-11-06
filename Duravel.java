public class Duravel extends Carga {
    private String setor;
    private String materialPrincipal; 
    private int numero;
    private String descricao;

    public Duravel(int codigo, int peso, double valorDeclarado, int tempoMaximo, String setor, String materialPrincipal, int numero, String descricao) {
        super(codigo, peso, valorDeclarado, tempoMaximo);
        this.setor = setor;
        this.materialPrincipal = materialPrincipal;
        this.numero = numero;
        this.descricao = descricao;
    }

    public void calculaPeso(int peso) {
        this.peso = (int)(peso * 1.5);
    }

    public String getSetor() {
        return setor;
    }
    public String getMaterialPrincipal() {
        return materialPrincipal;
    }
    public int getNumero() {
        return numero;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    public void setMaterialPrincipal(String materialPrincipal) {
        this.materialPrincipal = materialPrincipal;
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
        + "\nSetor: " + setor
        + "\nMaterial principal: " + materialPrincipal
        + "\nNumero: " + numero
        + "\nDescrição : " + descricao;
    }
}
