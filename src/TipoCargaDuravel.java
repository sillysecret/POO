
public class TipoCargaDuravel extends TipoCarga{
//Durável: que possui um setor (String) e o material principal (String)

private String setor;
private String materialPrincipal;

public TipoCargaDuravel(int numero, String descricao,String setor,String materialPrincipal) {
    super(numero, descricao);
    this.setor = setor;
    this.materialPrincipal = materialPrincipal;
}

@Override
public double getPrecoPorPeso(double peso) {
    return peso*1.5;
}


}

