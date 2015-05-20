
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private static int linhasClientes,linhasProdutos,linhasCompras;
    private static Hipermercado hiper;
    private static ArrayList<Compra> comprasInvalidas=new ArrayList<>();
    private static Menu menuCarregamento,menuPrincipal,menuQueriesEstat,menuQueriesInter;
    
    public void leFicheiroClientes(String filename) throws FileNotFoundException {
        Gesthiper.linhasClientes=0;
        Scanner fichScan = new Scanner(new FileReader(filename));
        fichScan.useDelimiter(System.getProperty("line.separator"));
        while (fichScan.hasNext()) {
            Gesthiper.hiper.insertCliente(fichScan.next());
            Gesthiper.linhasClientes++;
        }
        
    }
    
    public void leFicheiroProdutos(String filename) throws FileNotFoundException {
        Gesthiper.linhasProdutos=0;
        Scanner fichScan = new Scanner(new FileReader(filename));
        fichScan.useDelimiter(System.getProperty("line.separator"));
        while (fichScan.hasNext()) {
            Gesthiper.hiper.insertProduto(fichScan.next());
            Gesthiper.linhasProdutos++;
        }
    }
    
    public void leFicheiroCompras(String filename) throws FileNotFoundException {
        String st;
        Compra c;
        Gesthiper.comprasInvalidas=new ArrayList<>();
        Scanner fichScan = new Scanner(new FileReader(filename));
        fichScan.useDelimiter(System.getProperty("line.separator"));
        while (fichScan.hasNext()) {
            st = fichScan.next();
            c = linhaToCompra(st);
            if (Gesthiper.hiper.compraValida(c)) {
                Gesthiper.hiper.registerSale(c);
            } else {
                Gesthiper.comprasInvalidas.add(c.clone());
            }
            Gesthiper.linhasCompras++;
        }
    }
    
    private Compra linhaToCompra(String st) {
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
    
    private String getFileNameWithDefault(String defFileName){
        String input=Input.lerString();
        if(input.equals("")) return defFileName;
        else return input;
    }
    
    public static void carregaMenus(){
        String[] carregamento={ "Carregar Ficheiro de Clientes",
                                "Carregar Ficheiro de Produtos",
                                "Carregar Ficheiro de Compras"};
        /*Futuramente aqui serao colocados os outros*/
        Gesthiper.menuCarregamento=new Menu(carregamento);
    }
    
    public static void main(String[] args) {
        
        
    }
}
