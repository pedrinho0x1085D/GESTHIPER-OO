
import java.util.Arrays;



/**
 * Par código Quantidade
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ParCodigoQuantidade {
    private String codigo;
    private int quantidade;
    /**
     * Construtor Vazio
     */
    public ParCodigoQuantidade() {
    this.codigo="";
    this.quantidade=0;
    }
    /**
     * Construtor Parametrizado
     * @param codigo Código 
     * @param quantidade Quantidade
     */
    public ParCodigoQuantidade(String codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }
    /**
     * Construtor de Cópia
     * @param pcq Par a ser copiado
     */
    public ParCodigoQuantidade(ParCodigoQuantidade pcq){
        this.codigo=pcq.getCodigo();
        this.quantidade=pcq.getQuantidade();
    }
    /**
     * 
     * @return Código
     */
    public String getCodigo() {
        return this.codigo;
    }
    /**
     * 
     * @return Quantidade
     */
    public int getQuantidade() {
        return this.quantidade;
    }
    /**
     * Atualiza o código
     * @param codigo Novo Código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Atualiza a quantidade 
     * @param quantidade Nova quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Teste de Igualdade
     * @param o Objecto a ser testado
     * @return True se <i>this</i> e <i>o</i> forem semanticamente iguais, False caso contrário
     */
    public boolean equals(Object o){
        if(this==o) return true;
        else if((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName())))||o==null) return false;
        else{
            ParCodigoQuantidade pcq=(ParCodigoQuantidade) o;
            return (this.codigo.equals(pcq.getCodigo()))&&(this.quantidade==pcq.getQuantidade());
        }
    }
    /**
     * 
     * @return HashCode do par
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.codigo,this.quantidade});
    }
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public ParCodigoQuantidade clone(){
        return new ParCodigoQuantidade(this);
    }
    /**
     * 
     * @return Representação textual da Instância
     */
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       sb.append("Código ");
       sb.append(this.codigo);
       sb.append("\n");
       sb.append("Quantidade ");
       sb.append(this.quantidade);
       sb.append("\n");
       return sb.toString();
    }
}