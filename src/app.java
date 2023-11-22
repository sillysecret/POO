import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.Buffer;
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
        cadastraLocal(1, "Sao jeronimo");


        cadastrarCliente(1, "Joao", "123");
        cadastrarCliente(2, "Maria", "456");
        cadastraLocal(1, "Porto Alegre");
        cadastraLocal(2, "Sao Paulo");
        cadastraCargaDuravel(1, 10, 100, 10, 1, "nome", "setor", "material", clientes.clientes.get(0), Situacoes.Pendente, destinos.destinos.get(0), destinos.destinos.get(1));
        cadastraCargaPerecivel(2, 10, 100, 10, 1, "descricao", 10, clientes.clientes.get(1), Situacoes.Pendente, destinos.destinos.get(0), destinos.destinos.get(1));
        cadastraCaminhao("nome", 10, 100, 10, 1);
        cadastraLocal(1, "Triunfo");

        saveContext();

         frota = new frotaCaminhoes();
         destinos = new DestinosCad();
         clientes = new ClienteCad();
         cargas = new CargasCad();


         loadContext();
         saveContext();




        //frete(frota.frota.get(0), cargas.cargas.get(0));
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





            for(Caminhao c : frota.frota){
                writer.write("caminhao;"+c.toCSV()+"\n");
                System.out.println(c.toCSV());
            }



            for(Destino d : destinos.destinos){
                writer.write("destino;"+d.toCSV()+"\n");
                System.out.println(d.toCSV());
            }


            for(Cliente c :clientes.clientes){
                writer.write("cliente;"+c.toCSV()+"\n");
                System.out.println(c.toCSV());
            }


            for(Carga c : cargas.cargas){
                writer.write("carga;"+c.toCSV()+"\n");
                System.out.println(c.toCSV());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void loadContext(){
        try {
            String linha;
            File file = new File("save.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            while((linha = reader.readLine()) !=null){
                String [] dados = linha.split(";");


                if (dados[0].equals("caminhao")){
                    cadastraCaminhao(dados[1], (int) Double.parseDouble(dados[2]), Double.parseDouble(dados[3]),(int)Double.parseDouble(dados[4]), (int)Double.parseDouble(dados[5]));
                }

                if (dados[0].equals("destino")){
                    cadastraLocal((int) Double.parseDouble(dados[1]), dados[2]);
                }

                if(dados[0].equals("cliente")){
                    cadastrarCliente((int) Double.parseDouble(dados[1]), dados[2], dados[3]);
                }

                if(dados[0].equals("carga")){
                    if(dados[8].equals("Perecivel")){
                            cadastraCargaPerecivel((int) Double.parseDouble(dados[1]), (int) Double.parseDouble(dados[2]), Double.parseDouble(dados[3]), (int) Double.parseDouble(dados[4]), (int) Double.parseDouble(dados[5]), dados[6], (int) Double.parseDouble(dados[7]), clientes.serchCliente(Integer.parseInt(dados[9])), Situacoes.valueOf(dados[12]), destinos.serchDestino(Integer.parseInt(dados[13])), destinos.serchDestino(Integer.parseInt(dados[15])));
                   }else{
                            cadastraCargaDuravel((int) Double.parseDouble(dados[1]), (int) Double.parseDouble(dados[2]), Double.parseDouble(dados[3]), (int) Double.parseDouble(dados[4]), (int) Double.parseDouble(dados[5]), dados[6], dados[7], dados[8], clientes.serchCliente(Integer.parseInt(dados[10])), Situacoes.valueOf(dados[13]), destinos.serchDestino(Integer.parseInt(dados[14])), destinos.serchDestino(Integer.parseInt(dados[16])));
                    }
                }
            }

        }catch (Exception e) {
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
