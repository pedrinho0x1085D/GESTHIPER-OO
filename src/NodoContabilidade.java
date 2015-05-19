/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class NodoContabilidade {

    private String codigo;
    private int qtdVendidaN[], qtdVendidaP[], nVendasN[], nVendasP[];
    private float faturacaoN[], faturacaoP[];

    public NodoContabilidade() {
        this.codigo = "";
        this.qtdVendidaN = new int[12];
        this.qtdVendidaP = new int[12];
        this.nVendasN = new int[12];
        this.nVendasP = new int[12];
        this.faturacaoN = new float[12];
        this.faturacaoP = new float[12];
    }

    public NodoContabilidade(String codigo) {
        this.codigo = codigo;
        this.qtdVendidaN = new int[12];
        this.qtdVendidaP = new int[12];
        this.nVendasN = new int[12];
        this.nVendasP = new int[12];
        this.faturacaoN = new float[12];
        this.faturacaoP = new float[12];
    }

    public NodoContabilidade(NodoContabilidade outro) {
        this.codigo = outro.getCodigo();
        this.qtdVendidaN = outro.getQtdVendidaN();
        this.qtdVendidaP = outro.getQtdVendidaP();
        this.nVendasN = outro.getnVendasN();
        this.nVendasP = outro.getnVendasP();
        this.faturacaoN = outro.getFaturacaoN();
        this.faturacaoP = outro.getFaturacaoP();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public float[] getFaturacaoN() {
        return this.faturacaoN;
    }

    public float[] getFaturacaoP() {
        return this.faturacaoP;
    }

    public int[] getQtdVendidaN() {
        return this.qtdVendidaN;
    }

    public int[] getQtdVendidaP() {
        return this.qtdVendidaP;
    }

    public int[] getnVendasN() {
        return this.nVendasN;
    }

    public int[] getnVendasP() {
        return this.nVendasP;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFaturacaoN(float[] faturacaoN) {
        this.faturacaoN = faturacaoN;
    }

    public void setFaturacaoP(float[] faturacaoP) {
        this.faturacaoP = faturacaoP;
    }

    public void setVendasN(int[] vendasN) {
        this.qtdVendidaN = vendasN;
    }

    public void setVendasP(int[] vendasP) {
        this.qtdVendidaP = vendasP;
    }

    public void setnVendasN(int[] nVendasN) {
        this.nVendasN = nVendasN;
    }

    public void setnVendasP(int[] nVendasP) {
        this.nVendasP = nVendasP;
    }

    public boolean compradoNoMes(int mes) {
        return ((this.nVendasN[mes - 1] != 0) || (this.nVendasP[mes - 1] != 0));
    }

    public int getNComprasMes(char modo, int mes) {
        if (modo == 'P') {
            return this.nVendasP[mes - 1];
        } else if (modo == 'N') {
            return this.nVendasN[mes - 1];
        } else {
            return 0;
        }
    }

    public int getQtdCompradaMes(char modo, int mes) {
        if (modo == 'P') {
            return this.qtdVendidaP[mes - 1];
        } else if (modo == 'N') {
            return this.qtdVendidaN[mes - 1];
        } else {
            return 0;
        }
    }

    public float getFaturacaoMes(char modo, int mes) {
        if (modo == 'P') {
            return this.faturacaoP[mes - 1];
        } else if (modo == 'N') {
            return this.faturacaoN[mes - 1];
        } else {
            return 0;
        }
    }

    public void incrementaQtdComprada(char modo, int mes,int qtd) {
        if(modo=='P') this.qtdVendidaP[mes-1]+=qtd;
        else if(modo=='N') this.qtdVendidaN[mes-1]+=qtd;
    }
    
    public void incrementaNVendas(char modo, int mes){
        if(modo=='P') this.nVendasP[mes-1]++;
        else if(modo=='N')this.nVendasN[mes-1]++;
    }
    
    public void incrementaFaturacao(char modo, int mes, int qtd, float valorUni){
        if(modo=='P') this.faturacaoP[mes-1]+=(qtd*valorUni);
        else if(modo=='N') this.faturacaoN[mes-1]+=(qtd*valorUni);
    }

    public NodoContabilidade clone() {
        return new NodoContabilidade(this);
    }
/*Falta equals e hash code*/
}
