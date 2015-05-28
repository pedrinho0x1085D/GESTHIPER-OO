
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class StructureStats {
    private int comprasMes[];
    private float faturacaoMensal[];
    private int clientesCompradoresMensal[];
    private ArrayList<Compra> comprasInvalidas;
    private int nComprasInvalidas;

    public StructureStats(){
        this.comprasMes = new int[12];
        this.faturacaoMensal = new float[12];
        this.clientesCompradoresMensal = new int[12];
        this.comprasInvalidas = new ArrayList<>();
        this.nComprasInvalidas = 0;
    }
    
    public StructureStats(int[] comprasMes, float[] faturacaoMensal, int[] clientesCompradoresMensal, ArrayList<Compra> comprasInvalidas,int nComprasInvalidas) {
        this.comprasMes = comprasMes;
        this.faturacaoMensal = faturacaoMensal;
        this.clientesCompradoresMensal = clientesCompradoresMensal;
        this.comprasInvalidas = new ArrayList<>();
        for(Compra c:comprasInvalidas)
            this.comprasInvalidas.add(c.clone());
        this.nComprasInvalidas = nComprasInvalidas;
    }
    

     public int[] getClientesCompradoresMensal() {
        return this.clientesCompradoresMensal.clone();
    }

    public ArrayList<Compra> getComprasInvalidas() {
        ArrayList<Compra> res=new ArrayList<>();
        for(Compra c:this.comprasInvalidas)
            res.add(c.clone());
        return res;
    }

    public int[] getComprasMes() {
        return this.comprasMes.clone();
    }
    
    public float[] getFaturacaoMensal() {
        return this.faturacaoMensal.clone();
    }
    
    public int getnComprasInvalidas() {
        return this.nComprasInvalidas;
    }

    public void setClientesCompradoresMensal(int[] clientesCompradoresMensal) {
        this.clientesCompradoresMensal = clientesCompradoresMensal.clone();
    }

    public void setComprasInvalidas(ArrayList<Compra> comprasInvalidas) {
        this.comprasInvalidas = new ArrayList<>();
        for(Compra c:comprasInvalidas)
            this.comprasInvalidas.add(c.clone());
        
    }
    
    public float  faturacaoTotal(){
        float  total=0;
        for(int i=0;i<12;i++)
            total+=this.faturacaoMensal[i];
        return 0;
    }

    public void setComprasMes(int[] comprasMes) {
        this.comprasMes = comprasMes.clone();
    }

    public void setFaturacaoMensal(float[] faturacaoMensal) {
        this.faturacaoMensal = faturacaoMensal.clone();
    }

    public StructureStats clone(){
        return new StructureStats(this.comprasMes, this.faturacaoMensal, this.clientesCompradoresMensal, this.comprasInvalidas, this.nComprasInvalidas);
    }
    
    
    public String toString(){
    
        StringBuilder sb=new StringBuilder();
        sb.append("Número de Compras Mensal: \n");
        for(int i=0;i<12;i++){
            sb.append(this.getComprasMes()[i]);
        }
        sb.append("\n");
        sb.append("Faturação Mensal: \n");
        for(int i=0;i<12;i++){
            sb.append(this.getFaturacaoMensal()[i]);
        }
        sb.append("\n");
        sb.append("Clientes Compradores em cada Mês: \n");
        for(int i=0;i<12;i++){
            sb.append(this.getClientesCompradoresMensal()[i]);
        }
        sb.append("\n");
        sb.append("Número de compras invalidas");
        // VER MELHOR, qual das duas seguintes esta correta
        sb.append(this.nComprasInvalidas);
        sb.append(this.getnComprasInvalidas());
        sb.append("\n");
        
        return sb.toString();
    }
}
