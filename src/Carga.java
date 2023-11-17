package src;
public class Carga{
    private int codigo;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximoFrete;
    private TipoCarga carga;
    private Cliente cliente; 
    private Situacoes situacao;
    private Destino destino;

    public Carga(int codigo, int peso, double valorDeclarado, int tempoMaximoFrete, TipoCarga carga, Cliente cliente, Situacoes situacao,Destino destino) {
        this.codigo = codigo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximoFrete = tempoMaximoFrete;
        this.carga = carga;
        this.cliente = cliente;
        this.situacao = situacao;
        this.destino = destino;
    }

    public int getCodigo() {
        return codigo;
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

    public String toString() {
        return "\nInformações da carga:" 
        + "\nCódigo: " + codigo
        + "\nPeso: " + peso 
        + "\nValor declarado: " + valorDeclarado
        + "\nTempo Maximo: " + tempoMaximoFrete
        + "\nTipo da Carga: " + carga.toString();
    }

}
