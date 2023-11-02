# POO
Instruções para commit
Utilizar a convenção de commit-lint: https://github.com/conventional-changelog/commitlint/tree/master/@commitlint/config-conventional#type-enum

Inclusão de nova funcionalidade: git commit -m "feat: adicionado feature de login"

Correção de bug: git commit -m "fix: corrigido bug de login"

Instruções para criação de branches
Utilizar a convenção de branches:

Nova feature: feature/nome-da-feature

Correção de bug: fix/nome-do-bug

# DESCR
Caminhões (frota): cada um possui código, nome único, autonomia e o valor do custo por km rodado.
- Destino: possui um código, um nome e a cidade.
- Cliente: possui um código, um nome e um número de telefone.
- Carga: um código único, tipo de carga, local de origem, local de destino, cliente, peso (toneladas), o
valor declarado pelo cliente e o tempo máximo (em dias) para o frete.
- Tipo de carga: possui numero e descrição (Perecível: possui uma origem (String) e um tempo máximo
de validade (int); Durável: que possui um setor (String) e o material principal (String).
- Possíveis situações da carga: Pendente, Locada, Cancelada, Finalizada. Ao ser cadastrada uma carga fica
na situação Pendente; definindo um caminhão para a carga muda para a situação: Locada; carga foi
entregue a situação muda para finalizada (liberando o caminhão). Para uma carga não atendida, a
situação é cancelada.
- O cálculo do valor de um frete = PRECO POR DISTANCIA+ PRECO POR PESO
- O preço por distância = ΔDISTANCIA (destino-origem ) X Custo por Km
- O preço por peso depende do tipo da carga: PERECIVEL, é: Peso x2; DURÁVEL, é: peso x 1,5.
