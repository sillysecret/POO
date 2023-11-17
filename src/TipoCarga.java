package src;
public abstract class TipoCarga {

    private int numero;
    private String descricao;

    public TipoCarga(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public String toString() {
        return "\nInformações do tipo de carga: " 
        + "\nNumero: " + numero
        + "\nDescrição: " + descricao;
    }

    abstract public double getPrecoPorPeso(double peso);
}

//Tipo de carga: possui numero e descrição (Perecível: possui uma origem (String) e um tempo máximo
//de validade (int); Durável: que possui um setor (String) e o material principal (String)