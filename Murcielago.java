
package codificador_murcielago;

/**
 *
 * @author Emanuel
 */
public class Murcielago {
    
    
   public String codificadorAvanzado(String valorEntrada){
        int tamanoEntrada = valorEntrada.length();
        String letra="";
        String resultado = "";
        
        for(int i=0;i<tamanoEntrada;i++){
            letra = String.valueOf(valorEntrada.charAt(i));            
            resultado += codificadorMurcielago(letra);
        }
        return resultado;
    }
   
    public String codificadorMurcielago(String letra){
      
        switch (letra.toUpperCase()) {
          case "M":
            return "0";
            
          case "U":
            return "1";
            
            
            case "R":
            return "2";
            
            
            case "C":
            return "3";
            
            
            case "I":
            return "4";
            
            case "E":
            return "5";
            
            case "L":
            return "6";
            
            case "A":
            return "7";
            
            case "G":
            return "8";
            
            case "O":
            return "9";
            
          default:
            return letra.toUpperCase();
        }
        
    }
    
}
