


/**
 * Classe que guarda as estatísticas de ficheiro
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class FileStats {

    private String filenameComp, filenameProd, filenameCli;
    private int nProds, prodsComp, prodsNComp;
    private int nClientes, nClientesCompradores, nClientesNaoCompraram;
    private int comprasValor0;
    private float faturacaoTotal;

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

    public int getComprasValor0() {
        return this.comprasValor0;
    }

    public float getFaturacaoTotal() {
        return this.faturacaoTotal;
    }

    public String getFilenameCli() {
        return this.filenameCli;
    }

    public String getFilenameComp() {
        return this.filenameComp;
    }

    public String getFilenameProd() {
        return this.filenameProd;
    }

    public int getnProds() {
        return this.nProds;
    }

    
    public int getProdsComp() {
        return this.prodsComp;
    }

    public int getProdsNComp() {
        return this.prodsNComp;
    }

    public int getnClientes() {
        return this.nClientes;
    }

    public int getnClientesCompradores() {
        return this.nClientesCompradores;
    }

    public int getnClientesNaoCompraram() {
        return this.nClientesNaoCompraram;
    }

    public void setComprasValor0(int comprasValor0) {
        this.comprasValor0 = comprasValor0;
    }

    public void setFaturacaoTotal(float faturacaoTotal) {
        this.faturacaoTotal = faturacaoTotal;
    }

    public void setFilenameCli(String filenameCli) {
        this.filenameCli = filenameCli;
    }

    public void setFilenameComp(String filenameComp) {
        this.filenameComp = filenameComp;
    }

    public void setFilenameProd(String filenameProd) {
        this.filenameProd = filenameProd;
    }

    public void setProdsNComp(int prodsNComp) {
        this.prodsNComp = prodsNComp;
    }

    public void setProdsComp(int prodsComp) {
        this.prodsComp = prodsComp;
    }

    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    public void setnClientesCompradores(int nClientesCompradores) {
        this.nClientesCompradores = nClientesCompradores;
    }

    public void setnClientesNaoCompraram(int nClientesNaoCompraram) {
        this.nClientesNaoCompraram = nClientesNaoCompraram;
    }

    public void setnProds(int nProds) {
        this.nProds = nProds;
    }

    public FileStats clone() {
        return new FileStats(this.filenameComp, this.filenameProd, this.filenameCli, this.nProds, this.prodsComp, this.prodsNComp, this.nClientes, this.nClientesCompradores, this.nClientesNaoCompraram, this.comprasValor0, this.faturacaoTotal);
    }
    
    /**
  * 
  * @return representação textual da instância 
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
       sb.append("Total de Produtos Comprados");
       sb.append(this.prodsNComp);
       sb.append("\n");
       sb.append("Numeros de Clientes");
       sb.append(this.nClientes);
       sb.append("\n");
       sb.append("Numeros de Clientes Compradores");
       sb.append(this.nClientesCompradores);
       sb.append("\n");
       sb.append("Numeros de Clientes que não Compraram");
       sb.append(this.nClientesNaoCompraram);
       sb.append("\n");
       sb.append("Produtos que nunca foram comprados");
       sb.append(this.comprasValor0);
       sb.append("\n");
       sb.append("Faturação Total");
       sb.append(this.faturacaoTotal);
       sb.append("\n");
        
        return sb.toString();
    }

}
