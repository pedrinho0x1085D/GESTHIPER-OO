
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
public class VendasProdutoMensais {

    private String codigoP;
    private int vendasN[], vendasP[];
    private float fatN[], fatP[];

    public VendasProdutoMensais() {
        this.codigoP = "";
        this.vendasN = new int[12];
        this.vendasP = new int[12];
        this.fatN = new float[12];
        this.fatP = new float[12];
    }
    
    public VendasProdutoMensais(String cod){
        this.codigoP=cod;
        this.vendasN = new int[12];
        this.vendasP = new int[12];
        this.fatN = new float[12];
        this.fatP = new float[12];
    }
    public VendasProdutoMensais(VendasProdutoMensais vpm){
        this.codigoP=vpm.getCodigoP();
        this.fatN=vpm.getFatN();
        this.fatP=vpm.getFatP();
        this.vendasN=vpm.getVendasN();
        this.vendasP=vpm.getVendasP();
    }

    public String getCodigoP() {
        return codigoP;
    }

    public float[] getFatN() {
        return this.fatN.clone();
    }

    public float[] getFatP() {
        return this.fatP.clone();
    }

    public int[] getVendasN() {
        return this.vendasN.clone();
    }

    public int[] getVendasP() {
        return this.vendasP.clone();
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public void setFatN(float[] fatN) {
        this.fatN = fatN.clone();
    }

    public void setFatP(float[] fatP) {
        this.fatP = fatP.clone();
    }

    public void setVendasN(int[] vendasN) {
        this.vendasN = vendasN.clone();
    }

    public void setVendasP(int[] vendasP) {
        this.vendasP = vendasP.clone();
    }
    public VendasProdutoMensais clone(){
        return new VendasProdutoMensais(this);
    }
    
    public boolean equals(Object o){
        if(this==o) return true;
        else if((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())))||o==null) return false;
        else{
            VendasProdutoMensais vpm=(VendasProdutoMensais) o;
            return this.codigoP.equals(vpm.getCodigoP())&&this.fatN.equals(vpm.getFatN())&&this.fatP.equals(vpm.getFatP())&&this.vendasN.equals(vpm.getVendasN())&&this.vendasP.equals(vpm.getVendasP());
        }
    }
    
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigoP,this.fatN,this.fatP,this.vendasN,this.vendasP});
    }
    
}
