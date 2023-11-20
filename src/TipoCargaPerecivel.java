
public class TipoCargaPerecivel extends TipoCarga{

    private static final String idTipo = "Perecivel";
    private int tempoMaximo;


    public TipoCargaPerecivel(int numero, String descricao,int tempoMaximo) {
        super(numero, descricao);
        this.tempoMaximo = tempoMaximo;

    }




    @Override
    public double getPrecoPorPeso(double peso) {
        return peso*2;
    }

    public String toCSV() {
        return this.numero +";"+this.descricao + ";"+ this.tempoMaximo+";"+this.idTipo;
    }
    
}