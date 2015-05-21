/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class Table {

    private String codigo;
    private int distintos[], nCompras[];
    private float faturacaoMensal[], faturacaoTotal;

    public Table() {
        this.codigo = "";
        this.distintos = new int[12];
        this.nCompras = new int[12];
        this.faturacaoMensal = new float[12];
        this.faturacaoTotal = 0;
    }

    public Table(String codigo) {
        this.codigo = codigo;
        this.distintos = new int[12];
        this.nCompras = new int[12];
        this.faturacaoMensal = new float[12];
        this.faturacaoTotal = 0;
    }

    public Table(Table other) {
        this.codigo = other.getCodigo();
        this.distintos = other.getDistintos();
        this.nCompras = other.getnCompras();
        this.faturacaoMensal = other.getFaturacaoMensal();
        this.faturacaoTotal = other.getFaturacaoTotal();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setnCompras(int[] nCompras) {
        this.nCompras = nCompras;
    }

    public int[] getnCompras() {
        return this.nCompras;
    }

    public int[] getDistintos() {
        return this.distintos;
    }

    public float[] getFaturacaoMensal() {
        return this.faturacaoMensal;
    }

    public float getFaturacaoTotal() {
        return this.faturacaoTotal;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDistintos(int[] distintos) {
        this.distintos = distintos;
    }

    public void setFaturacaoMensal(float[] faturacaoMensal) {
        this.faturacaoMensal = faturacaoMensal;
    }

    public void setFaturacaoTotal(float faturacaoTotal) {
        this.faturacaoTotal = faturacaoTotal;
    }

    public void adicionaDistintos(int qtd, int mes) {
        this.distintos[mes - 1] = qtd;
    }

    public void adicionaFaturacaoMensal(float fat, int mes) {
        this.faturacaoMensal[mes - 1] = fat;
        this.faturacaoTotal += fat;
    }

    public void adicionaNCompras(int nCompras,int mes){
        this.nCompras[mes-1]=nCompras;
    }
    public Table clone() {
        return new Table(this);
    }

}
