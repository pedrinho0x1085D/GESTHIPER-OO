package Business;


import java.io.Serializable;
import java.util.Arrays;


/**
 * Nodo de Cliente Comprador
 * <p>Um nodo de Cliente Comprador terá as seguintes informações</p>
 * <ul>
 * <li>Código de Cliente</li>
 * <li>Quantidade comprada por mês por modo</li>
 * <li>Faturação mensal por modo</li>
 * </ul>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class NodoClienteComprador implements Serializable{
    private String codigoC;
    private int qtdCompradaN[],qtdCompradaP[];
    private float valorN[],valorP[];
    /**
     * Construtor Vazio
     */
    public NodoClienteComprador() {
    this.codigoC="";
    this.qtdCompradaN=new int[12];
    this.qtdCompradaP=new int[12];
    this.valorN=new float[12];
    this.valorP=new float[12];
    }
    /**
     * Construtor Parametrizado
     * @param code Código de Cliente
     */
    public NodoClienteComprador(String code) {
    this.codigoC=code;
    this.qtdCompradaN=new int[12];
    this.qtdCompradaP=new int[12];
    this.valorN=new float[12];
    this.valorP=new float[12];
    }
    /**
     * Construtor Parametrizado
     * @param codigoC Código de Cliente
     * @param qtdCompradaN Quantidade Comprada em Modo Normal
     * @param qtdCompradaP Quantidade Comprada em Modo Promocional
     * @param valorN Valor Faturado em Modo Normal
     * @param valorP Valor Faturado em Modo Promocional
     */
    public NodoClienteComprador(String codigoC, int[] qtdCompradaN, int[] qtdCompradaP, float[] valorN, float[] valorP) {
        this.codigoC = codigoC;
        this.qtdCompradaN = qtdCompradaN;
        this.qtdCompradaP = qtdCompradaP;
        this.valorN = valorN;
        this.valorP = valorP;
    }
    /**
     * Construtor de Cópia
     * @param ncc NodoClienteComprador a ser copiado
     */
    public NodoClienteComprador(NodoClienteComprador ncc){
        this.codigoC=ncc.getCodigoC();
        this.qtdCompradaN=ncc.getQtdCompradaN();
        this.qtdCompradaP=ncc.getQtdCompradaP();
        this.valorN=ncc.getValorN();
        this.valorP=ncc.getValorP();
    }

    /**
     * 
     * @return Código de Cliente
     */
    public String getCodigoC() {
        return this.codigoC;
    }
    /**
     * 
     * @return Quantidade Comprada Mensalmente em Modo Normal
     */
    public int[] getQtdCompradaN() {
        return this.qtdCompradaN.clone();
    }
    /**
     * 
     * @return Quantidade Comprada Mensalmente em Modo Promocional
     */
    public int[] getQtdCompradaP() {
        return this.qtdCompradaP.clone();
    }
    /**
     * 
     * @return Valor Faturado Mensalmente em Modo Normal
     */
    public float[] getValorN() {
        return this.valorN.clone();
    }
    /**
     * 
     * @return Valor Faturado Mensalmente em Modo Promocional
     */
    public float[] getValorP() {
        return this.valorP.clone();
    }
    /**
     * Atualiza o Código de Cliente
     * @param codigoC Código de Cliente a ser atualizado
     */
    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }
    /**
     * Modifica a quantidade comprada mensalmente em modo Normal
     * @param qtdCompradaN Nova quantidade comprada mensalmente em modo normal
     */
    public void setQtdCompradaN(int[] qtdCompradaN) {
        this.qtdCompradaN = qtdCompradaN.clone();
    }
    /**
     * Modifica a quantidade comprada mensalmente em modo Promocional
     * @param qtdCompradaP Nova quantidade comprada mensalmente em modo promocional
     */
    public void setQtdCompradaP(int[] qtdCompradaP) {
        this.qtdCompradaP = qtdCompradaP.clone();
    }
    /**
     * Modifica o valor faturado mensalmente em modo Normal
     * @param valorN Novo valor faturado mensalmente em modo Normal
     */
    public void setValorN(float[] valorN) {
        this.valorN = valorN.clone();
    }

    /**
     * Modifica o valor faturado mensalmente em modo Promocional
     * @param valorP Novo valor faturado mensalmente em modo Promocional
     */
    public void setValorP(float[] valorP) {
        this.valorP = valorP.clone();
    }
    /**
     * 
     * @return Quantidade Comprada Anual
     */
    public int getQuantidadeTotal(){
        int total=0;
        for(int i=0;i<12;i++){
            total+=this.qtdCompradaN[i];
            total+=this.qtdCompradaP[i];
        }
        return total;
    }
    /**
     * 
     * @return Valor Faturado Anual
     */
    public float getFaturacaoTotal(){
        float total=0;
        for(int i=0;i<12;i++){
            total+=this.valorN[i];
            total+=this.valorP[i];
        }
        return total;
    }
    /**
     * 
     * @param modo Modo a ser consultado
     * @param mes Mês a ser consultado
     * @return Quantidade Comprada No mês e no modo especificados
     */
    public int getCompraMes(char modo, int mes){
        if(modo=='P') return this.qtdCompradaP[mes-1];
        else if(modo=='N') return this.qtdCompradaN[mes-1];
        else return 0;
    }
    /**
     * 
     * @param modo Modo a ser consultado
     * @param mes Mês a ser consultado
     * @return Faturação Registada No mês e no modo especificados
     */
    public float getFaturacaoMes(char modo, int mes){
        if(modo=='P') return this.valorP[mes-1];
        else if(modo=='N') return this.valorN[mes-1];
        else return 0;
    }
    /**
     * Incrementa o valor faturado dado pelo valor unitário e quantidade comprada
     * @param modo Modo de compra
     * @param mes Mês
     * @param qtd Quantidade Comprada
     * @param valor Valor unitário
     */
    public void incrementaValor(char modo,int mes,int qtd,float valor){
        if(modo=='P') {this.valorP[mes-1]+=qtd*valor;}
        else if(modo=='N') {this.valorN[mes-1]+=qtd*valor;}
    }
    /**
     * Incrementa a quantidade Comprada no mes e modo especificados
     * @param modo Modo de compra
     * @param mes Mês
     * @param qtd Quantidade Comprada
     */
    public void incrementaQtd(char modo, int mes,int qtd){
        if(modo=='P') {this.qtdCompradaP[mes-1]+=qtd;}
        else if(modo=='N') {this.qtdCompradaN[mes-1]+=qtd;}
    }
    
    
    /**
     * 
     * @return HashCode do Objecto
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigoC,this.qtdCompradaN,this.qtdCompradaP,this.valorN,this.valorP});
    }
    
    /**
     * 
     * @return Cópia da instância actual
     */
    public NodoClienteComprador clone(){
        return new NodoClienteComprador(this);
    }
    /**
     * Teste de igualdade entre a instância e o objecto passado como parâmetro
     * @param obj Objecto a ser testado
     * @return Resultado do teste de igualdade
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        NodoClienteComprador e = (NodoClienteComprador) obj;
        return (this.codigoC.equals(e.getCodigoC()) && this.qtdCompradaN.equals(e.getQtdCompradaN()) && this.qtdCompradaP.equals(e.getQtdCompradaP()) && this.valorN.equals(e.getValorN()) && this.valorP.equals(e.getValorP()));
    }
}
