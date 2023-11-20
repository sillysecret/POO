import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;

public class app {
    public frotaCaminhoes frota = new frotaCaminhoes();
    public DestinosCad destinos = new DestinosCad();
    public ClienteCad clientes = new ClienteCad();
    public CargasCad cargas = new CargasCad();

    public app(){
        executa();
    }
    private void executa(){
        cadastrarCliente(1, "Joao", "123");
        cadastrarCliente(2, "Maria", "456");
        cadastraLocal(1, "Porto Alegre");
        cadastraLocal(2, "Sao Paulo");
        cadastraCargaDuravel(1, 10, 100, 10, 1, "nome", "setor", "material", clientes.clientes.get(0), Situacoes.Pendente, destinos.destinos.get(0), destinos.destinos.get(1));
        cadastraCargaPerecivel(2, 10, 100, 10, 1, "descricao", 10, clientes.clientes.get(1), Situacoes.Pendente, destinos.destinos.get(0), destinos.destinos.get(1));
        cadastraCaminhao("nome", 10, 100, 10, 1);

        saveContext();

    }
    public static void frete(Caminhao caminhao, Carga carga) {
        //preco do peso da carga || carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())
        //preco destino || caminhao.getCustoPorKm * new API().setRequestMethod(carga);

        System.out.println(caminhao.getCustoPorKm());

        System.out.println(carga.getTipoCarga().getPrecoPorPeso(carga.getPeso()));

        System.out.println((caminhao.getCustoPorKm() * new API().setRequestMethod(carga)) + (carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())));
    }

    public void saveContext(){
        try{

            File file = new File("save.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Cargas\n");
            for(Carga c : cargas.cargas){
                writer.write(c.toCSV()+"\n");
                System.out.println(c.toCSV());
            }


            writer.write("Caaminhões\n");
            for(Caminhao c : frota.frota){
                writer.write(c.toCSV()+"\n");
                System.out.println(c.toCSV());
            }


            writer.write("Destinos\n");
            for(Destino d : destinos.destinos){
                writer.write(d.toCSV()+"\n");
                System.out.println(d.toCSV());
            }

            writer.write("Clientes\n");
            for(Cliente c :clientes.clientes){
                writer.write(c.toCSV()+"\n");
                System.out.println(c.toCSV());
            }
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }

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
