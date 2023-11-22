import javax.swing.*;
import java.awt.*;
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
//        cadastraLocal(1, "Sao jeronimo");
//
//
//        cadastrarCliente(1, "Joao", "123");
//        cadastrarCliente(2, "Maria", "456");
//        cadastraLocal(1, "Porto Alegre");
//        cadastraLocal(2, "Sao Paulo");
//        cadastraCargaDuravel(1, 10, 100, 10, 1, "nome", "setor", "material", clientes.clientes.get(0), Situacoes.Pendente, destinos.destinos.get(0), destinos.destinos.get(1));
//        cadastraCargaPerecivel(2, 10, 100, 10, 1, "descricao", 10, clientes.clientes.get(1), Situacoes.Pendente, destinos.destinos.get(0), destinos.destinos.get(1));
//        cadastraCaminhao("nome", 10, 100, 10, 1);
//        cadastraLocal(1, "Triunfo");
//
//        saveContext();
//
//         frota = new frotaCaminhoes();
//         destinos = new DestinosCad();
//         clientes = new ClienteCad();
//         cargas = new CargasCad();
//
//
//         loadContext();
//         saveContext();
        JFrame frame = new JFrame("Transporte de cargas terrestres");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Configurando CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel panelPrincipal = new JPanel(cardLayout);

        // Painel do Menu
        JPanel menuPanel = new JPanel();
        JButton btnCadastroCaminhao = new JButton("Cadastrar caminhão");
        JButton btnCadastroCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastroDestino = new JButton("Cadastrar Destino");
        JButton btnCadastroCargPerecivel = new JButton("Cadastrar carga perecivel");
        JButton btnSaveContext = new JButton("Salvar cadastros");
        JButton btnloadContext = new JButton("Inserir cadastros");
        JButton btnPrintaCargas = new JButton("Mostrar Cargas");


        menuPanel.add(btnCadastroCaminhao);
        menuPanel.add(btnCadastroCliente);
        menuPanel.add(btnCadastroDestino);
        menuPanel.add(btnSaveContext);
        menuPanel.add(btnloadContext);
        menuPanel.add(btnCadastroCargPerecivel);
        menuPanel.add(btnPrintaCargas);
        btnSaveContext.addActionListener(e->{
            saveContext();
        });
        btnloadContext.addActionListener(e->{
            loadContext();
        });
        // Painel de Conteúdo


        // Adicionando painéis ao CardLayout




        //===================================INICIO PANEL CAMINHAO==============================================================
        JPanel cadastroDeCami = new JPanel();
        cadastroDeCami.setSize(400, 300);
        cadastroDeCami.setLayout(new GridLayout(0, 2));
        cadastroDeCami.add(new JLabel("Nome:"));
        JTextField nome = new JTextField();
        cadastroDeCami.add(nome);
        cadastroDeCami.add(new JLabel("Velocidade:"));
        JTextField velocidade = new JTextField();
        cadastroDeCami.add(velocidade);
        cadastroDeCami.add(new JLabel("Autonomia:"));
        JTextField autonomia = new JTextField();
        cadastroDeCami.add(autonomia);
        cadastroDeCami.add(new JLabel("Custo por Km:"));
        JTextField custoporkm = new JTextField();
        cadastroDeCami.add(custoporkm);
        cadastroDeCami.add(new JLabel("Código:"));
        JTextField codigo = new JTextField();
        cadastroDeCami.add(codigo);
        // Botão de cadastro
        JButton btnCadastrar = new JButton("Cadastrar");
        cadastroDeCami.add(btnCadastrar);
        btnCadastrar.setVisible(true);
        btnCadastrar.addActionListener(x -> {
                    cadastraCaminhao(nome.getText(), (int) Double.parseDouble(velocidade.getText()), Double.parseDouble(autonomia.getText()), (int) Double.parseDouble(custoporkm.getText()), (int) Double.parseDouble(codigo.getText()));
                    System.out.println(frota.frota.toString());
        });
        //===================================FIM PANEL CAMINHAO==============================================================
        //===================================INICIO PAINEL CLIENTE===========================================================
        JPanel cadastroDeCliente = new JPanel();
        cadastroDeCliente.setSize(400, 300);
        cadastroDeCliente.setLayout(new GridLayout(0, 2));
        cadastroDeCliente.add(new JLabel("Cod:"));
        JTextField cod = new JTextField();
        cadastroDeCliente.add(cod);
        cadastroDeCliente.add(new JLabel("Nome:"));
        JTextField nomeC = new JTextField();
        cadastroDeCliente.add(nomeC);
        cadastroDeCliente.add(new JLabel("Telefone:"));
        JTextField telefone = new JTextField();
        cadastroDeCliente.add(telefone);

        // Botão de cadastro
        JButton btnCadastrarCliente = new JButton("Cadastrar");
        cadastroDeCliente.add(btnCadastrarCliente);
        btnCadastrarCliente.setVisible(true);
        btnCadastrarCliente.addActionListener(a -> {
                    cadastrarCliente((int) Double.parseDouble(cod.getText()), nomeC.getText(), telefone.getText());
                    System.out.println(clientes.clientes.toString());
        });


            ///public void cadastrarCliente(Integer codigo, String nome, String telefone) {
