
import java.io.Serializable;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class NodoClienteComprador implements Serializable{
    private String codigoC;
    private int qtdCompradaN[],qtdCompradaP[];
    private float valorN[],valorP[];

    public NodoClienteComprador() {
    this.codigoC="";
    this.qtdCompradaN=new int[12];
    this.qtdCompradaP=new int[12];
    this.valorN=new float[12];
    this.valorP=new float[12];
    }

    public NodoClienteComprador(String codigoC, int[] qtdCompradaN, int[] qtdCompradaP, float[] valorN, float[] valorP) {
        this.codigoC = codigoC;
        this.qtdCompradaN = qtdCompradaN;
        this.qtdCompradaP = qtdCompradaP;
        this.valorN = valorN;
        this.valorP = valorP;
    }
    
    public NodoClienteComprador(NodoClienteComprador ncc){
        this.codigoC=ncc.getCodigoC();
        this.qtdCompradaN=ncc.getQtdCompradaN();
        this.qtdCompradaP=ncc.getQtdCompradaP();
        this.valorN=ncc.getValorN();
        this.valorP=ncc.getValorP();
    }

    
    public String getCodigoC() {
        return this.codigoC;
    }

    public int[] getQtdCompradaN() {
        return this.qtdCompradaN.clone();
    }

    public int[] getQtdCompradaP() {
        return this.qtdCompradaP.clone();
    }

    public float[] getValorN() {
        return this.valorN.clone();
    }

    public float[] getValorP() {
        return this.valorP.clone();
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public void setQtdCompradaN(int[] qtdCompradaN) {
        this.qtdCompradaN = qtdCompradaN.clone();
    }

    public void setQtdCompradaP(int[] qtdCompradaP) {
        this.qtdCompradaP = qtdCompradaP.clone();
    }

    public void setValorN(float[] valorN) {
        this.valorN = valorN.clone();
    }

    public void setValorP(float[] valorP) {
        this.valorP = valorP.clone();
    }
    
    public int getQuantidadeTotal(){
        int total=0;
        for(int i=0;i<12;i++){
            total+=this.qtdCompradaN[i];
            total+=this.qtdCompradaP[i];
        }
        return total;
    }
    
    public float getFaturacaoTotal(){
        float total=0;
        for(int i=0;i<12;i++){
            total+=this.valorN[i];
            total+=this.valorP[i];
        }
        return total;
    }
    
    public int getCompraMes(char modo, int mes){
        if(modo=='P') return this.qtdCompradaP[mes-1];
        else if(modo=='N') return this.qtdCompradaN[mes-1];
        else return 0;
    }
    
    public float getFaturacaoMes(char modo, int mes){
        if(modo=='P') return this.valorP[mes-1];
        else if(modo=='N') return this.valorN[mes-1];
        else return 0;
    }
    
    public void incrementaValor(char modo,int mes,int qtd,float valor){
        if(modo=='P') {this.valorP[mes-1]+=qtd*valor;}
        else if(modo=='N') {this.valorN[mes-1]+=qtd*valor;}
    }
    public void incrementaQtd(char modo, int mes,int qtd){
        if(modo=='P') {this.qtdCompradaP[mes-1]+=qtd;}
        else if(modo=='N') {this.qtdCompradaN[mes-1]+=qtd;}
    }
    
    
    /*Equals toString*/
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigoC,this.qtdCompradaN,this.qtdCompradaP,this.valorN,this.valorP});
    }
    
    @Override
    public NodoClienteComprador clone(){
        return new NodoClienteComprador(this);
    }
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        NodoClienteComprador e = (NodoClienteComprador) obj;
        return (this.codigoC.equals(e.getCodigoC()) && this.qtdCompradaN.equals(e.getQtdCompradaN()) && this.qtdCompradaP.equals(e.getQtdCompradaP()) && this.valorN.equals(e.getValorN()) && this.valorP.equals(e.getValorP()));
    }
}
