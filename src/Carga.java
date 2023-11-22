
public class Carga{
    private Integer codigo;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximoFrete;
    private TipoCarga carga;
    private Cliente cliente; 
    private Situacoes situacao;
    private Destino destino;

    private Destino origem;

    public Carga(int codigo, int peso, double valorDeclarado, int tempoMaximoFrete, TipoCarga carga, Cliente cliente, Situacoes situacao,Destino destino,Destino origem) {
        this.codigo = codigo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximoFrete = tempoMaximoFrete;
        this.carga = carga;
        this.cliente = cliente;
        this.situacao = situacao;
        this.destino = destino;
        this.origem=origem;
    }

    public Integer getCodigo() {
        return this.codigo;
    }
    public int getPeso() {
        return peso;
    }
    public double getValorDeclarado() {
        return valorDeclarado;
    }
    public int getTempoMaximo() {
        return tempoMaximoFrete;
    }

    public Destino getDestino(){
        return this.destino;
    }
    public Destino getOrigem(){
        return this.origem;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }
    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximoFrete = tempoMaximo;
    }

    public TipoCarga getTipoCarga() {
       return this.carga;
    }

    public Situacoes getSituacao(){
        return this.situacao;
    }

    public void setSituacao(Situacoes situacao) {
        this.situacao = situacao;
    }

    public String toString() {
        return "\nInformações da carga:" 
        + "\nCódigo: " + codigo
        + "\nPeso: " + peso 
        + "\nValor declarado: " + valorDeclarado
        + "\nTempo Maximo: " + tempoMaximoFrete
        + "\nTipo da Carga: " + carga.toString();

    }

    public String toCSV() {
        return this.codigo+";"+ this.peso+";"+ this.valorDeclarado+";"+ this.tempoMaximoFrete+";"+ this.carga.toCSV()+";"+ this.cliente.toCSV()+";"+ this.situacao+";"+ this.destino.toCSV()+";"+ this.origem.toCSV();
    }

}
