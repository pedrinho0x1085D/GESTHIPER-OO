
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class NodoCliente {
    private String codigoC;
    private int compraMes[];
    private int nCompras;
    private HashMap<String,NodoProdutoComprado> prodComprados;

    public NodoCliente(String codigoC, int[] compraMes, int nCompras) {
        this.codigoC = codigoC;
        this.compraMes = compraMes;
        this.nCompras = nCompras;
        this.prodComprados=new HashMap<>();
    }
    
    public NodoCliente(String codigoC){
        this.codigoC=codigoC;
        this.compraMes=new int[12];
        this.nCompras=0;
        this.prodComprados=new HashMap<>();
    }

    public String getCodigoC() {
        return this.codigoC;
    }

    public int[] getCompraMes() {
        return this.compraMes;
    }

    public int getnCompras() {
        return this.nCompras;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public void setCompraMes(int[] compraMes) {
        this.compraMes = compraMes;
    }

    public void setnCompras(int nCompras) {
        this.nCompras = nCompras;
    }
    
    
    
    
}
