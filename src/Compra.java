
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
public class Compra implements Serializable{

    private String codigoProd;
    private float valorUni;
    private int quantidade;
    private char modo;
    private String codigoCli;
    private int mes;

    public Compra() {
        this.codigoProd = new String();
        this.valorUni = 0;
        this.quantidade = 0;
        this.modo = 'N';
        this.codigoCli = new String();
        this.mes = 0;
    }

    public Compra(String codigoProd, float valorUni, int quantidade, char modo, String codigoCli, int mes) {
        this.codigoProd = codigoProd;
        this.valorUni = valorUni;
        this.quantidade = quantidade;
        this.modo = modo;
        this.codigoCli = codigoCli;
        this.mes = mes;
    }

    public String getCodigoCli() {
        return this.codigoCli;
    }

    public String getCodigoProd() {
        return this.codigoProd;
    }

    public int getMes() {
        return this.mes;
    }

    public char getModo() {
        return this.modo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public float getValorUni() {
        return this.valorUni;
    }

    public void setCodigoCli(String codigoCli) {
        this.codigoCli = codigoCli;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setModo(char modo) {
        this.modo = modo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUni(float valorUni) {
        this.valorUni = valorUni;
    }

    /*To Do*/
    @Override
    public String toString() {
        return "";
    }

    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            Compra co = (Compra) o;
            return (this.codigoCli.equals(co.getCodigoCli()) && this.codigoProd.equals(co.getCodigoProd()) && this.mes == co.getMes() && this.modo == co.getModo() && this.quantidade == co.getQuantidade() && this.valorUni == co.getValorUni());
        }
    }

    
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigoCli,this.codigoProd,this.mes,this.modo,this.quantidade,this.valorUni});
    }

}
