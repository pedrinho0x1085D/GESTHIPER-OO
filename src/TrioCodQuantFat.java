
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
public class TrioCodQuantFat {
    
    private String codigo;
    private int quantidade;
    private float faturacao;

    public TrioCodQuantFat() {
    this.codigo="";
    this.quantidade=0;
    this.faturacao=0;
    }

    public TrioCodQuantFat(String codigo, int quantidade, float faturacao) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.faturacao = faturacao;
    }
    
    public TrioCodQuantFat(TrioCodQuantFat tcqc){
        this.codigo=tcqc.getCodigo();
        this.faturacao=tcqc.getFaturacao();
        this.quantidade=tcqc.getQuantidade();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public float getFaturacao() {
        return this.faturacao;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setFaturacao(int faturacao) {
        this.faturacao= faturacao;
    }
    
    public TrioCodQuantFat clone(){
        return new TrioCodQuantFat(this);
    }
    
    public boolean equals(Object o){
        if(this==o) return true;
        else if((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())))||o==null) return false;
        else{
            TrioCodQuantFat trio=(TrioCodQuantFat) o;
            return (this.codigo.equals(trio.getCodigo()))&&(this.faturacao==trio.getFaturacao())&&(this.quantidade==trio.getQuantidade());
        }
    }
    
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigo,this.faturacao,this.quantidade});
    }
     /**
  * 
  * @return representação textual da instância 
  */
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       
       sb.append("Código do produto ");
       sb.append(this.codigo);
       sb.append("\n");
       sb.append("Quantidade ");
       sb.append(this.quantidade);
       sb.append("\n");
       sb.append("Faturação ");
       sb.append(this.faturacao);
       sb.append("\n");
        
        return sb.toString();
    }
    
}

