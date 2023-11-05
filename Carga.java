public class Carga {
    protected int codigo;
    protected int peso;
    protected double valorDeclarado;
    protected int tempoMaximo;

    public Carga(int codigo, int peso, double valorDeclarado, int tempoMaximo) {
        this.codigo = codigo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
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
        return tempoMaximo;
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
        this.tempoMaximo = tempoMaximo;
    }

    public String toString() {
        return "\nInformações da carga:" 
        + "\nCódigo: " + codigo
        + "\nPeso: " + peso 
        + "\nValor declarado: " + valorDeclarado
        + "\nTempo Maximo: " + tempoMaximo;
    }
}