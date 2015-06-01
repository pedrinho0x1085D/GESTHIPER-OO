
import java.util.Arrays;

/**
 * Classe que guarda as relações mensais de Compras e Faturação no modo Normal e
 * Promocional
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class VendasProdutoMensais {

    private String codigoP;
    private int vendasN[], vendasP[];
    private float fatN[], fatP[];

    /**
     * Construtor Vazio
     */
    public VendasProdutoMensais() {
        this.codigoP = "";
        this.vendasN = new int[12];
        this.vendasP = new int[12];
        this.fatN = new float[12];
        this.fatP = new float[12];
    }

    /**
     * Construtor Parametrizado
     *
     * @param cod Código de Produto
     */
    public VendasProdutoMensais(String cod) {
        this.codigoP = cod;
        this.vendasN = new int[12];
        this.vendasP = new int[12];
        this.fatN = new float[12];
        this.fatP = new float[12];
    }

    /**
     * Construtor de Cópia
     *
     * @param vpm Objecto a ser copiado
     */
    public VendasProdutoMensais(VendasProdutoMensais vpm) {
        this.codigoP = vpm.getCodigoP();
        this.fatN = vpm.getFatN();
        this.fatP = vpm.getFatP();
        this.vendasN = vpm.getVendasN();
        this.vendasP = vpm.getVendasP();
    }

    /**
     *
     * @return Código de Produto
     */
    public String getCodigoP() {
        return codigoP;
    }

    /**
     *
     * @return Relação mensal da faturação em modo normal
     */
    public float[] getFatN() {
        return this.fatN.clone();
    }

    /**
     *
     * @return Relação mensal da faturação em modo promocional
     */
    public float[] getFatP() {
        return this.fatP.clone();
    }

    /**
     *
     * @return Relação mensal das vendas em modo normal
     */
    public int[] getVendasN() {
        return this.vendasN.clone();
    }

    /**
     *
     * @return Relação mensal das vendas em modo promocional
     */
    public int[] getVendasP() {
        return this.vendasP.clone();
    }
    /**
     * Atualiza o codigo de produto
     * @param codigoP Novo código de Produto
     */
    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }
    /**
     * Atualiza a relação mensal de faturação em modo normal
     * @param fatN Nova relação mensal de faturação em modo normal
     */
    public void setFatN(float[] fatN) {
        this.fatN = fatN.clone();
    }
    /**
     * Atualiza a relação mensal de faturação em modo promocional
     * @param fatP Nova relação mensal de faturação em modo promocional
     */
    public void setFatP(float[] fatP) {
        this.fatP = fatP.clone();
    }
    /**
     * Atualiza a relaçao mensal de vendas em modo normal
     * @param vendasN Nova relação mensal de vendas em modo normal
     */
    public void setVendasN(int[] vendasN) {
        this.vendasN = vendasN.clone();
    }
    /**
     * Atualiza a relação mensal de vendas em modo promocional
     * @param vendasP Nova relação mensal de vendas em modo promocional
     */
    public void setVendasP(int[] vendasP) {
        this.vendasP = vendasP.clone();
    }
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public VendasProdutoMensais clone() {
        return new VendasProdutoMensais(this);
    }
    /**
     * Teste de igualdade 
     * @param o Objecto a ser testado
     * @return True se this e o forem semanticamente iguais, False caso contrário
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            VendasProdutoMensais vpm = (VendasProdutoMensais) o;
            return this.codigoP.equals(vpm.getCodigoP()) && this.fatN.equals(vpm.getFatN()) && this.fatP.equals(vpm.getFatP()) && this.vendasN.equals(vpm.getVendasN()) && this.vendasP.equals(vpm.getVendasP());
        }
    }
    /**
     * 
     * @return HashCode do Objecto
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigoP, this.fatN, this.fatP, this.vendasN, this.vendasP});
    }

    /**
     *
     * @return Representação textual da instância
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Código do produto ???? Ver");
        sb.append(this.codigoP);
        sb.append("\n");
        sb.append("Vendas modo Normal\n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.vendasN[i]);
        }
        sb.append("\n");
        sb.append("Vendas modo Promoção \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.vendasP[i] + " ");
        }
        sb.append("\n");
        sb.append("Faturção Normal ");
        for (int i = 0; i < 12; i++) {
            sb.append(this.fatN[i] + "€ ");
        }
        sb.append("\n");
        sb.append("Faturção Promoção ");
        for (int i = 0; i < 12; i++) {
            sb.append(this.fatP[i] + "€ ");
        }
        sb.append("\n");
        return sb.toString();
    }

}
