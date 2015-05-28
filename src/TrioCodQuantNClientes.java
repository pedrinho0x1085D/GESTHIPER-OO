
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
public class TrioCodQuantNClientes {
    private String codigo;
    private int quantidade;
    private int nClientes;

    public TrioCodQuantNClientes() {
    this.codigo="";
    this.quantidade=0;
    this.nClientes=0;
    }

    public TrioCodQuantNClientes(String codigo, int quantidade, int nClientes) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nClientes = nClientes;
    }
    
    public TrioCodQuantNClientes(TrioCodQuantNClientes tcqc){
        this.codigo=tcqc.getCodigo();
        this.nClientes=tcqc.getnClientes();
        this.quantidade=tcqc.getQuantidade();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public int getnClientes() {
        return this.nClientes;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }
    
    public TrioCodQuantNClientes clone(){
        return new TrioCodQuantNClientes(this);
    }
    
    public boolean equals(Object o){
        if(this==o) return true;
        else if((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())))||o==null) return false;
        else{
            TrioCodQuantNClientes trio=(TrioCodQuantNClientes) o;
            return (this.codigo.equals(trio.getCodigo()))&&(this.nClientes==trio.getnClientes())&&(this.quantidade==trio.getQuantidade());
        }
    }
    
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigo,this.nClientes,this.quantidade});
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
       sb.append("Numero de Clientes ");
       sb.append(this.nClientes);
       sb.append("\n");
        
        return sb.toString();
    }
}
