
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

    public void adicionaNCompras(int nCompras, int mes) {
        this.nCompras[mes - 1] = nCompras;
    }

    public Table clone() {
        return new Table(this);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            Table t=(Table) o;
            return this.codigo.equals(t.getCodigo()) && this.distintos.equals(t.getDistintos()) && this.faturacaoMensal.equals(t.getFaturacaoMensal()) && this.faturacaoTotal==t.getFaturacaoTotal() && this.nCompras.equals(t.getnCompras());
        }

    }
    
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigo,this.distintos,this.faturacaoMensal,this.faturacaoTotal,this.nCompras});
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
       sb.append("Disintos \n");
       for(int i=0;i<12;i++){ sb.append(this.distintos[i]); }
       sb.append("\n");
       sb.append("Numero de Compras ");
       for(int i=0;i<12;i++){ sb.append(this.nCompras[i]); }
       sb.append("\n");
       sb.append("Faturção Mensal \n"); 
       for(int i=0;i<12;i++){ sb.append(this.faturacaoMensal[i] + "€  "); }
       sb.append("\n");
       sb.append("Faturção Total \n"); 
       sb.append(this.faturacaoTotal + "€");
       return sb.toString();
    }
}
