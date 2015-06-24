package Business;


/**
 * Classe que guarda as estatísticas de ficheiro
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class FileStats {

    private String filenameComp, filenameProd, filenameCli;
    private int nProds, prodsComp, prodsNComp;
    private int nClientes, nClientesCompradores, nClientesNaoCompraram;
    private int comprasValor0;
    private float faturacaoTotal;

    /**
     * Construtor Vazio
     */
    public FileStats() {
        this.filenameComp = "";
        this.filenameProd = "";
        this.filenameCli = "";
        this.nProds = 0;
        this.prodsComp = 0;
        this.prodsNComp = 0;
        this.nClientes = 0;
        this.nClientesCompradores = 0;
        this.nClientesNaoCompraram = 0;
        this.comprasValor0 = 0;
        this.faturacaoTotal = 0;

    }

    /**
     * Construtor Parametrizado
     *
     * @param filenameComp Nome do Ficheiro de Compras
     * @param filenameProd Nome do Ficheiro de Produtos
     * @param filenameCli Nome do Ficheiro de Clientes
     * @param nProds Número de Produtos registados
     * @param prodsComp Número de Produtos Comprados
     * @param prodsNComp Número de Produtos Não Comprados
     * @param nClientes Número de Clientes registados
     * @param nClientesCompradores Número de Clientes Compradores
     * @param nClientesNaoCompraram Número de Clientes Não Compradores
     * @param comprasValor0 Número de Compras Valor 0
     * @param faturacaoTotal Faturação Total
     */
    public FileStats(String filenameComp, String filenameProd, String filenameCli, int nProds, int prodsComp, int prodsNComp, int nClientes, int nClientesCompradores, int nClientesNaoCompraram, int comprasValor0, float faturacaoTotal) {
        this.filenameComp = filenameComp;
        this.filenameProd = filenameProd;
        this.filenameCli = filenameCli;
        this.nProds = nProds;
        this.prodsComp = prodsComp;
        this.prodsNComp = prodsNComp;
        this.nClientes = nClientes;
        this.nClientesCompradores = nClientesCompradores;
        this.nClientesNaoCompraram = nClientesNaoCompraram;
        this.comprasValor0 = comprasValor0;
        this.faturacaoTotal = faturacaoTotal;

    }

    /**
     *
     * @return Número de Compras de Valor 0
     */
    public int getComprasValor0() {
        return this.comprasValor0;
    }

    /**
     *
     * @return Faturação Total
     */
    public float getFaturacaoTotal() {
        return this.faturacaoTotal;
    }

    /**
     *
     * @return Nome de Ficheiro de Clientes
     */
    public String getFilenameCli() {
        return this.filenameCli;
    }

    /**
     *
     * @return Nome do Ficheiro de Compras
     */
    public String getFilenameComp() {
        return this.filenameComp;
    }

    /**
     *
     * @return Nome do Ficheiro de Produtos
     */
    public String getFilenameProd() {
        return this.filenameProd;
    }

    /**
     *
     * @return Número de Produtos registados
     */
    public int getnProds() {
        return this.nProds;
    }

    /**
     *
     * @return Número de Produtos Comprados
     */
    public int getProdsComp() {
        return this.prodsComp;
    }

    /**
     *
     * @return Número de Produtos Não Comprados
     */
    public int getProdsNComp() {
        return this.prodsNComp;
    }

    /**
     *
     * @return Número de Clientes Registados
     */
    public int getnClientes() {
        return this.nClientes;
    }

    /**
     *
     * @return Número de Clientes Compradores
     */
    public int getnClientesCompradores() {
        return this.nClientesCompradores;
    }

    /**
     *
     * @return Número de Clientes que Não Registaram Compras
     */
    public int getnClientesNaoCompraram() {
        return this.nClientesNaoCompraram;
    }

    /**
     * Atualiza o número de compras de valor 0
     *
     * @param comprasValor0 Novo número de compras de valor 0
     */
    public void setComprasValor0(int comprasValor0) {
        this.comprasValor0 = comprasValor0;
    }

    /**
     * Atualiza a faturação total
     *
     * @param faturacaoTotal Nova faturação total
     */
    public void setFaturacaoTotal(float faturacaoTotal) {
        this.faturacaoTotal = faturacaoTotal;
    }

    /**
     * Atualiza o nome do ficheiro de Clientes
     *
     * @param filenameCli Novo nome do ficheiro de Clientes
     */
    public void setFilenameCli(String filenameCli) {
        this.filenameCli = filenameCli;
    }

    /**
     * Atualiza o nome do ficheiro de Compras
     *
     * @param filenameComp Novo nome do ficheiro de Compras
     */
    public void setFilenameComp(String filenameComp) {
        this.filenameComp = filenameComp;
    }

    /**
     * Atualiza o nome de ficheiro de Produtos
     *
     * @param filenameProd Novo nome do ficheiro de Produtos
     */
    public void setFilenameProd(String filenameProd) {
        this.filenameProd = filenameProd;
    }

    /**
     * Atualiza o número de Produtos não Comprados
     *
     * @param prodsNComp Novo número de produtos não comprados
     */
    public void setProdsNComp(int prodsNComp) {
        this.prodsNComp = prodsNComp;
    }

    /**
     * Atualiza o número de Produtos Comprados
     *
     * @param prodsComp Novo número de produtos comprados
     */
    public void setProdsComp(int prodsComp) {
        this.prodsComp = prodsComp;
    }

    /**
     * Atualiza o número de Clientes Registados
     *
     * @param nClientes Novo número de Clientes Registados
     */
    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    /**
     * Atualiza o número de Clientes Compradores
     *
     * @param nClientesCompradores Novo número de Clientes Compradores
     */
    public void setnClientesCompradores(int nClientesCompradores) {
        this.nClientesCompradores = nClientesCompradores;
    }

    /**
     * Atualiza o número de clientes que não registaram compras
     *
     * @param nClientesNaoCompraram Novo número de clientes que não registaram
     * compras
     */
    public void setnClientesNaoCompraram(int nClientesNaoCompraram) {
        this.nClientesNaoCompraram = nClientesNaoCompraram;
    }

    /**
     * Atualiza o número de Produtos registados
     *
     * @param nProds Novo Número de Produtos Registados
     */
    public void setnProds(int nProds) {
        this.nProds = nProds;
    }

    /**
     *
     * @return Nova instância de FileStats como cópia da actual
     */
    public FileStats clone() {
        return new FileStats(this.filenameComp, this.filenameProd, this.filenameCli, this.nProds, this.prodsComp, this.prodsNComp, this.nClientes, this.nClientesCompradores, this.nClientesNaoCompraram, this.comprasValor0, this.faturacaoTotal);
    }

    /**
     *
     * @return Representação textual da instância
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Ficheiro Compras ");
        sb.append(this.filenameComp);
        sb.append("\n");
        sb.append("Ficheiro Produtos ");
        sb.append(this.filenameProd);
        sb.append("\n");
        sb.append("Ficheiro Clientes ");
        sb.append(this.filenameCli);
        sb.append("\n");
        sb.append("Número de Produtos ");
        sb.append(this.nProds);
        sb.append("\n");
        sb.append("Produtos Comprados ");
        sb.append(this.prodsComp);
        sb.append("\n");
        sb.append("Total de Produtos Não Comprados ");
        sb.append(this.prodsNComp);
        sb.append("\n");
        sb.append("Numero de Clientes ");
        sb.append(this.nClientes);
        sb.append("\n");
        sb.append("Numero de Clientes Compradores ");
        sb.append(this.nClientesCompradores);
        sb.append("\n");
        sb.append("Numero de Clientes que não Compraram ");
        sb.append(this.nClientesNaoCompraram);
        sb.append("\n");
        sb.append("Compras de valor 0: ");
        sb.append(this.comprasValor0);
        sb.append("\n");
        sb.append("Faturação Total ");
        sb.append(this.faturacaoTotal);
        sb.append("\n");

        return sb.toString();
    }

}
