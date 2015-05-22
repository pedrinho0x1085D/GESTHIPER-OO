
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
public class FileStats {
    private String filenameComp,filenameProd,filenameCli;
    private int nProds,prodsComp,prodsNComp;
    private int nClientes,nClientesCompradores,nClientesNaoCompraram;
    private int comprasValor0;
    private float faturacaoTotal;
    private int comprasMes[];
    private float faturacaoMensal[];
    private int clientesCompradoresMensal[];
    private ArrayList<Compra> comprasInvalidas;
    private int nComprasInvalidas;
    
    public FileStats(){
        this.filenameComp = "";
        this.filenameProd = "";
        this.filenameCli = "";
        this.nProds = 0;
        this.prodsComp = 0;
        this.prodsNComp = 0;
        this.nClientes = 0;
        this.nClientesCompradores = 0;
        this.nClientesNaoCompraram = 0;
        this.comprasValor0 = 0;
        this.faturacaoTotal = 0;
        this.comprasMes = new int[12];
        this.faturacaoMensal = new float[12];
        this.clientesCompradoresMensal = new int[12];
        this.comprasInvalidas = new ArrayList<>();
        this.nComprasInvalidas = 0;
    }

    public FileStats(String filenameComp, String filenameProd, String filenameCli, int nProds, int prodsComp, int prodsNComp, int nClientes, int nClientesCompradores, int nClientesNaoCompraram, int comprasValor0, float faturacaoTotal, int[] comprasMes, float[] faturacaoMensal, int[] clientesCompradoresMensal, ArrayList<Compra> comprasInvalidas, int nComprasInvalidas) {
        this.filenameComp = filenameComp;
        this.filenameProd = filenameProd;
        this.filenameCli = filenameCli;
        this.nProds = nProds;
        this.prodsComp = prodsComp;
        this.prodsNComp = prodsNComp;
        this.nClientes = nClientes;
        this.nClientesCompradores = nClientesCompradores;
        this.nClientesNaoCompraram = nClientesNaoCompraram;
        this.comprasValor0 = comprasValor0;
        this.faturacaoTotal = faturacaoTotal;
        this.comprasMes = comprasMes;
        this.faturacaoMensal = faturacaoMensal;
        this.clientesCompradoresMensal = clientesCompradoresMensal;
        this.comprasInvalidas = new ArrayList<>();
        for(Compra c:comprasInvalidas)
            this.comprasInvalidas.add(c.clone());
        this.nComprasInvalidas = nComprasInvalidas;
    }

    public int[] getClientesCompradoresMensal() {
        return this.clientesCompradoresMensal.clone();
    }

    public ArrayList<Compra> getComprasInvalidas() {
        ArrayList<Compra> res=new ArrayList<>();
        for(Compra c:this.comprasInvalidas)
            res.add(c.clone());
        return res;
    }

    public int[] getComprasMes() {
        return this.comprasMes.clone();
    }

    public int getComprasValor0() {
        return this.comprasValor0;
    }

    public float[] getFaturacaoMensal() {
        return this.faturacaoMensal.clone();
    }

    public float getFaturacaoTotal() {
        return this.faturacaoTotal;
    }

    public String getFilenameCli() {
        return this.filenameCli;
    }

    public String getFilenameComp() {
        return this.filenameComp;
    }

    public String getFilenameProd() {
        return this.filenameProd;
    }

    public int getProdsComp() {
        return this.prodsComp;
    }

    public int getProdsNComp() {
        return this.prodsNComp;
    }

    public int getnClientes() {
        return this.nClientes;
    }

    public int getnClientesCompradores() {
        return this.nClientesCompradores;
    }

    public int getnClientesNaoCompraram() {
        return this.nClientesNaoCompraram;
    }

    public int getnComprasInvalidas() {
        return this.nComprasInvalidas;
    }

    public void setClientesCompradoresMensal(int[] clientesCompradoresMensal) {
        this.clientesCompradoresMensal = clientesCompradoresMensal.clone();
    }

    public void setComprasInvalidas(ArrayList<Compra> comprasInvalidas) {
        this.comprasInvalidas = new ArrayList<>();
        for(Compra c:comprasInvalidas)
            this.comprasInvalidas.add(c.clone());
        
    }

    public void setComprasMes(int[] comprasMes) {
        this.comprasMes = comprasMes.clone();
    }

    public void setComprasValor0(int comprasValor0) {
        this.comprasValor0 = comprasValor0;
    }

    public void setFaturacaoMensal(float[] faturacaoMensal) {
        this.faturacaoMensal = faturacaoMensal.clone();
    }

    public void setFaturacaoTotal(float faturacaoTotal) {
        this.faturacaoTotal = faturacaoTotal;
    }

    public void setFilenameCli(String filenameCli) {
        this.filenameCli = filenameCli;
    }

    public void setFilenameComp(String filenameComp) {
        this.filenameComp = filenameComp;
    }

    public void setFilenameProd(String filenameProd) {
        this.filenameProd = filenameProd;
    }

    public void setProdsNComp(int prodsNComp) {
        this.prodsNComp = prodsNComp;
    }

    public void setProdsComp(int prodsComp) {
        this.prodsComp = prodsComp;
    }

    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    public void setnClientesCompradores(int nClientesCompradores) {
        this.nClientesCompradores = nClientesCompradores;
    }

    public void setnClientesNaoCompraram(int nClientesNaoCompraram) {
        this.nClientesNaoCompraram = nClientesNaoCompraram;
    }

    public void setnComprasInvalidas(int nComprasInvalidas) {
        this.nComprasInvalidas = nComprasInvalidas;
    }

    public void setnProds(int nProds) {
        this.nProds = nProds;
    }
    
    public FileStats clone(){
            return new FileStats(this.filenameComp, this.filenameProd, this.filenameCli, this.nProds, this.prodsComp, this.prodsNComp, this.nClientes, this.nClientesCompradores, this.nClientesNaoCompraram, this.comprasValor0, this.faturacaoTotal, this.comprasMes.clone(), this.faturacaoMensal.clone(), this.clientesCompradoresMensal.clone(), this.comprasInvalidas, nComprasInvalidas);
    }
    
    
}
