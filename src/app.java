import java.util.Arrays;

public class app {
    public frotaCaminhoes frota = new frotaCaminhoes();
    public DestinosCad destinos = new DestinosCad();
    public ClienteCad clientes = new ClienteCad();
    public CargasCad cargas = new CargasCad();
    public static void main(String[] args) {


//        Cliente cliente1 = new Cliente(1, "João", "999999999");
//        Cliente cliente2 = new Cliente(2, "Maria", "888888888");
//
//        Carga carga1 = new Carga(1, 100, 1000, 10,
//        new TipoCargaDuravel(1, "Carga durável", "Setor 1", "Material 1"),
//        cliente1, Situacoes.Pendente,new Destino( 1000,"São Paulo"),new Destino( 1000,"Rio de janeiro"));
//
//
//
//        Caminhao caminhao1 = new Caminhao("Caminhão 1", 100, 1000, 10, 1);
//
//         frete(caminhao1,carga1);
    }

    public static void frete(Caminhao caminhao, Carga carga) {
        //preco do peso da carga || carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())
        //preco destino || caminhao.getCustoPorKm * new API().setRequestMethod(carga);

        System.out.println(caminhao.getCustoPorKm());

        System.out.println(carga.getTipoCarga().getPrecoPorPeso(carga.getPeso()));

        System.out.println((caminhao.getCustoPorKm() * new API().setRequestMethod(carga)) + (carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())));
    }

    public static void saveContext(){

    }

    public void cadastrarCliente(Integer codigo, String nome, String telefone) {
        Cliente cliente = new Cliente(codigo, nome, telefone);
        this.clientes.add(cliente);
    }

    public void cadastraCargaDuravel(int codigo, int peso, double valorDeclarado, int tempoMaximoFrete, int codTip, String nomeTip, String setorTip, String materialTip, Cliente cliente, Situacoes situacao,Destino destino,Destino origem){
        Carga carga = new Carga(codigo, peso, valorDeclarado, tempoMaximoFrete, new TipoCargaDuravel(codTip, nomeTip, setorTip, materialTip), cliente, situacao, destino, origem);
        this.cargas.add(carga);
    }
    public void cadastraCargaPerecivel(int codigo, int peso, double valorDeclarado, int tempoMaximoFrete, int numerotip, String descricaotip,int tempoMaximotip, Cliente cliente, Situacoes situacao,Destino destino,Destino origem){
        Carga carga = new Carga(codigo, peso, valorDeclarado, tempoMaximoFrete, new TipoCargaPerecivel(numerotip, descricaotip, tempoMaximotip), cliente, situacao, destino, origem);
        this.cargas.add(carga);
    }

    public void cadastraCaminhao(String nome, int capacidade, double custoPorKm, int tempoMaximoFrete, int codigo){
        Caminhao caminhao = new Caminhao(nome, capacidade, custoPorKm, tempoMaximoFrete, codigo);
        this.frota.add(caminhao);
    }

    public void cadastraLocal(int codigo, String nomeCidade){
        Destino destino = new Destino(codigo, nomeCidade);
        this.destinos.add(destino);
    }

}
