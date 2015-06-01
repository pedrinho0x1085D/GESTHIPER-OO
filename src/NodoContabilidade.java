
import java.io.Serializable;
import java.util.Arrays;



/**
 * Nodo de Contabilidade de Um Produto
 * <p>A Contabilidade de um produto é definida por:</p>
 * <ul>
 * <li>Código de Produto</li>
 * <li>Relações de quantidade vendida, número de vendas e faturação mensal por modo ((N)ormal ou (P)romocional)</li> 
 *</ul>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class NodoContabilidade implements Serializable{

    private String codigo;
    private int qtdVendidaN[], qtdVendidaP[], nVendasN[], nVendasP[];
    private float faturacaoN[], faturacaoP[];
    /**
     * Construtor vazio
     */
    public NodoContabilidade() {
        this.codigo = "";
        this.qtdVendidaN = new int[12];
        this.qtdVendidaP = new int[12];
        this.nVendasN = new int[12];
        this.nVendasP = new int[12];
        this.faturacaoN = new float[12];
        this.faturacaoP = new float[12];
    }
    /**
     * Construtor Parametrizado
     * @param codigo Código de Produto
     */
    public NodoContabilidade(String codigo) {
        this.codigo = codigo;
        this.qtdVendidaN = new int[12];
        this.qtdVendidaP = new int[12];
        this.nVendasN = new int[12];
        this.nVendasP = new int[12];
        this.faturacaoN = new float[12];
        this.faturacaoP = new float[12];
    }
    /**
     * Construtor de Cópia
     * @param outro Nodo a ser copiado
     */
    public NodoContabilidade(NodoContabilidade outro) {
        this.codigo = outro.getCodigo();
        this.qtdVendidaN = outro.getQtdVendidaN();
        this.qtdVendidaP = outro.getQtdVendidaP();
        this.nVendasN = outro.getnVendasN();
        this.nVendasP = outro.getnVendasP();
        this.faturacaoN = outro.getFaturacaoN();
        this.faturacaoP = outro.getFaturacaoP();
    }
    /**
     * 
     * @return Código de Produto
     */
    public String getCodigo() {
        return this.codigo;
    }
    /**
     * 
     * @return Faturação Mensal em modo normal
     */
    public float[] getFaturacaoN() {
        return this.faturacaoN.clone();
    }
    /**
     * 
     * @return Faturação Mensal em modo promocional
     */
    public float[] getFaturacaoP() {
        return this.faturacaoP.clone();
    }
    /**
     * 
     * @return Quantidade Vendida mensalmente em modo normal
     */
    public int[] getQtdVendidaN() {
        return this.qtdVendidaN.clone();
    }
    /**
     * 
     * @return Quantidade Vendida mensalmente em modo promocional
     */
    public int[] getQtdVendidaP() {
        return this.qtdVendidaP.clone();
    }
    /**
     * 
     * @return Número de vendas mensalmente em modo normal
     */
    public int[] getnVendasN() {
        return this.nVendasN.clone();
    }
    /**
     * 
     * @return Número de vendas mensalmente em modo promocional
     */
    public int[] getnVendasP() {
        return this.nVendasP.clone();
    }
    /**
     * Atualiza o código de Produto
     * @param codigo Novo código de Produto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Atualiza a faturação mensal em modo normal
     * @param faturacaoN Nova faturação mensal em modo normal
     */
    public void setFaturacaoN(float[] faturacaoN) {
        this.faturacaoN = faturacaoN.clone();
    }
    /**
     * Atualiza a faturação mensal em modo promocional
     * @param faturacaoP Nova faturação mensal em modo promocional
     */
    public void setFaturacaoP(float[] faturacaoP) {
        this.faturacaoP = faturacaoP.clone();
    }
    /**
     * Atualiza a quantidade vendida mensalmente em modo normal
     * @param vendasN Nova quantidade vendida mensalmente em modo normal
     */
    public void setVendasN(int[] vendasN) {
        this.qtdVendidaN = vendasN.clone();
    }
    /**
     * Atualiza a quantidade vendida mensalmente em modo promocional
     * @param vendasP Nova quantidade vendida mensalmente em modo normal
     */
    public void setVendasP(int[] vendasP) {
        this.qtdVendidaP = vendasP.clone();
    }
    /**
     * Atualiza o número de vendas mensais em modo normal
     * @param nVendasN Novo número de vendas mensais em modo normal
     */
    public void setnVendasN(int[] nVendasN) {
        this.nVendasN = nVendasN.clone();
    }
    /**
     * Atualiza o número de vendas mensais em modo promocional
     * @param nVendasP Novo número de vendas mensais em modo promocional
     */
    public void setnVendasP(int[] nVendasP) {
        this.nVendasP = nVendasP.clone();
    }
    /**
     * Verifica se um produto foi comprado num dado mês
     * @param mes Mês a ser consultado
     * @return True se um produto foi comprado no mês especificado, False caso contrário
     */
    public boolean compradoNoMes(int mes) {
        return ((this.nVendasN[mes - 1] != 0) || (this.nVendasP[mes - 1] != 0));
    }
    /**
     * Retorna o número de compras num dado mês e modo
     * @param modo Modo a ser procurado
     * @param mes Mês a ser consultado
     * @return Número de compras realizadas no mês e modo especificados
     */
    public int getNComprasMes(char modo, int mes) {
        if (modo == 'P') {
            return this.nVendasP[mes - 1];
        } else if (modo == 'N') {
            return this.nVendasN[mes - 1];
        } else {
            return 0;
        }
    }
    /**
     * Retorna a quantidade comprada num dado mês e modo
     * @param modo Modo a ser procurado
     * @param mes Mês a ser consultado
     * @return Quantidade comprada no mês e modo especificados
     */
    public int getQtdCompradaMes(char modo, int mes) {
        if (modo == 'P') {
            return this.qtdVendidaP[mes - 1];
        } else if (modo == 'N') {
            return this.qtdVendidaN[mes - 1];
        } else {
            return 0;
        }
    }
    /**
     * Retorna a faturação registada num dado mês e ano
     * @param modo Modo a ser procurado
     * @param mes Mês a ser consultado
     * @return Faturação registada no mês e modo especificado
     */
    public float getFaturacaoMes(char modo, int mes) {
        if (modo == 'P') {
            return this.faturacaoP[mes - 1];
        } else if (modo == 'N') {
            return this.faturacaoN[mes - 1];
        } else {
            return 0;
        }
    }
    /**
     * Incrementa a quantidade comprada
     * @param modo Modo da compra
     * @param mes Mês da compra
     * @param qtd Quantidade a ser incrementada
     */
    public void incrementaQtdComprada(char modo, int mes, int qtd) {
        if (modo == 'P') {
            this.qtdVendidaP[mes - 1] += qtd;
        } else if (modo == 'N') {
            this.qtdVendidaN[mes - 1] += qtd;
        }
    }
    /**
     * Incrementa o número de vendas 
     * @param modo Modo da compra
     * @param mes Mês da Compra
     */
    public void incrementaNVendas(char modo, int mes) {
        if (modo == 'P') {
            this.nVendasP[mes - 1]++;
        } else if (modo == 'N') {
            this.nVendasN[mes - 1]++;
        }
    }
    /**
     * Incrementa a faturação 
     * @param modo Modo da Compra
     * @param mes Mês da compra
     * @param qtd Quantidade da Compra
     * @param valorUni Valor unitário da compra
     */
    public void incrementaFaturacao(char modo, int mes, int qtd, float valorUni) {
        if (modo == 'P') {
            this.faturacaoP[mes - 1] += (qtd * valorUni);
        } else if (modo == 'N') {
            this.faturacaoN[mes - 1] += (qtd * valorUni);
        }
    }
    /**
     * Verifica se o produto nunca foi comprado
     * @return True se o produto nunca foi comprado; False caso contrário
     */
    public boolean nuncaComprado(){
        boolean flag=true;
        for(int i = 0; i<12&&flag;i++)
            if(this.nVendasN[i]!=0||this.nVendasP[i]!=0) flag=false;
        return flag;
    }
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public NodoContabilidade clone() {
        return new NodoContabilidade(this);
    }
    /**
     * Teste de igualdade
     * @param o Objecto a ser testado 
     * @return True se this e o forem semanticamente iguais, false caso contrário 
     */
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

    /**
     * 
     * @return HashCode do objecto
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigo, this.faturacaoN, this.faturacaoP, this.nVendasN, this.nVendasP, this.qtdVendidaN, this.qtdVendidaP});
    }
    
    

}
