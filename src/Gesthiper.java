
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

/**
 * Classe de interface com o Utilizador
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class Gesthiper {

    private static int linhasClientes = 0, linhasProdutos = 0, linhasCompras = 0, comprasValor0 = 0;
    private static Hipermercado hiper = new Hipermercado();
    private static GlobalStats estatisticas = new GlobalStats();
    private static ArrayList<Compra> comprasInvalidas = new ArrayList<>();
    private static Menu menuCarregamento, menuPrincipal, menuQueriesEstat, menuQueriesInter;

    /**
     * Método de Leitura de um ficheiro de Clientes
     *
     * @param filename Nome do Ficheiro
     * @throws IOException Caso o ficheiro especificado não exista
     */
    public static void leFicheiroClientes(String filename) throws IOException {
        Gesthiper.linhasClientes = 0;
        String linha;
        BufferedReader fichReader = new BufferedReader(new FileReader(filename));
        while ((linha = fichReader.readLine()) != null) {
            Gesthiper.hiper.insertCliente(linha);
            Gesthiper.linhasClientes++;
        }

    }

    /**
     * Método de Leitura de um ficheiro de Produtos
     *
     * @param filename Nome do Ficheiro
     * @throws IOException Caso o ficheiro especificado não exista
     */
    public static void leFicheiroProdutos(String filename) throws IOException {
        Gesthiper.linhasProdutos = 0;
        String linha;
        BufferedReader fichReader = new BufferedReader(new FileReader(filename));
        while ((linha = fichReader.readLine()) != null) {
            Gesthiper.hiper.insertProduto(linha);
            Gesthiper.linhasProdutos++;
        }
    }

    /**
     * Método de Leitura de um ficheiro de Compras
     *
     * @param filename Nome do Ficheiro
     * @throws IOException Caso o ficheiro especificado não exista
     * @throws MalformedCompraException Caso hajam linhas malformadas
     */
    public static void leFicheiroCompras(String filename) throws IOException, MalformedCompraException {
        String st;
        Compra c;
        Gesthiper.comprasValor0 = 0;
        Gesthiper.linhasCompras = 0;
        Gesthiper.comprasInvalidas = new ArrayList<>();
        String linha;
        BufferedReader fichReader = new BufferedReader(new FileReader(filename));
        while ((linha = fichReader.readLine()) != null) {

            c = Compra.parseCompra(linha);
            if (Gesthiper.hiper.compraValida(c)) {
                Gesthiper.hiper.registerSale(c);
            } else {
                Gesthiper.comprasInvalidas.add(c.clone());
            }
            if (c.getValorUni() == 0) {
                Gesthiper.comprasValor0++;
            }
            Gesthiper.linhasCompras++;
        }
    }

    /**
     * Método que separa uma linha do ficheiro de Compras e a separa nas várias
     * tokens
     *
     * @param st Linha a ser processada
     * @return Compra com os valores das tokens da linha processada
     */
    private static Compra linhaToCompra(String st) {
        Compra c = new Compra();
        StringTokenizer strtok = new StringTokenizer(st);
        c.setCodigoProd(strtok.nextToken());
        c.setValorUni(Float.parseFloat(strtok.nextToken()));
        c.setQuantidade(Integer.parseInt(strtok.nextToken()));
        c.setModo(strtok.nextToken().charAt(0));
        c.setCodigoCli(strtok.nextToken());
        c.setMes(Integer.parseInt(strtok.nextToken()));
        return c.clone();
    }

    /**
     * Método de leitura de strings com valor por omissão
     *
     * @param defFileName Valor por omissão
     * @return Valor inserido no teclado ou defFileName caso a String inserida
     * for vazia
     */
    private static String getFileNameWithDefault(String defFileName) {
        String input = Input.lerString();
        if (input.equals("")) {
            return defFileName;
        } else {
            return input;
        }
    }

    /**
     * Carregamento dos Menus
     */
    public static void carregaMenus() {
        String[] carregamento = {"Carregar a partir de ficheiros de texto", "Carregar a partir de ficheiro de Objectos"};
        String[] principal = {"Estatísticas da estrutura de dados", "Queries interactivas", "Guardar Estado", "Recarregar Estruturas"};
        String[] estat = {"Guardar estatísticas em ficheiro"};
        String[] inter = {"Apresentar Produtos Nunca Comprados",
            "Apresentar Clientes que Nunca registaram Compras",
            "Apresentar o total de Compras realizadas e Clientes distintos num mes",
            "Apresentar a tabela relativa a um Cliente",
            "Apresentar a tabela relativa a um Produto",
            "Consultar as vendas mensais de um Produto",
            "Consultar os Produtos mais Comprados por um Cliente",
            "Apresentar os N Produtos Mais Comprados",
            "Apresentar os N Clientes com mais Produtos distintos comprados",
            "Apresentar os Clientes que mais compraram um Produto"};
        /*Futuramente aqui serao colocados os outros*/
        Gesthiper.menuCarregamento = new Menu(carregamento);
        Gesthiper.menuPrincipal = new Menu(principal);
        Gesthiper.menuQueriesEstat = new Menu(estat);
        Gesthiper.menuQueriesInter = new Menu(inter);
    }

    /**
     * Leitura de Ficheiros
     */
    public static void LeituraFicheiros() {
        String fileCli, fileProd, fileComp;
        double tempoDecorrido;
        try {
            Gesthiper.hiper = new Hipermercado();
            System.out.println("Insira o nome de ficheiro de Clientes pretendido:<ENTER para FichClientes.txt> ");
            fileCli = Gesthiper.getFileNameWithDefault("FichClientes.txt");
            Crono.start();
            Gesthiper.leFicheiroClientes(fileCli);
            tempoDecorrido = Crono.stop();
            System.out.println("Leitura de " + Gesthiper.linhasClientes + " linhas concluída em " + tempoDecorrido + " segundos");
            System.out.println("");
            System.out.println("Insira o nome de ficheiro de Produtos pretendido:<ENTER para FichProdutos.txt> ");
            fileProd = Gesthiper.getFileNameWithDefault("FichProdutos.txt");
            Crono.start();
            Gesthiper.leFicheiroProdutos(fileProd);
            tempoDecorrido = Crono.stop();
            System.out.println("Leitura de " + Gesthiper.linhasProdutos + " linhas concluída em " + tempoDecorrido + " segundos");
            System.out.println("");
            System.out.println("Insira o nome de Ficheiro de Compras pretendido:<Enter para Compras.txt> ");
            fileComp = Gesthiper.getFileNameWithDefault("Compras.txt");
            Crono.start();
            Gesthiper.leFicheiroCompras(fileComp);
            tempoDecorrido = Crono.stop();
            System.out.println("Leitura de " + Gesthiper.linhasCompras + " linhas concluída em " + tempoDecorrido + " segundos");
            System.out.println("");
            Crono.start();
            Gesthiper.estatisticas = new GlobalStats(fileComp, fileProd, fileCli, Gesthiper.linhasProdutos, Gesthiper.linhasProdutos - Gesthiper.hiper.getProdutosNuncaComprados().size(), Gesthiper.hiper.getProdutosNuncaComprados().size(), Gesthiper.linhasClientes, Gesthiper.linhasClientes - Gesthiper.hiper.getClientesNaoCompradores().size(), Gesthiper.hiper.getClientesNaoCompradores().size(), comprasValor0, linhasCompras - Gesthiper.comprasInvalidas.size(), Gesthiper.hiper.comprasMensais(), Gesthiper.hiper.faturacaoMensal(), Gesthiper.hiper.getCompradoresMensal(), Gesthiper.comprasInvalidas, Gesthiper.comprasInvalidas.size());
            tempoDecorrido = Crono.stop();
            System.out.println("Estatísticas criadas em " + tempoDecorrido + " segundos");
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Ficheiro Não Encontrado");
        } catch (MalformedCompraException mfe) {
            System.out.println("Compra malformada");
        }
    }

    /**
     * Gravação em Ficheiro de Objectos
     */
    public static void GuardaObjecto() {
        String objFilename;
        double tempoDecorrido;
        try {
            System.out.println("Insira o nome do ficheiro a gravar:<ENTER para hipermercado.obj> ");
            objFilename = Gesthiper.getFileNameWithDefault("hipermercado.obj");
            Crono.start();
            Gesthiper.hiper.toObjFile(objFilename);
            tempoDecorrido = Crono.stop();
            System.out.println("Gravação efectuada em " + tempoDecorrido + " segundos");
        } catch (IOException ioe) {
            System.out.println("Erro no disco: " + ioe.getMessage());
        }
    }

    /**
     * Carrega a partir de Ficheiro de Objectos
     */
    public static void CarregaObjecto() {
        String objFilename;
        double tempoDecorrido;
        try {
            System.out.println("Insira o nome do Ficheiro de dados:<ENTER para hipermercado.obj>");
            objFilename = Gesthiper.getFileNameWithDefault("hipermercado.obj");
            Crono.start();
            Gesthiper.hiper = Hipermercado.readFromObjFile(objFilename);
            tempoDecorrido = Crono.stop();
            System.out.println("Carregamento efectuado em " + tempoDecorrido + " segundos");
            Crono.start();
            Gesthiper.estatisticas.setEstatEstruturas(Gesthiper.hiper.comprasMensais(), Gesthiper.hiper.faturacaoMensal(), Gesthiper.hiper.getCompradoresMensal(), Gesthiper.comprasInvalidas, Gesthiper.comprasInvalidas.size());
            tempoDecorrido = Crono.stop();
            System.out.println("Estatísticas atualizadas em " + tempoDecorrido + " segundos");
        } catch (IOException ioe) {
            System.out.println("Erro no ficheiro: " + ioe.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println("Objecto não compatível: " + cnf.getMessage());
        }
    }

    /**
     * Processamento do Menu principal
     */
    public static void processaMenuPrincipal() {
        do {
            System.out.println("************ GESTHIPER ************");
            Gesthiper.menuPrincipal.executa();
            switch (Gesthiper.menuPrincipal.getOpcao()) {
                case 1: {
                    Gesthiper.execMenuQueriesEst();
                    break;
                }
                case 2: {
                    Gesthiper.execMenuQueriesInter();
                    break;
                }
                case 3: {
                    Gesthiper.GuardaObjecto();
                    break;
                }
                case 4: {
                    Gesthiper.execMenuCarregamento();
                    break;
                }
            }
        } while (Gesthiper.menuPrincipal.getOpcao() != 0);

    }

    /**
     * Execução do Menu de Carregamento de ficheiros
     */
    public static void execMenuCarregamento() {
        Gesthiper.menuCarregamento.executa();
        switch (Gesthiper.menuCarregamento.getOpcao()) {
            case 1:
                Gesthiper.LeituraFicheiros();
                break;
            case 2:
                Gesthiper.CarregaObjecto();
                break;
            default:
                break;
        }
    }

    /**
     * Escrita das Estatísticas existentes para um ficheiro externo
     */
    public static void estatisticasToTXT() {
        String fileName;
        System.out.println("Insira o nome do ficheiro de destino:<ENTER para GHStats.stat> ");
        fileName = Gesthiper.getFileNameWithDefault("GHStats.stat");
        try {
            Gesthiper.estatisticas.toTxtFile(fileName);
        } catch (IOException ioe) {
            System.out.println("Erro no Disco: " + ioe.getMessage());
        }
    }

    /**
     * Navegação de uma lista de Strings
     *
     * @param navegador Lista a ser navegada
     */
    public static void navigate(Navigator<String> navegador) {
        char option;
        try {
            List<String> aux = navegador.getNext(Math.min(20, navegador.itemsLeft()));
            for (String str : aux) {
                System.out.println(str);
            }
            System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
            System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");

            do {
                option = Character.toUpperCase(Input.lerString().charAt(0));
                switch (option) {
                    case 'S':
                        aux = navegador.getNext(20);
                        break;
                    case 'B':
                        navegador.back(20);
                        break;

                }
                if (option == 'N') {
                    break;
                }
                for (String str : aux) {
                    System.out.println(str);
                }
                System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
                System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
                if (navegador.current() != 0) {
                    System.out.println("Insira <B> para voltar atrás");
                }
            } while (option != 'N');
        } catch (NoMoreItemsException ex) {
            System.out.println("Não há mais items");
        }

    }

    /**
     * Método de navegação sobre uma lista de Compras
     *
     * @param navegador Lista a ser navegada
     */
    public static void navigateCompras(Navigator<Compra> navegador) {
        char option;
        try {
            List<Compra> aux = navegador.getNext(Math.min(5, navegador.itemsLeft()));
            for (Compra str : aux) {
                System.out.println(str.toString());
            }
            System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
            System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");

            do {
                option = Character.toUpperCase(Input.lerString().charAt(0));
                switch (option) {
                    case 'S':
                        aux = navegador.getNext(5);
                        break;
                    case 'B':
                        navegador.back(5);
                        break;

                }
                if (option == 'N') {
                    break;
                }
                for (Compra str : aux) {
                    System.out.println(str.toString());
                }
                System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
                System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
                if (navegador.current() != 0) {
                    System.out.println("Insira <B> para voltar atrás");
                }
            } while (option != 'N');
        } catch (NoMoreItemsException ex) {
            System.out.println("Não há mais items");
        }

    }

    /**
     * Navegaçao numa lista de Pares Código Quantidade
     *
     * @param navegador Lista a ser navegada
     */
    public static void navigatePCQ(Navigator<ParCodigoQuantidade> navegador) {
        char option;
        try {
            List<ParCodigoQuantidade> aux = navegador.getNext(Math.min(20, navegador.itemsLeft()));
            for (ParCodigoQuantidade str : aux) {
                System.out.println(str.toString());
            }
            System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
            System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
            do {
                option = Character.toUpperCase(Input.lerString().charAt(0));
                switch (option) {
                    case 'S':
                        aux = navegador.getNext(20);
                        break;
                    case 'B':
                        navegador.back(20);
                        break;

                }
                for (ParCodigoQuantidade str : aux) {
                    System.out.println(str.toString());
                }
                System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
                System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
                if (navegador.current() != 0) {
                    System.out.println("Insira <B> para voltar atrás");
                }
            } while (option != 'N');
        } catch (NoMoreItemsException ex) {
            System.out.println("Não há mais items");
        }

    }

    /**
     * Navegação numa Lista de Trios Código Quantidade Número de Clientes
     *
     * @param navegador Lista a ser navegada
     */
    public static void navigateTrioCQN(Navigator<TrioCodQuantNClientes> navegador) {
        char option;
        try {
            List<TrioCodQuantNClientes> aux = navegador.getNext(Math.min(20, navegador.itemsLeft()));
            for (TrioCodQuantNClientes str : aux) {
                System.out.println(str.toString());
            }
            System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
            System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
            do {
                option = Character.toUpperCase(Input.lerString().charAt(0));
                switch (option) {
                    case 'S':
                        aux = navegador.getNext(20);
                        break;
                    case 'B':
                        navegador.back(20);
                        break;

                }
                for (TrioCodQuantNClientes str : aux) {
                    System.out.println(str.toString());
                }
                System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
                System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
                if (navegador.current() != 0) {
                    System.out.println("Insira <B> para voltar atrás");
                }
            } while (option != 'N');
        } catch (NoMoreItemsException ex) {
            System.out.println("Não há mais items");
        }

    }

    /**
     * Navegação numa Lista de Trios Código Quantidade Faturação
     *
     * @param navegador Lista a ser navegada
     */
    public static void navigateTrioCQF(Navigator<TrioCodQuantFat> navegador) {
        char option;
        try {
            List<TrioCodQuantFat> aux = navegador.getNext(Math.min(20, navegador.itemsLeft()));
            for (TrioCodQuantFat str : aux) {
                System.out.println(str.toString());
            }
            System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
            System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
            do {
                option = Character.toUpperCase(Input.lerString().charAt(0));
                switch (option) {
                    case 'S':
                        aux = navegador.getNext(20);
                        break;
                    case 'B':
                        navegador.back(20);
                        break;

                }
                for (TrioCodQuantFat str : aux) {
                    System.out.println(str.toString());
                }
                System.out.println("Items apresentados: " + navegador.current() + "/" + navegador.size());
                System.out.println("Insira <S> para obter mais items ou <N> para terminar a navegação");
                if (navegador.current() != 0) {
                    System.out.println("Insira <B> para voltar atrás");
                }
            } while (option != 'N');
        } catch (NoMoreItemsException ex) {
            System.out.println("Não há mais items");
        }

    }

    /**
     * Execução do Menu de queries Interativas
     */
    public static void execMenuQueriesInter() {
        ArrayList<String> resLista;
        ParNComprasNClientes resParCompClie;
        Table resTabl;
        Navigator<String> navegador;
        Navigator<ParCodigoQuantidade> navegPCQ;
        Navigator<TrioCodQuantFat> navegTCQF;
        Navigator<TrioCodQuantNClientes> navig;
        VendasProdutoMensais resVPM;
        ArrayList<ParCodigoQuantidade> resListaPCQ;
        ArrayList<TrioCodQuantNClientes> resTrioCQNC;
        ArrayList<TrioCodQuantFat> resTrioCQF;
        double time;
        String code;
        int nElementos, mes;
        do {
            System.out.println("************ GESTHIPER ************");
            System.out.println("------------ Queries Interactivas -----------");
            Gesthiper.menuQueriesInter.executa();
            switch (Gesthiper.menuQueriesInter.getOpcao()) {
                case 1: {
                    Crono.start();
                    resLista = Gesthiper.hiper.getProdutosNuncaComprados();
                    time = Crono.stop();
                    System.out.println("Query realizada em " + time + " segundos");
                    System.out.println("Irão ser apresentados " + resLista.size() + " códigos:");
                    navegador = new Navigator<>(resLista);
                    Gesthiper.navigate(navegador);
                    break;
                }
                case 2: {
                    Crono.start();
                    resLista = Gesthiper.hiper.getClientesNaoCompradores();
                    time = Crono.stop();
                    System.out.println("Query realizada em " + time + " segundos");
                    System.out.println("Irão ser apresentados " + resLista.size() + " códigos:");
                    navegador = new Navigator<>(resLista);
                    Gesthiper.navigate(navegador);
                    break;
                }
                case 3: {
                    System.out.println("Insira um mês (1-12):");
                    mes = Input.lerInt();
                    try {
                        Crono.start();
                        resParCompClie = Gesthiper.hiper.getTotNComprasNClientes(mes);
                        time = Crono.stop();
                        System.out.println("Query realizada em " + time + " segundos");
                        System.out.println("Total de Compras e Clientes distintos no mes " + mes);
                        System.out.println("Clientes Distintos: " + resParCompClie.getnClientes() + "\nCompras efectuadas: " + resParCompClie.getnCompras());
                        Input.lerString();
                    } catch (InvalidMonthException ime) {
                        System.out.println("Mes inválido! " + ime.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Insira um código de Cliente: ");
                    code = Input.lerString();
                    try {
                        Crono.start();
                        resTabl = Gesthiper.hiper.getTableCliente(code);
                        time = Crono.stop();
                        System.out.println("Query realizada em " + time + " segundos");
                        System.out.println(resTabl.toString());
                        Input.lerString();
                    } catch (UnexistentCodeException uce) {
                        System.out.println("Código Inexistente! " + uce.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Insira um código de Produto: ");
                    code = Input.lerString();
                    try {
                        Crono.start();
                        resTabl = Gesthiper.hiper.getTableProduto(code);
                        time = Crono.stop();
                        System.out.println("Query realizada em " + time + " segundos");
                        System.out.println(resTabl.toString());
                        Input.lerString();
                    } catch (UnexistentCodeException uce) {
                        System.out.println("Código Inexistente! " + uce.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println("Insira um código de Produto: ");
                    code = Input.lerString();
                    try {
                        Crono.start();
                        resVPM = Gesthiper.hiper.getVendasMensais(code);
                        time = Crono.stop();
                        System.out.println("Query realizada em " + time + " segundos");
                        System.out.println(resVPM.toString());
                        Input.lerString();
                    } catch (UnexistentCodeException uce) {
                        System.out.println("Código Inexistente! " + uce.getMessage());
                    }
                    break;
                }
                case 7: {
                    System.out.println("Insira um código de Cliente: ");
                    code = Input.lerString();
                    try {
                        Crono.start();
                        resListaPCQ = Gesthiper.hiper.getTopCompras(code);
                        time = Crono.stop();
                        System.out.println("Query realizada em " + time + " segundos");
                        navegPCQ = new Navigator<>(resListaPCQ);
                        Gesthiper.navigatePCQ(navegPCQ);
                    } catch (UnexistentCodeException uce) {
                        System.out.println("Código Inexistente! " + uce.getMessage());
                    }
                    break;
                }
                case 8: {
                    System.out.println("Insira o número de Elementos a apresentar");
                    nElementos = Input.lerInt();
                    Crono.start();
                    resTrioCQNC = Gesthiper.hiper.getTopComprados(nElementos);
                    time = Crono.stop();
                    System.out.println("Query realizada em " + time + " segundos");
                    navig = new Navigator<>(resTrioCQNC);
                    Gesthiper.navigateTrioCQN(navig);
                    break;
                }
                case 9: {
                    System.out.println("Insira o número de Elementos a apresentar");
                    nElementos = Input.lerInt();
                    Crono.start();
                    resListaPCQ = Gesthiper.hiper.getClientesMaisProdutosDistintos(nElementos);
                    time = Crono.stop();
                    System.out.println("Query realizada em " + time + " segundos");
                    navegPCQ = new Navigator<>(resListaPCQ);
                    Gesthiper.navigatePCQ(navegPCQ);
                    break;
                }
                case 10: {
                    System.out.println("Insira um código de Produto: ");
                    code = Input.lerString();
                    try {
                        Crono.start();
                        resTrioCQF = Gesthiper.hiper.getTopCompradores(code);
                        time = Crono.stop();
                        System.out.println("Query realizada em " + time + " segundos");
                        navegTCQF = new Navigator<>(resTrioCQF);
                        Gesthiper.navigateTrioCQF(navegTCQF);
                    } catch (UnexistentCodeException uce) {
                        System.out.println("Código Inexistente! " + uce.getMessage());
                    }
                    break;
                }
            }
        } while (Gesthiper.menuQueriesInter.getOpcao() != 0);
    }

    /**
     * Execução do menu de Queries Estatísticas
     */
    public static void execMenuQueriesEst() {

        do {
            System.out.println("************ GESTHIPER ************");
            System.out.println("------------ Queries Estatísticas -----------");
            System.out.println(Gesthiper.estatisticas.getEstatFicheiro().toString());
            Input.lerString();
            System.out.println(Gesthiper.estatisticas.getEstatEstrutura().toString());
            Input.lerString();
            Navigator<Compra> navegador = new Navigator<>(Gesthiper.estatisticas.getEstatEstrutura().getComprasInvalidas());
            Gesthiper.navigateCompras(navegador);
            Gesthiper.menuQueriesEstat.executa();
            switch (Gesthiper.menuQueriesEstat.getOpcao()) {
                case 1:
                    Gesthiper.estatisticasToTXT();
            }
        } while (Gesthiper.menuQueriesEstat.getOpcao() != 0);
    }

    /**
     * Método Main
     *
     * @param args Argumentos passados na linha de comando (não serão
     * utilizados)
     */
    public static void main(String[] args) {
        Gesthiper.carregaMenus();
        Gesthiper.execMenuCarregamento();
        if (Gesthiper.menuCarregamento.getOpcao() != 0) {
            Gesthiper.processaMenuPrincipal();
        }

    }
}
