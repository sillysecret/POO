
public class TipoCargaDuravel extends TipoCarga {
//Durável: que possui um setor (String) e o material principal (String)
private static final String idTipo = "Duravel";
    private String setor;
    private String materialPrincipal;

    public TipoCargaDuravel(int numero, String descricao, String setor, String materialPrincipal) {
        super(numero, descricao);
        this.setor = setor;
        this.materialPrincipal = materialPrincipal;
    }

    @Override
    public double getPrecoPorPeso(double peso) {
        return peso * 1.5;
    }

    public String toCSV() {
        return this.numero+";"+this.descricao+";"+this.setor+";"+this.materialPrincipal+";"+this.idTipo;
    }

    public String toString() {
        return super.toString()
        + "\nSetor: " + setor
        + "\nMaterial principal: " + materialPrincipal;
    }
}
