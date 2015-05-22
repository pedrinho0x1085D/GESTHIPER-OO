/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class ParCodigoQuantidade {
    private String codigo;
    private int quantidade;

    public ParCodigoQuantidade() {
    this.codigo="";
    this.quantidade=0;
    }

    public ParCodigoQuantidade(String codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }
    
    public ParCodigoQuantidade(ParCodigoQuantidade pcq){
        this.codigo=pcq.getCodigo();
        this.quantidade=pcq.getQuantidade();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean equals(Object o){
        if(this==o) return true;
        else if((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())))||o==null) return false;
        else{
            ParCodigoQuantidade pcq=(ParCodigoQuantidade) o;
            return (this.codigo.equals(pcq.getCodigo()))&&(this.quantidade==pcq.getQuantidade());
        }
    }
    
    public ParCodigoQuantidade clone(){
        return new ParCodigoQuantidade(this);
    }
    
}
