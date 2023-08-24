package Cadena_Caracteres;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author Emanuel
 */
public class Cadena {
    
    public int conteoA(String entrada){
        int cantidad = 0;
        char letra ;
        for(int i=0;i<entrada.length();i++){
            letra = entrada.charAt(i);
            if(letra == 'A'||letra == 'Á'||letra == 'a'||letra == 'á'){
                cantidad += 1;
            }  
        }  
    return cantidad;   
    }
    public int conteoE(String entrada){
        int cantidad = 0;
        char letra ;
        for(int i=0;i<entrada.length();i++){
            letra = entrada.charAt(i);
            if(letra == 'E'||letra == 'É'||letra == 'e'||letra == 'é'){
                cantidad += 1;
            }  
        }  
    return cantidad;   
    }
    public int conteoI(String entrada){
        int cantidad = 0;
        char letra ;
        for(int i=0;i<entrada.length();i++){
            letra = entrada.charAt(i);
            if(letra == 'I'||letra == 'Í'||letra == 'i'||letra == 'i'){
                cantidad += 1;
            }  
        }  
    return cantidad;   
    }
    public int conteoO(String entrada){
        int cantidad = 0;
        char letra ;
        for(int i=0;i<entrada.length();i++){
            letra = entrada.charAt(i);
            if(letra == 'O'||letra == 'Ó'||letra == 'o'||letra == 'Ó'){
                cantidad += 1;
            }  
        }  
    return cantidad;   
    }
    public int conteoU(String entrada){
        int cantidad = 0;
        char letra ;
        for(int i=0;i<entrada.length();i++){
            letra = entrada.charAt(i);
            if(letra == 'U'||letra == 'Ú'||letra == 'u'||letra == 'ú'){
                cantidad += 1;
            }  
        }  
    return cantidad;   
    }
    public String par_impar(String entrada){
        int par = 0;
        int impar = 0;
        String[] palabras_separada = entrada.split(" ");
        for (int i = 0; i< palabras_separada.length; i++){
            if ((palabras_separada[i].length()% 2) == 0 ) {
                par ++;
            }else {
                impar ++;
            }
        }
            String resultado = par+";"+impar; 
    return resultado;
    }
    
   public String leer_fichero(){
       String resultado = "";
       File archivo_seleccionado;
       JFileChooser seleccionar_archivo;
       seleccionar_archivo = new JFileChooser();
       seleccionar_archivo.showOpenDialog(null);
       archivo_seleccionado = seleccionar_archivo.getSelectedFile();
       String ruta = archivo_seleccionado.getAbsolutePath();
       
       FileReader archivo;
       BufferedReader leer;
       try {
           archivo = new FileReader(ruta);
           if (archivo.ready()) {
               leer = new BufferedReader(archivo);
               String contenido;

               while((contenido = leer.readLine())!=null){
                   resultado += contenido;
               }
                return resultado; 
           }
           
       } catch (Exception e) {
       }
       
       
       return resultado;
   }
 
   public String guardar(String entrada) throws FileNotFoundException{
    try {
            String ruta = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Manejo_cadena\\Codificadordefault.txt";
            String contenido = entrada;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    return "Listo";
   }
   
      public void guardar_como(String entrada) throws FileNotFoundException{
          

          JFileChooser guardar = new JFileChooser();
          guardar.showSaveDialog(null);
          guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          File archivo = guardar.getSelectedFile();
          
          String nombre = guardar.getSelectedFile().getName();
          String extension = ".txt";
          String ruta = archivo.getAbsoluteFile().toString()+ extension;
          
          System.out.println(archivo.getAbsoluteFile());
          System.out.println(archivo.getAbsolutePath());
          System.out.println(guardar.getSelectedFile());
          System.out.println(nombre);
          

          
           try {
            String contenido = entrada;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
       
   }
   
   public void copiar(String entrada){
       Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
       StringSelection str = new StringSelection(entrada);
       clip.setContents(str, null);
       
   }
   public String pegar() throws UnsupportedFlavorException, IOException{
       Transferable tr = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
     
       return (String) tr.getTransferData(DataFlavor.stringFlavor).toString();
   }
   public String reemplazar(String entrada, String palabra_buscada, String palabra_reemplazada){
       
       return entrada.replace(palabra_buscada, palabra_reemplazada);
           
   }
      
   public String busqueda(String entrada, String busqueda){
       
     String[] palabras = entrada.split(" ");
        int contador = 0;
        for (String palabra : palabras) {
            if (palabra.equals(busqueda)) {
            contador += 1;
            
        }
    }  
       return "Total de Palabras encontrada: "+ contador;
   }
}