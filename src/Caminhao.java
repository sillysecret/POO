
public class Caminhao {
    private String nome;
    private double velocidade;
    private double autonomia;
    private double custoPorKm;
    private int codigo;

    public Caminhao(String nome, double velocidade, double autonomia, double custoPorKm, int codigo) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.autonomia = autonomia;
        this.custoPorKm = custoPorKm;
        this.codigo = codigo;
    }

    
    public String getNome() {
        return nome;
    }
    public double getVelocidade() {
        return velocidade;
    }
    public double getAutonomia() {
        return autonomia;
    }
    public double getCustoPorKm() {
        return custoPorKm;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }
    public void setCustoPorKm(double custoPorKm) {
        this.custoPorKm = custoPorKm;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        return "\nInformações do caminhão: " 
        + "\nNome: " + nome
        + "\nVelocidade: " + velocidade
        + "\nAutonomia: " + autonomia
        + "\nCusto por Km: " + custoPorKm
        + "\nCodigo: " + codigo;
    }
    
    
}
