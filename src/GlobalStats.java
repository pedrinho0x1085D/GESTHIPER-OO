
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Cunha
 */
public class GlobalStats {

    private FileStats ficheiro;
    private StructureStats estrutura;

    public GlobalStats() {
        this.ficheiro = new FileStats();
        this.estrutura = new StructureStats();
    }

    public GlobalStats(String filenameComp, String filenameProd, String filenameCli, int nProds, int prodsComp, int prodsNComp, int nClientes, int nClientesCompradores, int nClientesNaoCompraram, int comprasValor0, float faturacaoTotal, int[] comprasMes, float[] faturacaoMensal, int[] clientesCompradoresMensal, ArrayList<Compra> comprasInvalidas, int nComprasInvalidas) {
        this.ficheiro = new FileStats(filenameComp, filenameProd, filenameCli, nProds, prodsComp, prodsNComp, nClientes, nClientesCompradores, nClientesNaoCompraram, comprasValor0, faturacaoTotal);
        this.estrutura = new StructureStats(comprasMes, faturacaoMensal, clientesCompradoresMensal, comprasInvalidas, nComprasInvalidas);
    }

    public FileStats getEstatFicheiro() {
        return this.ficheiro.clone();
    }

    public StructureStats getEstatEstrutura() {
        return this.estrutura.clone();
    }

    public void setEstatFicheiro(String filenameComp, String filenameProd, String filenameCli, int nProds, int prodsComp, int prodsNComp, int nClientes, int nClientesCompradores, int nClientesNaoCompraram, int comprasValor0, float faturacaoTotal) {
        this.ficheiro = new FileStats(filenameComp, filenameProd, filenameCli, nProds, prodsComp, prodsNComp, nClientes, nClientesCompradores, nClientesNaoCompraram, comprasValor0, faturacaoTotal);
    }

    public void setEstatEstruturas(int[] comprasMes, float[] faturacaoMensal, int[] clientesCompradoresMensal, ArrayList<Compra> comprasInvalidas, int nComprasInvalidas) {
        this.estrutura = new StructureStats(comprasMes, faturacaoMensal, clientesCompradoresMensal, comprasInvalidas, nComprasInvalidas);
    }

    public void toTxtFile(String filename){
        try{
        FileWriter fw=new FileWriter(filename);
        fw.write("--------------Estatísticas de Ficheiro----------------\n");
        fw.write("Ficheiro de Clientes: "+this.ficheiro.getFilenameCli()+"\n");
        fw.write("Ficheiro de Produtos: "+this.ficheiro.getFilenameProd()+"\n");
        fw.write("Ficheiro de Compras: "+this.ficheiro.getFilenameComp()+"\n");
        fw.write("Número de Linhas de Clientes: "+this.ficheiro.getnClientes()+"\n");
        fw.write("Dos quais\n");
        fw.write("\t"+this.ficheiro.getnClientesCompradores()+" clientes realizaram compras\n");
        fw.write("\t"+this.ficheiro.getnClientesNaoCompraram()+" clientes não realizaram compras\n");
        fw.write("Número de Linhas de Produtos: "+this.ficheiro.getnProds()+"\n");
        fw.write("Dos quais\n");
        fw.write("\t"+this.ficheiro.getProdsComp()+" produtos foram comprados\n");
        fw.write("\t"+this.ficheiro.getProdsNComp()+" produtos não foram comprados\n");
        fw.write("Compras com valor 0: "+this.ficheiro.getComprasValor0()+"\n");
        fw.write("Faturação total: "+this.ficheiro.getFaturacaoTotal()+"€\n");
        fw.write("--------------Estatísticas de Estruturas----------------\n");
        fw.write("Faturação Mensal: \n");
        for(int i=0;i<12;i++){
            fw.write(" "+ this.estrutura.getFaturacaoMensal()[i]);
        }
        fw.write("\n");
        fw.write("Clientes Compradores por Mês: \n");
        for(int i=0;i<12;i++){
            fw.write(" "+ this.estrutura.getClientesCompradoresMensal()[i]);
        }
        fw.write("\n");
        fw.write("Compras Realizadas por Mês: \n");
        for(int i=0;i<12;i++){
            fw.write(" "+ this.estrutura.getComprasMes()[i]);
        }
        fw.write("\n");
        fw.write("As seguintes "+this.estrutura.getnComprasInvalidas()+"não foram validadas: \n");
        for(Compra c:this.estrutura.getComprasInvalidas())
            fw.write(c.toString());
        fw.flush();
        fw.close();
        }
        catch(IOException fnf){System.out.println("Erro no Disco: "+fnf.getMessage());}
    }
}
