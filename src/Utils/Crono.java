package Utils;

/**
 * Crono = mede um tempo entre start() e stop()
 * O tempo é medido em nanosegundos e convertido para 
 *  um double que representa os segs na sua parte inteira.
 * 
 * @author FMM 
 * @version 1.0 / 2006
 */
public class Crono {

  private static long inicio = 0L;
  private static long fim = 0L;
  
/** inicia a contagem de tempo */
  public static void start() { 
      fim = 0L; inicio = System.nanoTime();  
  }
  
/**
 * 
 * @return Diferença entre início e o momento actual
 * 
 */
  public static double stop() { 
      fim = System.nanoTime();
      long elapsedTime = fim - inicio;
      double segs = elapsedTime / 1.0E09;
      return segs;
  }
  
/** 
 * 
 * 
 * @return Representação Textual do tempo decorrido
 *  */
  public static String print() {
      return "" + stop();
  }
}
