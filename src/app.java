import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.*;
import java.io.File;

public class app {

    public frotaCaminhoes frota = new frotaCaminhoes();
    public DestinosCad destinos = new DestinosCad();
    public ClienteCad clientes = new ClienteCad();
    public CargasCad cargas = new CargasCad();

    HashMap<Caminhao,Carga> pendentes= new HashMap<Caminhao,Carga>();


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
        frame.setSize(600, 600);

        // Configurando CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel panelPrincipal = new JPanel(cardLayout);

        // Painel do Menu
        JPanel menuPanel = new JPanel();
        JButton btnCadastroCaminhao = new JButton("Cadastrar caminhão");
        JButton btnCadastroCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastroDestino = new JButton("Cadastrar Destino");
        JButton btnCadastroCargPerecivel = new JButton("Cadastrar carga perecivel");
        JButton btnCadastraCargDuravel = new JButton("Cadastrar carga duravel");
        JButton btnSaveContext = new JButton("Salvar cadastros");
        JButton btnloadContext = new JButton("Inserir cadastros");
        JButton btnPrintaCargas = new JButton("Mostrar Cargas");
        JButton btnFrete = new JButton("Fretar");
        JButton btnPrintaCliente = new JButton("Mostrar Clientes");
        JButton btnPrintaCaminhao = new JButton("Mostrar Caminhoes");
        JButton btnPrintaDestino = new JButton("Mostrar Destinos");

        btnPrintaCargas.setVisible(true);
        btnPrintaCliente.setVisible(true);
        btnFrete.setVisible(true);

        menuPanel.add(btnCadastroCaminhao);
        menuPanel.add(btnCadastroCliente);
        menuPanel.add(btnCadastroDestino);
        menuPanel.add(btnSaveContext);
        menuPanel.add(btnloadContext);
        menuPanel.add(btnCadastroCargPerecivel);
        menuPanel.add(btnCadastraCargDuravel);
        menuPanel.add(btnPrintaCargas);
        menuPanel.add(btnPrintaCliente);
        menuPanel.add(btnFrete);
        menuPanel.add(btnPrintaCaminhao);
        menuPanel.add(btnPrintaDestino);


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

        JLabel labelERRO3 = new JLabel("Resultado:");
        cadastroDeCliente.add(labelERRO3);
        labelERRO3.setVisible(true);
        JLabel labelfantasma3 = new JLabel();
        cadastroDeCliente.add(labelfantasma3);
        labelfantasma3.setVisible(true);

