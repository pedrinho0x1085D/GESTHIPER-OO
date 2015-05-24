
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
        /*Futuramente aqui serao colocados os outros*/
        Gesthiper.menuCarregamento = new Menu(carregamento);
    }

    public static void LeituraFicheiros() {
        String fileCli, fileProd, fileComp;
        try {
            Gesthiper.hiper = new Hipermercado();
            System.out.println("Insira o nome de ficheiro de Clientes pretendido:<ENTER para FichClientes.txt> ");
            fileCli = Gesthiper.getFileNameWithDefault("FichClientes.txt");
            Gesthiper.leFicheiroClientes(fileCli);
            System.out.println("Insira o nome de ficheiro de Produtos pretendido:<ENTER para FichProdutos.txt> ");
            fileProd = Gesthiper.getFileNameWithDefault("FichProdutos.txt");
            Gesthiper.leFicheiroProdutos(fileProd);
            System.out.println("Insira o nome de Ficheiro de Compras pretendido:<Enter para FichCompras.txt> ");
            fileComp = Gesthiper.getFileNameWithDefault("FichCompras.txt");
            Gesthiper.leFicheiroCompras(fileComp);
            Gesthiper.estatisticas = new GlobalStats(fileComp, fileProd, fileCli, Gesthiper.linhasProdutos, Gesthiper.linhasProdutos - Gesthiper.hiper.getProdutosNuncaComprados().size(), Gesthiper.hiper.getProdutosNuncaComprados().size(), Gesthiper.linhasClientes, Gesthiper.linhasClientes - Gesthiper.hiper.getClientesNaoCompradores().size(), Gesthiper.hiper.getClientesNaoCompradores().size(), comprasValor0, linhasCompras - Gesthiper.comprasInvalidas.size(), Gesthiper.hiper.comprasMensais(), Gesthiper.hiper.faturacaoMensal(), Gesthiper.hiper.getCompradoresMensal(), Gesthiper.comprasInvalidas, Gesthiper.comprasInvalidas.size());
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro Não Encontrado");
        }
    }

    public static void GuardaObjecto() {
        String objFilename;
        try {
            System.out.println("Insira o nome do ficheiro a gravar:<ENTER para hipermercado.obj> ");
            objFilename = Gesthiper.getFileNameWithDefault("hipermercado.obj");
            Gesthiper.hiper.toObjFile(objFilename);
        } catch (IOException ioe) {
            System.out.println("Erro no disco: " + ioe.getMessage());
        }
    }

    public static void CarregaObjecto() {
        String objFilename;
        try {
            System.out.println("Insira o nome do Ficheiro de dados:<ENTER para hipermercado.obj>");
            objFilename = Gesthiper.getFileNameWithDefault("hipermercado.obj");
            Gesthiper.hiper = Hipermercado.readFromObjFile(objFilename);
            Gesthiper.estatisticas.setEstatEstruturas(Gesthiper.hiper.comprasMensais(), Gesthiper.hiper.faturacaoMensal(), Gesthiper.hiper.getCompradoresMensal(), Gesthiper.comprasInvalidas, Gesthiper.comprasInvalidas.size());
        } catch (IOException ioe) {
            System.out.println("Erro no ficheiro: " + ioe.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println("Objecto não compatível: " + cnf.getMessage());
        }
    }

    public static void main(String[] args) {
        Gesthiper.carregaMenus();
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
        if (Gesthiper.menuCarregamento.getOpcao() != 0) {
                //Menu principal;
        }

    }
}