//                Cliente cliente = new Cliente(codigo, nome, telefone);
//                this.clientes.add(cliente);
//            }
            //===================================FIM PANEL CLIENTE =================================================================
            //===================================INICIO PANEL DESTINO================================================================
            JPanel cadastroDeDestino = new JPanel();
            cadastroDeDestino.setSize(400, 300);
            cadastroDeDestino.setLayout(new GridLayout(0, 2));
            cadastroDeDestino.add(new JLabel("Código:"));
            JTextField codDestino = new JTextField();
            cadastroDeDestino.add(codDestino);
            cadastroDeDestino.add(new JLabel("Nome da cidade:"));
            JTextField nomeCidade = new JTextField();
            cadastroDeDestino.add(nomeCidade);

            // Botão de cadastro
            JButton btnCadastrarDestino = new JButton("Cadastrar");
            cadastroDeDestino.add(btnCadastrarDestino);
            cadastroDeDestino.setVisible(true);
            btnCadastrarDestino.addActionListener(c -> {
                cadastraLocal((int) Double.parseDouble(codDestino.getText()), nomeCidade.getText());
                System.out.println(destinos.destinos.toString());
            });
//        public void cadastraLocal(int codigo, String nomeCidade){
//            Destino destino = new Destino(codigo, nomeCidade);
//            this.destinos.add(destino);
//        }
            //====================================FIM PANEL DESTINO=======================================================================
            // ===================================INICIO PANEL CARGAPERECIVEL==============================================================
            JPanel cargaCadPanel = new JPanel();
            cargaCadPanel.setSize(400, 300);
            cargaCadPanel.setLayout(new GridLayout(0, 2));
            cargaCadPanel.add(new JLabel("Codigo:"));
            JTextField CodigoCargaPerecivel = new JTextField();
            cargaCadPanel.add(CodigoCargaPerecivel);
            cargaCadPanel.add(new JLabel("Peso:"));
            JTextField PesoCargaPerecivel = new JTextField();
            cargaCadPanel.add(PesoCargaPerecivel);
            cargaCadPanel.add(new JLabel("Valor:"));
            JTextField ValorCargaPerecivel = new JTextField();
            cargaCadPanel.add(ValorCargaPerecivel);
            cargaCadPanel.add(new JLabel("Tempo maximo de frete"));
            JTextField TempoMAX1 = new JTextField();
            cargaCadPanel.add(TempoMAX1);
            cargaCadPanel.add(new JLabel("Código do tipo"));
            JTextField codigoTipo1 = new JTextField();
            cargaCadPanel.add(codigoTipo1);
            cargaCadPanel.add(new JLabel("Descricao do tipo"));
            JTextField descTipo1 = new JTextField();
            cargaCadPanel.add(descTipo1);
            cargaCadPanel.add(new JLabel("Tempo maximo Perecivel"));
            JTextField tempoMAXp = new JTextField();
            cargaCadPanel.add(tempoMAXp );
            cargaCadPanel.add(new JLabel("Codigo do cliente"));
            JTextField codCliente = new JTextField();
            cargaCadPanel.add(codCliente);
            cargaCadPanel.add(new JLabel("Situacao"));
            JTextField SituacaoPer = new JTextField();
            cargaCadPanel.add(SituacaoPer);
            cargaCadPanel.add(new JLabel("Codigo Destino"));
            JTextField Destino1= new JTextField();
            cargaCadPanel.add(Destino1);
            cargaCadPanel.add(new JLabel("Codigo Origem"));
            JTextField Origem1 = new JTextField();
            cargaCadPanel.add(Origem1);

            // Botão de cadastro
            JButton btnCadastrarCargaPerecivel = new JButton("Cadastrar");
            cargaCadPanel.add(btnCadastrarCargaPerecivel);
            btnCadastrarCargaPerecivel.setVisible(true);
            btnCadastrarCargaPerecivel.addActionListener(y -> {
                cadastraCargaPerecivel((int) Double.parseDouble(CodigoCargaPerecivel.getText()), (int) Double.parseDouble(PesoCargaPerecivel.getText()), Double.parseDouble(ValorCargaPerecivel.getText()), (int) Double.parseDouble(TempoMAX1.getText()), (int) Double.parseDouble(codigoTipo1.getText()), descTipo1.getText(), (int) Double.parseDouble(tempoMAXp.getText()), clientes.serchCliente((int) Double.parseDouble(codCliente.getText())), Situacoes.valueOf(SituacaoPer.getText()), destinos.serchDestino((int) Double.parseDouble(Destino1.getText())), destinos.serchDestino((int) Double.parseDouble(Origem1.getText())));
                System.out.println(cargas.cargas.toString());
            });

            cargaCadPanel.setVisible(true);

        //===================================FIM PANEL CARGA==============================================================
        //==============================PRINT CARGAS=====================================================================
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Carga obj : cargas.cargas) {
            listModel.addElement(obj.toString()+"\n");
        }

        // JList configurada com o modelo
        JList<String> list = new JList<>(listModel);
        list.setVisible(true);
        // JScrollPane contendo a JList

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVisible(true);
        // JPanel para conter a JScrollPane

        JPanel  printaCargas = new JPanel(new BorderLayout());
        printaCargas.add(scrollPane, BorderLayout.CENTER);
        printaCargas.setVisible(true);
        printaCargas.setSize(400,300);
        //==============================PRINT CARGAS FIM=====================================================================
        //=======================================CONFIG DE BOTOES============================================================

        JButton btnVoltar1 = new JButton("Voltar");
        JButton btnVoltar2 = new JButton("Voltar");
        JButton btnVoltar3 = new JButton("Voltar");
        JButton btnVoltar4 = new JButton("Voltar");
        JButton btnVoltar5 = new JButton("Voltar");


        cadastroDeCami.add(btnVoltar1);
        cadastroDeCliente.add(btnVoltar2);
        cadastroDeDestino.add(btnVoltar3);
        cargaCadPanel.add(btnVoltar4);




                    panelPrincipal.add(menuPanel, "Menu");
                    panelPrincipal.add(cadastroDeCami, "CadastroCam");
                    panelPrincipal.add(cadastroDeCliente, "CadastroCliente");
                    panelPrincipal.add(cadastroDeDestino, "CadastroDestino");
                    panelPrincipal.add(cargaCadPanel,"CadastroCargaPerecivel");
                    panelPrincipal.add(printaCargas, "Pritancarga");
                    // Configurando a ação do botão para ir para o conteúdo
                    btnCadastroCaminhao.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "CadastroCam");

                    });

                    btnPrintaCargas.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Pritancarga");

                    });

                    btnCadastroCliente.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "CadastroCliente");

                    });

                    btnCadastroDestino.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "CadastroDestino");

                    });

                    btnCadastroCargPerecivel.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "CadastroCargaPerecivel");

                    });
                    btnVoltar1.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar2.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar3.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar4.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar5.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });


                    //Configurando a ação do botão de voltar


    //====================================FIM CONFIG DE BOTOES==============================================================
                    // Adicionando o painel principal à janela
                    frame.add(panelPrincipal);

                    // Exibindo a janela
                    frame.setLocationRelativeTo(null); // Centraliza a janela na tela
                    frame.setVisible(true);





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
