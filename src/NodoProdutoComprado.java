
import java.io.Serializable;
import java.util.Arrays;


/**
 * Nodo de Produto Comprado
 * <p>Deverá Guardar as seguintes informações</p>
 * <ul>
 * <li>Código de Produto</li>
 * <li>Relações mensais de quantidade comprada e faturação por modo</li>
 * </ul>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class NodoProdutoComprado implements Serializable {

    private String codigoP;
    private int qtdCompN[], qtdCompP[];
    private float valorN[], valorP[];
    /**
     * Construtor Vazio 
     */
    public NodoProdutoComprado() {
        this.codigoP = "";
        this.qtdCompN = new int[12];
        this.qtdCompP = new int[12];
        this.valorN = new float[12];
        this.valorP = new float[12];

    }
    /**
     * Construtor Parametrizado
     * @param codigoP Código de Produto
     */
    public NodoProdutoComprado(String codigoP) {
        this.codigoP = codigoP;
        this.qtdCompN = new int[12];
        this.qtdCompP = new int[12];
        this.valorN = new float[12];
        this.valorP = new float[12];

    }
    /**
     * Construtor de Cópia
     * @param npc Nodo a ser copiado
     */
    public NodoProdutoComprado(NodoProdutoComprado npc) {
        this.codigoP = npc.getCodigoP();
        this.qtdCompN = npc.getQtdCompN();
        this.qtdCompP = npc.getQtdCompP();
        this.valorN = npc.getValorN();
        this.valorP = npc.getValorP();
    }
    /**
     * 
     * @return Código de Produto
     */
    public String getCodigoP() {
        return this.codigoP;
    }
    /**
     * 
     * @return Relaçao mensal de quantidade comprada em modo normal
     */
    public int[] getQtdCompN() {
        return this.qtdCompN.clone();
    }
    /**
     * 
     * @return Relação mensal de quantidade comprada em modo promocional
     */
    public int[] getQtdCompP() {
        return this.qtdCompP.clone();
    }
    /**
     * 
     * @return Relação mensal da faturação em modo normal
     */
    public float[] getValorN() {
        return this.valorN.clone();
    }
    /**
     * 
     * @return Relação mensal da faturação em modo promocional
     */
    public float[] getValorP() {
        return this.valorP.clone();
    }
    /**
     * Atualiza o código de Produto
     * @param codigoP Novo código de produto
     */
    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }
    /**
     * Atualiza a relação de quantidade comprada mensalmente em modo normal
     * @param qtdCompN Nova relação mensal de quantidade mensal comprada em modo normal
     */
    public void setQtdCompN(int[] qtdCompN) {
        this.qtdCompN = qtdCompN.clone();
    }
    /**
     * Atualiza a relação de quantidade comprada mensalmente em modo promocional
     * @param qtdCompP Nova relação mensal de quantidade mensal comprada em modo promocional
     */
    public void setQtdCompP(int[] qtdCompP) {
        this.qtdCompP = qtdCompP.clone();
    }
    /**
     * Atualiza a relação mensal de faturação em modo normal
     * @param valorN Nova relação mensal de faturação em modo normal
     */
    public void setValorN(float[] valorN) {
        this.valorN = valorN.clone();
    }
    /**
     * Atualiza a relação mensal de faturação em modo promocional
     * @param valorP Nova relação mensal de faturação em modo promocional
     */
    public void setValorP(float[] valorP) {
        this.valorP = valorP.clone();
    }
    /**
     * Retorna a quantidade comprada num mês e modo dados
     * @param modo Modo a ser consultado
     * @param mes Mês a ser consultado
     * @return Quantidade comprada no modo e mês especificados
     */
    public int getQtdCompMes(char modo, int mes) {
        if (modo == 'P') {
            return this.qtdCompP[mes - 1];
        } else if (modo == 'N') {
            return this.qtdCompN[mes - 1];
        } else {
            return 0;
        }
    }
    /**
     * Retorna a faturação registada num mês e modo dados
     * @param modo Modo a ser consultado
     * @param mes Mês a ser consultado
     * @return Quantidade comprada no modo e mês especificados
     */
    public float getValorMes(char modo, int mes) {
        if (modo == 'P') {
            return this.valorP[mes - 1];
        } else if (modo == 'N') {
            return this.valorN[mes - 1];
        } else {
            return 0;
        }
    }
    /**
     * 
     * @return Quantidade total comprada
     */
    public int getQtdTotal() {
        int total = 0;
        for (int i = 0; i < 12; i++) {
            total += this.qtdCompN[i];
            total += this.qtdCompP[i];
        }
        return total;
    }
    /**
     * 
     * @return Faturação total registada
     */
    public float getFatTotal() {
        float total = 0;
        for (int i = 0; i < 12; i++) {
            total += this.valorN[i];
            total += this.valorP[i];
        }
        return total;
    }
    /**
     * Incrementa a quantidade
     * @param modo Modo da compra
     * @param mes Mês da compra
     * @param qtd Quantidade da compra
     */
    public void incrementaQuantidade(char modo, int mes, int qtd) {
        if (modo == 'P') {
            this.qtdCompP[mes - 1] += qtd;
        } else if (modo == 'N') {
            this.qtdCompN[mes - 1] += qtd;
        }
    }
    /**
     * Incrementa a faturação 
     * @param modo Modo da compra
     * @param mes Mês da compra
     * @param valorUni Valor unitário da compra
     * @param qtd Quantidade da compra
     */
    public void incrementaValor(char modo, int mes, float valorUni, int qtd) {
        if (modo == 'P') {
            this.valorP[mes - 1] += (qtd * valorUni);
        } else if (modo == 'N') {
            this.valorN[mes - 1] += (qtd * valorUni);
        }
    }
    /**
     * 
     * @return Objecto como cópia da instância actual
     */
    public NodoProdutoComprado clone() {
        return new NodoProdutoComprado(this);
    }
    /**
     * 
     * @return HashCode do Nodo
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigoP, this.qtdCompN, this.qtdCompP, this.valorN, this.valorP});
    }
    /**
     * Teste de igualdade
     * @param obj Objecto a ser testado
     * @return True se this e obj forem semanticamente iguais, False caso contrário
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        NodoProdutoComprado e = (NodoProdutoComprado) obj;
        return (this.codigoP.equals(e.getCodigoP()) && this.qtdCompN.equals(e.getQtdCompN()) && this.qtdCompP.equals(e.getQtdCompP()) && this.valorN.equals(e.getValorN()) && this.valorP.equals(e.getValorP()));
    }
}
