
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Cunha
 */
public class Gesthiper {

    private static int linhasClientes = 0, linhasProdutos = 0, linhasCompras = 0, comprasValor0 = 0;
    private static Hipermercado hiper = new Hipermercado();
    private static GlobalStats estatisticas = new GlobalStats();
    private static ArrayList<Compra> comprasInvalidas = new ArrayList<>();
    private static Menu menuCarregamento, menuPrincipal, menuQueriesEstat, menuQueriesInter;

    public static void leFicheiroClientes(String filename) throws FileNotFoundException {
        Gesthiper.linhasClientes = 0;
        Scanner fichScan = new Scanner(new FileReader(filename));
        fichScan.useDelimiter(System.getProperty("line.separator"));
        while (fichScan.hasNext()) {
            Gesthiper.hiper.insertCliente(fichScan.next());
            Gesthiper.linhasClientes++;
        }

    }

    public static void leFicheiroProdutos(String filename) throws FileNotFoundException {
        Gesthiper.linhasProdutos = 0;
        Scanner fichScan = new Scanner(new FileReader(filename));
        fichScan.useDelimiter(System.getProperty("line.separator"));
        while (fichScan.hasNext()) {
            Gesthiper.hiper.insertProduto(fichScan.next());
            Gesthiper.linhasProdutos++;
        }
    }

    public static void leFicheiroCompras(String filename) throws FileNotFoundException {
        String st;
        Compra c;
        Gesthiper.comprasValor0 = 0;
        Gesthiper.linhasCompras = 0;
        Gesthiper.comprasInvalidas = new ArrayList<>();
        Scanner fichScan = new Scanner(new FileReader(filename));
        fichScan.useDelimiter(System.getProperty("line.separator"));
        while (fichScan.hasNext()) {
            st = fichScan.next();
            c = Gesthiper.linhaToCompra(st);
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

    private static String getFileNameWithDefault(String defFileName) {
        String input = Input.lerString();
        if (input.equals("")) {
            return defFileName;
        } else {
            return input;
        }
    }

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
            System.out.println("Insira o nome de Ficheiro de Compras pretendido:<Enter para FichCompras.txt> ");
            fileComp = Gesthiper.getFileNameWithDefault("FichCompras.txt");
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
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro Não Encontrado");
        }
    }

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

    public static void execMenuQueriesInter() {
        System.out.println("************ GESTHIPER ************");
        System.out.println("------------ Queries Interactivas -----------");
        Gesthiper.menuQueriesInter.executa();
        do {
            switch (Gesthiper.menuQueriesInter.getOpcao()) {
                case 1:{}
                case 2:{}
                case 3:{}
                case 4:{}
                case 5:{}
                case 6:{}
                case 7:{}
                case 8:{}
                case 9:{}
                case 10:{}
            }
        } while (Gesthiper.menuQueriesInter.getOpcao() != 0);
    }

    public static void execMenuQueriesEst() {
        System.out.println("************ GESTHIPER ************");
        System.out.println("------------ Queries Estatísticas -----------");
        System.out.println(Gesthiper.estatisticas.toString());
        Gesthiper.menuQueriesEstat.executa();
        do {
            switch (Gesthiper.menuQueriesEstat.getOpcao()) {
                case 1:
                    Gesthiper.estatisticasToTXT();
            }
        } while (Gesthiper.menuQueriesEstat.getOpcao() != 0);
    }

    public static void main(String[] args) {
        Gesthiper.carregaMenus();
        Gesthiper.execMenuCarregamento();
        if (Gesthiper.menuCarregamento.getOpcao() != 0) {
            Gesthiper.processaMenuPrincipal();
        }

    }
}
