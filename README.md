# POO
Instruções para commit
Utilizar a convenção de commit-lint: https://github.com/conventional-changelog/commitlint/tree/master/@commitlint/config-conventional#type-enum

Inclusão de nova funcionalidade: git commit -m "feat: adicionado feature de login"

Correção de bug: git commit -m "fix: corrigido bug de login"

Instruções para criação de branches
Utilizar a convenção de branches:

Nova feature: feature/nome-da-feature

Correção de bug: fix/nome-do-bug

## DESCR
-Caminhão: cada um possui código, nome único, autonomia e o valor do custo por km rodado.//
-Frota: Armazena caminhões marcando assim uma frota.//funções lambda para calcular capacidade prota.
- Destino: possui um código, um nome e a cidade.
- Cliente: possui um código, um nome e um número de telefone.
- Carga: um código único, tipo de carga, local de origem, local de destino, cliente, peso (toneladas), o
valor declarado pelo cliente e o tempo máximo (em dias) para o frete.
- Tipo de carga: possui numero e descrição (Perecível: possui uma origem (String) e um tempo máximo
de validade (int); Durável: que possui um setor (String) e o material principal (String).//USAR UMA CLASSE CARGA COMO PAI E CRIAR CLASSES FILHAS *CARGAPERECIVEL* *CARGANAOPERECIVEL* ASSIM CRIAR UM METODO COM POLIMORFISMO PARA CALCULAR DIFERENTE PREÇOS RELATIVOS AO TIPO DE CARGA
- Possíveis situações da carga: Pendente, Locada, Cancelada, Finalizada. Ao ser cadastrada uma carga fica
na situação Pendente; definindo um caminhão para a carga muda para a situação: Locada; carga foi
entregue a situação muda para finalizada (liberando o caminhão). Para uma carga não atendida, a
situação é cancelada.//PODE SER UM ENUM
- O cálculo do valor de um frete = PRECO POR DISTANCIA+ PRECO POR PESO//
- O preço por distância = ΔDISTANCIA (destino-origem ) X Custo por Km//
- O preço por peso depende do tipo da carga: PERECIVEL, é: Peso x2; DURÁVEL, é: peso x 1,5.//

## FUNC
- Cadastrar novo destino: cadastra os dados de um destino. Se já houver destinos cadastrados,
assume-se a distância de 50 Km entre cada um deles. Os destinos são mantidos em ordem
crescente de identificador.
- Cadastrar novo caminhão: cadastra os dados de um caminhão. Se houver caminhão com o
nome indicado mostrar uma mensagem de erro. Os caminhões são mantidos em ordem
crescente de nome.
- Cadastrar novo cliente: solicita os dados de um cliente. Se o código já existir, retorna
mensagem de erro. Os clientes são mantidos em ordem crescentede código.
- Cadastrar novo tipo de carga: solicita os dados de um tipo da carga. Se o número já existir,
mostra umamensagemde erro.Ostiposde carga são mantidos em ordem crescente de número.
- Cadastrar nova carga: solicita os dados de uma carga (se o código existir, mostra mensagem de
erro); colocar a nova carga em uma fila de cargas pendentes; ao final mostra na tela os dados
da nova carga cadastrada, incluindo os dados da origem e destino, cliente e tipo de carga. As
cargas são mantidas em ordem crescente de código.
- Consultar todas as cargas: mostra todas as cargas cadastradas e todos os dados das cargas
(origem e destino, cliente, do tipo de carga, situação, se possui caminhão designado, mostrar
os dados do caminhão e o valor final do frete).
- Alterar a situação de uma carga: solicita o código de uma carga, mostra os dados da carga,
solicita a nova situação [se não há carga com o código indicado, mostra uma mensagemde erro;
se a carga estiver na situação FINALIZADO, não pode ser alterado e mostra uma mensagem de
erro]).
- Carregar dados iniciais: carrega os dados num arquivo para o sistema; as cargas devem ser
carregadas em uma fila de cargas pendentes; ao final da carga de dados, mostra todos os dados
de destinos, caminhões, clientes, cargas. O formato do arquivo é de livre escolha.
- Fretar cargas: a partir da fila de cargas pendentes, verifica se é possível designar algum
caminhão disponível para cada carga, e atualiza a sua situação. Se há algum caminhão com
capacidade de fazer o frete, mas já está designado para outra carga, a carga retorna para a fila
de fretes pendentes. Se não há nenhum caminhão com capacidade de fazer o frete, a carga
muda para a situação CANCELADO [se não há cargas na fila de cargas pendentes, mostra uma
mensagem de erro]).
- Salvar dados: salvar todos os dados cadastrados em um ou mais arquivos. Se houver algum
problema para salvar deve mostrar uma mensagem de erro.
- Carregar dados: carrega todos os dados de um ou mais arquivos. Se houver algum problema
no carregamento mostra uma mensagem de erro. A forma como irá carregar o arwuivo é de
livre escolha.
- Finalizar sistema: termina a execução.
