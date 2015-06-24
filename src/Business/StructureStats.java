package Business;


import Utils.Compra;
import java.util.ArrayList;


/**
 * Classe que guarda as estatísticas da estrutura de dados
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class StructureStats {
    private int comprasMes[];
    private float faturacaoMensal[];
    private int clientesCompradoresMensal[];
    private ArrayList<Compra> comprasInvalidas;
    private int nComprasInvalidas;
    /**
     * Construtor vazio
     */
    public StructureStats(){
        this.comprasMes = new int[12];
        this.faturacaoMensal = new float[12];
        this.clientesCompradoresMensal = new int[12];
        this.comprasInvalidas = new ArrayList<>();
        this.nComprasInvalidas = 0;
    }
    /**
     * Construtor Parametrizado
     * @param comprasMes Relação mensal do número de Compras 
     * @param faturacaoMensal Relação Mensal da Faturação
     * @param clientesCompradoresMensal Relação Mensal do número de Clientes compradores
     * @param comprasInvalidas Lista com as Compras inválidas
     * @param nComprasInvalidas Número de compras inválidas
     */
    public StructureStats(int[] comprasMes, float[] faturacaoMensal, int[] clientesCompradoresMensal, ArrayList<Compra> comprasInvalidas,int nComprasInvalidas) {
        this.comprasMes = comprasMes;
        this.faturacaoMensal = faturacaoMensal;
        this.clientesCompradoresMensal = clientesCompradoresMensal;
        this.comprasInvalidas = new ArrayList<>();
        for(Compra c:comprasInvalidas)
            this.comprasInvalidas.add(c.clone());
        this.nComprasInvalidas = nComprasInvalidas;
    }
    
    /**
     * 
     * @return Relação mensal dos clientes compradores
     */
     public int[] getClientesCompradoresMensal() {
        return this.clientesCompradoresMensal.clone();
    }
     /**
      * 
      * @return Lista com as Compras inválidas
      */
    public ArrayList<Compra> getComprasInvalidas() {
        ArrayList<Compra> res=new ArrayList<>();
        for(Compra c:this.comprasInvalidas)
            res.add(c.clone());
        return res;
    }
    /**
     * 
     * @return Relação mensal das compras
     */
    public int[] getComprasMes() {
        return this.comprasMes.clone();
    }
    /**
     * 
     * @return Relação mensal da faturação
     */
    public float[] getFaturacaoMensal() {
        return this.faturacaoMensal.clone();
    }
    /**
     * 
     * @return Número de compras inválidas
     */
    public int getnComprasInvalidas() {
        return this.nComprasInvalidas;
    }
    /**
     * Atualiza a relação mensal dos clientes compradores
     * @param clientesCompradoresMensal Nova relação mensal de Clientes Compradores
     */
    public void setClientesCompradoresMensal(int[] clientesCompradoresMensal) {
        this.clientesCompradoresMensal = clientesCompradoresMensal.clone();
    }
    /**
     * Atualiza a lista de Compras inválidas
     * @param comprasInvalidas Nova lista de compras inválidas
     */
    public void setComprasInvalidas(ArrayList<Compra> comprasInvalidas) {
        this.comprasInvalidas = new ArrayList<>();
        for(Compra c:comprasInvalidas)
            this.comprasInvalidas.add(c.clone());
        
    }
    /**
     * 
     * @return Faturação total registada
     */
    public float  faturacaoTotal(){
        float  total=0;
        for(int i=0;i<12;i++)
            total+=this.faturacaoMensal[i];
        return 0;
    }
    /**
     * Atualiza a relação mensal de compras
     * @param comprasMes Nova relaçao mensal de compras
     */
    public void setComprasMes(int[] comprasMes) {
        this.comprasMes = comprasMes.clone();
    }
    /**
     * Atualiza a relação mensal de faturação
     * @param faturacaoMensal Nova relação mensal de faturação
     */
    public void setFaturacaoMensal(float[] faturacaoMensal) {
        this.faturacaoMensal = faturacaoMensal.clone();
    }
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public StructureStats clone(){
        return new StructureStats(this.comprasMes, this.faturacaoMensal, this.clientesCompradoresMensal, this.comprasInvalidas, this.nComprasInvalidas);
    }
    
    /**
     * 
     * @return Representação textual da instância
     */
    public String toString(){
    
        StringBuilder sb=new StringBuilder();
        sb.append("Número de Compras Mensal: \n");
        for(int i=0;i<12;i++){
            sb.append(this.getComprasMes()[i]+" ");
        }
        sb.append("\n");
        sb.append("Faturação Mensal: \n");
        for(int i=0;i<12;i++){
            sb.append(this.getFaturacaoMensal()[i]+" ");
        }
        sb.append("\n");
        sb.append("Clientes Compradores em cada Mês: \n");
        for(int i=0;i<12;i++){
            sb.append(this.getClientesCompradoresMensal()[i]+" ");
        }
        sb.append("\n");
        sb.append("Número de compras invalidas ");
        
        sb.append(this.nComprasInvalidas);
        
        sb.append("\n");
        
        return sb.toString();
    }
}
