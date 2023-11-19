
public class TipoCargaPerecivel extends TipoCarga{
    public String origem;
    public int tempoMaximo;


    public TipoCargaPerecivel(int numero, String descricao,int tempoMaximo) {
        super(numero, descricao);
        this.tempoMaximo = tempoMaximo;
        this.origem = origem;
    }
//Perecível: possui uma origem (String) e um tempo máximo
//de validade (int);


    @Override
    public double getPrecoPorPeso(double peso) {
        return peso*2;
    }


    
}