
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
public class NodoProdutoComprado implements Serializable{
    private String codigoP;
    private int qtdCompN[],qtdCompP[];
    private float valorN[],valorP[];
    
    public NodoProdutoComprado(){
        this.codigoP="";
        this.qtdCompN=new int[12];
        this.qtdCompP=new int[12];
        this.valorN=new float[12];
        this.valorP=new float[12];
        
    }
    
    public NodoProdutoComprado(String codigoP){
        this.codigoP=codigoP;
        this.qtdCompN=new int[12];
        this.qtdCompP=new int[12];
        this.valorN=new float[12];
        this.valorP=new float[12];
        
    }
    public NodoProdutoComprado(NodoProdutoComprado npc){
        this.codigoP=npc.getCodigoP();
        this.qtdCompN=npc.getQtdCompN();
        this.qtdCompP=npc.getQtdCompP();
        this.valorN=npc.getValorN();
        this.valorP=npc.getValorP();
    }

    public String getCodigoP() {
        return this.codigoP;
    }

    public int[] getQtdCompN() {
        return this.qtdCompN.clone();
    }

    public int[] getQtdCompP() {
        return this.qtdCompP.clone();
    }

    public float[] getValorN() {
        return this.valorN.clone();
    }

    public float[] getValorP() {
        return this.valorP.clone();
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public void setQtdCompN(int[] qtdCompN) {
        this.qtdCompN = qtdCompN.clone();
    }

    public void setQtdCompP(int[] qtdCompP) {
        this.qtdCompP = qtdCompP.clone();
    }

    public void setValorN(float[] valorN) {
        this.valorN = valorN.clone();
    }

    public void setValorP(float[] valorP) {
        this.valorP = valorP.clone();
    }
    
    public int getQtdCompMes(char modo, int mes){
        if(modo=='P') return this.qtdCompP[mes-1];
        else if(modo=='N') return this.qtdCompN[mes-1];
        else return 0;
    }
    
    public float getValorMes(char modo, int mes){
        if(modo=='P') return this.valorP[mes-1];
        else if(modo=='N') return this.valorN[mes-1];
        else return 0;
    }
    
    public void incrementaQuantidade(char modo,int mes,int qtd){
        if(modo=='P') this.qtdCompP[mes-1]+=qtd;
        else if(modo=='N') this.qtdCompN[mes-1]+=qtd;
    }
    
    public void incrementaValor(char modo, int mes, float valorUni,int qtd){
        if(modo=='P') this.valorP[mes-1]+=(qtd*valorUni);
        else if(modo=='N') this.valorN[mes-1]+=(qtd*valorUni);
    }
    
    public NodoProdutoComprado clone(){
        return new NodoProdutoComprado(this);
    }
    
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigoP,this.qtdCompN,this.qtdCompP,this.valorN,this.valorP});
    }
    
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        NodoProdutoComprado e = (NodoProdutoComprado) obj;
        return (this.codigoP.equals(e.getCodigoP()) && this.qtdCompN.equals(e.getQtdCompN()) && this.qtdCompP.equals(e.getQtdCompP()) && this.valorN.equals(e.getValorN()) && this.valorP.equals(e.getValorP()));
    }
}