        // Botão de cadastro
        JButton btnCadastrarCliente = new JButton("Cadastrar");
        cadastroDeCliente.add(btnCadastrarCliente);
        btnCadastrarCliente.setVisible(true);
        btnCadastrarCliente.addActionListener(a -> {

            try{
                cadastrarCliente((int) Double.parseDouble(cod.getText()), nomeC.getText(), telefone.getText());
                System.out.println(clientes.clientes.toString());
                labelfantasma3.setText("Cadastro aceito");
            }catch(Exception e){
                labelfantasma3.setText("Erro no cadastro");
            }

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

            JLabel labelERRO2 = new JLabel("Resultado:");
            cadastroDeDestino.add(labelERRO2);
            labelERRO2.setVisible(true);
            JLabel labelfantasma2 = new JLabel();
            cadastroDeDestino.add(labelfantasma2);
            labelfantasma2.setVisible(true);

            // Botão de cadastro
            JButton btnCadastrarDestino = new JButton("Cadastrar");
            cadastroDeDestino.add(btnCadastrarDestino);
            cadastroDeDestino.setVisible(true);
            btnCadastrarDestino.addActionListener(c -> {
                try{
                    cadastraLocal((int) Double.parseDouble(codDestino.getText()), nomeCidade.getText());
                    System.out.println(destinos.destinos.toString());
                    labelfantasma2.setText("Cadastro aceito");
                }catch(Exception e){
                    labelfantasma2.setText("Erro no cadastro");
                }


            });
//        public void cadastraLocal(int codigo, String nomeCidade){
//            Destino destino = new Destino(codigo, nomeCidade);
//            this.destinos.add(destino);
//        }
            //====================================FIM PANEL DESTINO=======================================================================
            // ===================================INICIO PANEL CARGAPERECIVEL==============================================================
        JPanel cargaCadPanel = new JPanel();
        cargaCadPanel.setSize(700, 600);
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

        JLabel labelERRO1 = new JLabel("Resultado:");
        cargaCadPanel.add(labelERRO1);
        labelERRO1.setVisible(true);
        JLabel labelfantasma1 = new JLabel();
        cargaCadPanel.add(labelfantasma1);
        labelfantasma1.setVisible(true);

        // Botão de cadastro
        JButton btnCadastrarCargaPerecivel = new JButton("Cadastrar");
        cargaCadPanel.add(btnCadastrarCargaPerecivel);
        btnCadastrarCargaPerecivel.setVisible(true);
        btnCadastrarCargaPerecivel.addActionListener(y -> {
            try{
                cadastraCargaPerecivel((int) Double.parseDouble(CodigoCargaPerecivel.getText()), (int) Double.parseDouble(PesoCargaPerecivel.getText()), Double.parseDouble(ValorCargaPerecivel.getText()), (int) Double.parseDouble(TempoMAX1.getText()), (int) Double.parseDouble(codigoTipo1.getText()), descTipo1.getText(), (int) Double.parseDouble(tempoMAXp.getText()), clientes.serchCliente((int) Double.parseDouble(codCliente.getText())), Situacoes.valueOf(SituacaoPer.getText()), destinos.serchDestino((int) Double.parseDouble(Destino1.getText())), destinos.serchDestino((int) Double.parseDouble(Origem1.getText())));
                labelfantasma1.setText("Cadastro aceito");
            }catch(Exception e){
                labelfantasma1.setText("Erro no cadastro");
            }

        });

        cargaCadPanel.setVisible(true);

        //===================================FIM PANEL CARGA==============================================================
        //===================================INICIO PANEL CARGADURAVEL==============================================================
        JPanel cargaCadPanel2 = new JPanel();
        cargaCadPanel2.setSize(700,600);

        cargaCadPanel2.setLayout(new GridLayout(0, 2));
        cargaCadPanel2.add(new JLabel("Codigo:"));
        JTextField CodigoCargaDuravel = new JTextField();
        cargaCadPanel2.add(CodigoCargaDuravel);

        cargaCadPanel2.add(new JLabel("Peso:"));
        JTextField PesoCargaDuravel = new JTextField();
        cargaCadPanel2.add(PesoCargaDuravel);

        cargaCadPanel2.add(new JLabel("Valor:"));
        JTextField ValorCargaDuravel= new JTextField();
        cargaCadPanel2.add(ValorCargaDuravel);

        cargaCadPanel2.add(new JLabel("Tempo maximo de frete"));
        JTextField TempoMAX2 = new JTextField();
        cargaCadPanel2.add(TempoMAX2);

        cargaCadPanel2.add(new JLabel("Código do tipo"));
        JTextField codigoTipo2 = new JTextField();
        cargaCadPanel2.add(codigoTipo2);

        cargaCadPanel2.add(new JLabel("Nome do tipo"));
        JTextField nomeTipo2 = new JTextField();
        cargaCadPanel2.add(nomeTipo2);

        cargaCadPanel2.add(new JLabel("Setor do tipo"));
        JTextField Setor = new JTextField();
        cargaCadPanel2.add(Setor);

        cargaCadPanel2.add(new JLabel("Tipo de material"));
        JTextField matTip = new JTextField();
        cargaCadPanel2.add(matTip);

        cargaCadPanel2.add(new JLabel("Codigo do cliente"));
        JTextField codCliente2 = new JTextField();
        cargaCadPanel2.add(codCliente2);

        cargaCadPanel2.add(new JLabel("Situacao"));
        JTextField SituacaoPer2 = new JTextField();
        cargaCadPanel2.add(SituacaoPer2);

        cargaCadPanel2.add(new JLabel("Codigo Destino"));
        JTextField Destino2= new JTextField();
        cargaCadPanel2.add(Destino2);

        cargaCadPanel2.add(new JLabel("Codigo Origem"));
        JTextField Origem2 = new JTextField();
        cargaCadPanel2.add(Origem2);
        JLabel labelERRO = new JLabel("Resultado:");
        cargaCadPanel2.add(labelERRO);
        labelERRO.setVisible(true);
        JLabel labelfantasma = new JLabel();
        cargaCadPanel2.add(labelfantasma);
        labelfantasma.setVisible(true);
        // Botão de cadastro
        JButton btnCadastrarCargaDuravel = new JButton("Cadastrar");
        cargaCadPanel2.add(btnCadastrarCargaDuravel);
        btnCadastrarCargaDuravel.setVisible(true);
        btnCadastrarCargaDuravel.addActionListener(y -> {
            try {
                cadastraCargaDuravel((int) Double.parseDouble(CodigoCargaDuravel.getText()),
                        (int) Double.parseDouble(PesoCargaDuravel.getText()),
                        Double.parseDouble(ValorCargaDuravel.getText()),
                        (int) Double.parseDouble(TempoMAX2.getText()),
                        (int) Double.parseDouble(codigoTipo2.getText()),
                        nomeTipo2.getText(),
                        Setor.getText(),
                        matTip.getText(),
                        clientes.serchCliente((int) Double.parseDouble(codCliente2.getText())),
                        Situacoes.valueOf(SituacaoPer2.getText()),
                        destinos.serchDestino((int) Double.parseDouble(Destino2.getText())),
                        destinos.serchDestino((int) Double.parseDouble(Origem2.getText())));
                        labelfantasma.setText("Cadastro aceito");
            }catch (Exception e){
                labelfantasma.setText("Erro ao cadastrar");
            }


           // public void cadastraCargaDuravel(int codigo, int peso, double valorDeclarado, int tempoMaximoFrete,int codTip, String nomeTip, String setorTip, String materialTip, Cliente cliente, Situacoes situacao,Destino destino,Destino origem)
        });

        cargaCadPanel2.setVisible(true);
        //===================================FIM PANEL CARGADURAVEL==============================================================
        //==============================PRINT CARGAS=====================================================================
        JPanel printaCargas = new JPanel();
        JTextArea areaTexto1 = new JTextArea();
        areaTexto1.setEditable(false);
        areaTexto1.setVisible(true);
        printaCargas.setVisible(true);
        //==============================PRINT CARGAS FIM=====================================================================
        //==============================PRINT Cliente=====================================================================
        JPanel printaClientes = new JPanel();
        JTextArea areaTexto2 = new JTextArea();
        areaTexto2.setEditable(false);
        areaTexto2.setVisible(true);
        printaClientes.setVisible(true);
        //==============================PRINT Cliente FIM=====================================================================
        //==============================PRINT Caminhao=====================================================================
        JPanel printaCaminha = new JPanel();
        JTextArea areaTexto3 = new JTextArea();
        areaTexto3.setEditable(false);
        areaTexto3.setVisible(true);
        printaCaminha.setVisible(true);
        //==============================PRINT Caminhao FIM=====================================================================
        //==============================PRINT destino=====================================================================
        JPanel printaDestino = new JPanel();
        JTextArea areaTexto4 = new JTextArea();
        areaTexto4.setEditable(false);
        areaTexto4.setVisible(true);
        printaDestino.setVisible(true);
        //==============================PRINT destino FIM=====================================================================
        //==============================Calcualr frete=====================================================================
        // Configurações da janela
        JPanel frete = new JPanel();


        // Campos de entrada
        JTextField textFieldNumero1 = new JTextField(10);
        JTextField textFieldNumero2 = new JTextField(10);

        // Rótulo para exibir o resultado
        JLabel labelResultado = new JLabel("Frete: ");

        // Botão para calcular a soma
        JButton botaoCalcular = new JButton("Calcular Frete");
        botaoCalcular.addActionListener(e -> {
            if(pendentes.get(frota.searchCaminhao((int) Double.parseDouble(textFieldNumero1.getText())))==null&&cargas.searchCarga((int) Double.parseDouble(textFieldNumero2.getText())).getSituacao()==Situacoes.Pendente){
                pendentes.put(frota.searchCaminhao((int) Double.parseDouble(textFieldNumero1.getText())),cargas.searchCarga((int) Double.parseDouble(textFieldNumero2.getText())));
                cargas.changeCargaSit((int) Double.parseDouble(textFieldNumero2.getText()),Situacoes.Locada);
                labelResultado.setText(frete(frota.searchCaminhao((int) Double.parseDouble(textFieldNumero1.getText())), cargas.searchCarga((int) Double.parseDouble(textFieldNumero2.getText()))));
            }else{
                labelResultado.setText("Caminhao ja locado ou carga ja locada");
            }
        });

        // Adicionando componentes à janela
        frete.add(new JLabel("cod caminhao 1:"));
        frete.add(textFieldNumero1);
        frete.add(new JLabel("cod carga 2:"));
        frete.add(textFieldNumero2);
        frete.add(botaoCalcular);
        frete.add(labelResultado);

        // Exibir a janela
        frete.setVisible(true);

        //==============================Calcualr frete fim=====================================================================
        //=======================================CONFIG DE BOTOES============================================================

        JButton btnVoltar1 = new JButton("Voltar");
        JButton btnVoltar2 = new JButton("Voltar");
        JButton btnVoltar3 = new JButton("Voltar");
        JButton btnVoltar4 = new JButton("Voltar");
        JButton btnVoltar5 = new JButton("Voltar");
        JButton btnVoltar6 = new JButton("Voltar");
        JButton btnVoltar7 = new JButton("Voltar");
        JButton btnVoltar8 = new JButton("Voltar");
        JButton btnVoltar9 = new JButton("Voltar");
        JButton btnVoltar10 = new JButton("Voltar");
        JButton btnVoltar11 = new JButton("Voltar");

        cadastroDeCami.add(btnVoltar1);
        cadastroDeCliente.add(btnVoltar2);
        cadastroDeDestino.add(btnVoltar3);
        cargaCadPanel.add(btnVoltar4);
        //printaCargas.add(btnVoltar5);
        cargaCadPanel2.add(btnVoltar6);
        frete.add(btnVoltar7);
        printaCargas.add(btnVoltar8);
        printaClientes.add(btnVoltar9);
        printaDestino.add(btnVoltar10);
        printaCaminha.add(btnVoltar10);


                    // Adicionando painéis ao CardLayout
                    panelPrincipal.add(printaCaminha,"Pritancaminhao");
                    panelPrincipal.add(printaClientes,"Pritacliente");
                    panelPrincipal.add(menuPanel, "Menu");
                    panelPrincipal.add(cadastroDeCami, "CadastroCam");
                    panelPrincipal.add(cadastroDeCliente, "CadastroCliente");
                    panelPrincipal.add(cadastroDeDestino, "CadastroDestino");
                    panelPrincipal.add(cargaCadPanel,"CadastroCargaPerecivel");
                    panelPrincipal.add(frete,"Frete");
                    panelPrincipal.add(cargaCadPanel2, "CadastroCargaDuravel");
                    panelPrincipal.add(printaCargas,"Pritancarga");
                    panelPrincipal.add(printaDestino,"PritaDestino");


                    //Configurando a ação do botão para ir para o conteúdo
                    btnCadastroCaminhao.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "CadastroCam");

                    });
                    btnCadastraCargDuravel.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "CadastroCargaDuravel");

                    });

                    btnPrintaCargas.addActionListener(e -> {
                        JScrollPane scrollPane;
                        String [] vecStri = cargas.getCargasString();
                        for (String objeto : vecStri) {
                            areaTexto1.append(objeto+ "\n");
                        }
                        scrollPane = new JScrollPane(areaTexto1);
                        scrollPane.setSize(400,400);
                        scrollPane.setVisible(true);
                        scrollPane.setPreferredSize(new Dimension(300, 200));
                        printaCargas.add(scrollPane, BorderLayout.CENTER);
                        cardLayout.show(panelPrincipal, "Pritancarga");

                    });

                    btnPrintaCliente.addActionListener(e -> {
                        JScrollPane scrollPane2;
                        String [] vecStrim = clientes.getClientesString();
                        for (String objeto : vecStrim) {
                            areaTexto2.append(objeto+ "\n");
                        }

                        scrollPane2 = new JScrollPane(areaTexto2);
                        scrollPane2.setSize(400,400);
                        scrollPane2.setVisible(true);
                        scrollPane2.setPreferredSize(new Dimension(300, 200));
                        printaClientes.add(scrollPane2, BorderLayout.CENTER);
                        cardLayout.show(panelPrincipal, "Pritacliente");
                    });

                    btnPrintaDestino.addActionListener(e -> {
                        JScrollPane scrollPane4;
                        String [] vecStr = destinos.getDestinosString();
                        for (String objeto : vecStr) {
                            areaTexto4.append(objeto+ "\n");
                        }
                        scrollPane4 = new JScrollPane(areaTexto4);
                        scrollPane4.setSize(400,400);
                        scrollPane4.setVisible(true);
                        scrollPane4.setPreferredSize(new Dimension(300, 200));
                        printaDestino.add(scrollPane4, BorderLayout.CENTER);
                        cardLayout.show(panelPrincipal, "PritaDestino");

                    });

                    btnPrintaCaminhao.addActionListener(e -> {
                        JScrollPane scrollPane3;
                        String [] vecStrin = frota.getFrotaString();
                        for (String objeto : vecStrin) {
                            areaTexto3.append(objeto+ "\n");
                        }
                        scrollPane3 = new JScrollPane(areaTexto3);
                        scrollPane3.setSize(400,400);
                        scrollPane3.setVisible(true);
                        scrollPane3.setPreferredSize(new Dimension(300, 200));
                        printaCaminha.add(scrollPane3, BorderLayout.CENTER);
                        cardLayout.show(panelPrincipal, "Pritancaminhao");

                    });

                    btnFrete.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Frete");

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


                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
                    btnVoltar6.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar7.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar8.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });
                    btnVoltar9.addActionListener(e -> {

                        cardLayout.show(panelPrincipal, "Menu");

                    });

                    btnVoltar10.addActionListener(e -> {

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


    public static String frete(Caminhao caminhao, Carga carga) {
        //preco do peso da carga || carga.getTipoCarga().getPrecoPorPeso(carga.getPeso())
        //preco destino || caminhao.getCustoPorKm * new API().setRequestMethod(carga);

        System.out.println(caminhao.getCustoPorKm());

        System.out.println(carga.getTipoCarga().getPrecoPorPeso(carga.getPeso()));
        double result = caminhao.getCustoPorKm() * new API().setRequestMethod(carga) + (carga.getTipoCarga().getPrecoPorPeso(carga.getPeso()));
        return "custo:"+result;

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
            System.out.println("Carregado com sucesso");

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
        cargas.add(carga);
    }
    public void cadastraCargaPerecivel(int codigo, int peso, double valorDeclarado, int tempoMaximoFrete, int numerotip, String descricaotip,int tempoMaximotip, Cliente cliente, Situacoes situacao,Destino destino,Destino origem){
        Carga carga = new Carga(codigo, peso, valorDeclarado, tempoMaximoFrete, new TipoCargaPerecivel(numerotip, descricaotip, tempoMaximotip), cliente, situacao, destino, origem);
        cargas.add(carga);
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
