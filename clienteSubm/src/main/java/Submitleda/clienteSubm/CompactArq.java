package Submitleda.clienteSubm;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//- fazer funcionalidade que compacta todas as submissoes e manda para googledrive (ou dropbox)

public class CompactArq {
	
	
	public CompactArq(){
		
	}
	
	static final int tamanho_buffer = 4096;
	
	//BufferedInputStream: usado para armazenar dados de um fluxo de entrada;
	//metodo para compactar
	//FileInputStream: usado para ler arquivos.
	public void compactar(String arqSaida,String arqEntrada)throws Exception{
		int cont;
		byte[] dados = new byte[tamanho_buffer];
		
		BufferedInputStream origen = null;
		FileInputStream streamEntrada = null;
		FileOutputStream streamSaida = null;
		ZipOutputStream zipSaida = null;
		ZipEntry zipEntrada = null;
		
		try{
			streamSaida = new FileOutputStream(new File(arqSaida));
			zipSaida = new ZipOutputStream(new BufferedOutputStream(streamSaida));
			File file = new File(arqEntrada);
			
			//permissoes que por vista nao estao fucuinando
			file.setExecutable(true); //– true, permite executar operações; false para desabilitar.
		    file.setReadable(true); //– true, permite realizar operações de leitura; false para desabilitar.
		    file.setWritable(true); //– true, permite realizar operações de gravação; false para desabilitar.
		    		    
          
		    // pegando e zipando diretorios
            if(file.isDirectory()){
                for (File arquivos : file.listFiles()) {
                    streamEntrada = new FileInputStream(arquivos);
                    origen = new BufferedInputStream(streamEntrada, tamanho_buffer);
                    zipEntrada = new ZipEntry(arquivos.getName());
                    zipSaida.putNextEntry(zipEntrada);
                    while((cont = origen.read(dados, 0,tamanho_buffer)) != -1) {
                        zipSaida.write(dados, 0, cont);
                    }
                }
                // just arquivos
            }else{
                streamEntrada = new FileInputStream(file);
                origen = new BufferedInputStream(streamEntrada, tamanho_buffer);
                zipEntrada = new ZipEntry(file.getName());
                zipSaida.putNextEntry(zipEntrada);
                while((cont = origen.read(dados, 0, tamanho_buffer)) != -1) {
                    zipSaida.write(dados, 0, cont);
                }
            } 
                       
            //while((cont = origen.read(dados, 0, tamanho_buffer)) != -1) {
              //  zipSaida.write(dados, 0, cont);
            //}
            origen.close();
            zipSaida.close();
			
		}catch(IOException e){
			throw new IOException(e.getMessage());
			
		}
		
	}
	public static void main(String args[]) throws Exception{
		CompactArq comp = new CompactArq();
	       try {
	    	   comp.compactar("/home/lordsith//zipado.zip", "/home/lordsith/zipad");
	           //comp.compactar("zipado", "exe");// tenho que ver essa parte ai que ta dando umas excessoes estranhas
	           //  ioexception permissao negada ver o que é isso
	       } catch (IOException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
	   }

}
