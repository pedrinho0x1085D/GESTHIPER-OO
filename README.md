# GESTHIPER-OO
Repositório do Projeto de Java da Unidade Curricular de Laboratórios de Informática III

Linguagem a utilizar:Java

Resumo do trabalho a realizar:

Pretende-se desenvolver um programa em Java que seja capaz de, antes de mais, ler
e armazenar em estruturas de dados (coleccções de Java) adequadas as informações
dos vários ficheiros, para que, posteriormente, possam ser realizadas diversas
consultas (“queries”), algumas estatísticas e alguns testes de “performance”.

##Melhorias a realizar:

--> Melhorar a apresentação das queries; (Não totalmente completa mas melhorada)

--> Permitir ao utilizador selecionar o tamanho da "página" a apresentar;

--> Separar o código em packages para separar as camadas do programa. (Feito)


###Classificação: 13/20

##Detalhes do Programa:
1. Carregamento dos dados

Os dados necessários para que possamos utilizar a aplicação podem provir de duas fontes:

* Ficheiros de Texto (Registos de Clientes, Produtos e Compras)
* Ficheiros de objectos.

  **1.1.** Menu de carregamento:

![alt text](http://i.imgur.com/wzC61qO.png "Menu de Carregamento")

Ao carregar os dados a partir de ficheiros de texto irá ser apresentado o seguinte ecrã:

![alt text](http://i.imgur.com/TIx8TJE.png "Carregamento de Ficheiros")

Existem nomes por omissão para cada um dos tipos de ficheiro. Será também apresentado o tempo de leitura, tokenizing e carregamento para as estruturas, como se pode ver acima.
2. Utilização do programa:
  **2.1.** Menu principal:
  
![alt text](http://i.imgur.com/wXshYP9.png "Menu Principal")

Aqui o utilizador pode consultar dados estatísticos dos ficheiros lidos bem como dados quantitativos da estrutura de dados. Para além disto também dispõe de 10 queries diferentes à estrutura de dados. Finalmente pode guardar o estado actual da estrutura e recarregar os dados do programa (Regressará ao menu em 1.1.).

  **2.2.** Dados Estatísticos:
  
Será apresentado ao utilizador em três secções sequenciais:
* Estatísticas de Ficheiro

![alt text](http://i.imgur.com/SxozWVu.png "Estatísticas dos últimos ficheiros lidos") 

* Estatísticas da Estrutura
 
![alt text](http://i.imgur.com/oLAlOII.png "Estatísticas da estrutura de dados")

* Lista de Compras Inválidas, em que permite-se ao utilizador navegar, apresentando 5 a 5 enquanto o utilizador pretender visualizar as compras que não passaram nos testes de validação

![alt text](http://i.imgur.com/qbnlhS8.png "Estatísticas da estrutura de dados")

 **2.3.** Queries Interactivas:

As queries interactivas têm o seguinte Menu:

![alt text](http://i.imgur.com/k1xssNU.png "Menu Queries Interactivas")

Por omissão deverá ser apresentado o tempo de procura dos dados para a resposta à query previamente à apresentação da mesma.

* Query 1 - Não serão pedidos quaisquer parâmetros ao utilizador; Apresenta a lista de códigos de produto que não têm registadas quaisquer compras.
* Query 2 - Não serão pedidos quaisquer parâmetros ao utilizador; Apresenta a lista de códigos de cliente que não têm registadas quaisquer compras.
* Query 3 - É pedido o mês para apresentar as compras realizadas e clientes compradores distintos nesse mesmo mês.
* Query 4 - Tabela para um cliente (Produtos distintos, Faturação e Compras).
* Query 5 - Tabela para um produto (Clientes distintos, Faturação e Compras).
* Query 6 - Vendas mensais de um produto.
* Query 7 - Apresentar os Produtos mais comprados por um cliente.
* Query 8 - Apresentar os Produtos mais comprados no Ano.
* Query 9 - Apresentar os Clientes com mais Produtos distintos comprados.
* Query 10 - Apresentar os Clientes que mais compraram um dado Produto.

  

