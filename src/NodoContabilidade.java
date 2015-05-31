
import java.io.Serializable;
import java.util.Arrays;



/**
 *
 * @author Pedro Cunha
 */
public class NodoContabilidade implements Serializable{

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
        return this.faturacaoN.clone();
    }

    public float[] getFaturacaoP() {
        return this.faturacaoP.clone();
    }

    public int[] getQtdVendidaN() {
        return this.qtdVendidaN.clone();
    }

    public int[] getQtdVendidaP() {
        return this.qtdVendidaP.clone();
    }

    public int[] getnVendasN() {
        return this.nVendasN.clone();
    }

    public int[] getnVendasP() {
        return this.nVendasP.clone();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFaturacaoN(float[] faturacaoN) {
        this.faturacaoN = faturacaoN.clone();
    }

    public void setFaturacaoP(float[] faturacaoP) {
        this.faturacaoP = faturacaoP.clone();
    }

    public void setVendasN(int[] vendasN) {
        this.qtdVendidaN = vendasN.clone();
    }

    public void setVendasP(int[] vendasP) {
        this.qtdVendidaP = vendasP.clone();
    }

    public void setnVendasN(int[] nVendasN) {
        this.nVendasN = nVendasN.clone();
    }

    public void setnVendasP(int[] nVendasP) {
        this.nVendasP = nVendasP.clone();
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

    public void incrementaQtdComprada(char modo, int mes, int qtd) {
        if (modo == 'P') {
            this.qtdVendidaP[mes - 1] += qtd;
        } else if (modo == 'N') {
            this.qtdVendidaN[mes - 1] += qtd;
        }
    }

    public void incrementaNVendas(char modo, int mes) {
        if (modo == 'P') {
            this.nVendasP[mes - 1]++;
        } else if (modo == 'N') {
            this.nVendasN[mes - 1]++;
        }
    }

    public void incrementaFaturacao(char modo, int mes, int qtd, float valorUni) {
        if (modo == 'P') {
            this.faturacaoP[mes - 1] += (qtd * valorUni);
        } else if (modo == 'N') {
            this.faturacaoN[mes - 1] += (qtd * valorUni);
        }
    }

    public boolean nuncaComprado(){
        boolean flag=true;
        for(int i = 0; i<12&&flag;i++)
            if(this.nVendasN[i]!=0||this.nVendasP[i]!=0) flag=false;
        return flag;
    }
    
    public NodoContabilidade clone() {
        return new NodoContabilidade(this);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())) || o == null) {
            return false;
        } else {
            NodoContabilidade nc = (NodoContabilidade) o;
            boolean flag = true;
            for (int i = 0; i < 12 && flag; i++) {
                if (this.faturacaoN[i] != nc.getFaturacaoMes('N', i + 1)) {
                    flag = false;
                } else if (this.faturacaoP[i] != nc.getFaturacaoMes('P', i + 1)) {
                    flag = false;
                } else if (this.nVendasN[i] != nc.getNComprasMes('N', i + 1)) {
                    flag = false;
                } else if (this.nVendasP[i] != nc.getNComprasMes('P', i + 1)) {
                    flag = false;
                } else if (this.qtdVendidaN[i] != nc.getQtdCompradaMes('N', i + 1)) {
                    flag = false;
                } else if (this.qtdVendidaP[i] != nc.getQtdCompradaMes('P', i + 1)) {
                    flag = true;
                }
            }
            return flag && (this.codigo.equals(nc.getCodigo()));
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigo, this.faturacaoN, this.faturacaoP, this.nVendasN, this.nVendasP, this.qtdVendidaN, this.qtdVendidaP});
    }
    
    

}
