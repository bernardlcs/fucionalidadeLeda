package Submitleda.clienteSubm;

//Include the Dropbox SDK.
import com.dropbox.core.*;
import com.google.api.services.drive.Drive.*;
import com.google.api.services.drive.Drive.Files.List;

import java.io.*;
import java.util.Locale;

public class SubmitDropbox {
	
	public static void main(String args[])throws IOException, DbxException{
		// sua chave app e secreto do site do Dropbox
        final String APP_KEY = "dho77myara6s9sz"; // app key
        final String APP_SECRET = "ct3p7d7nd4mwlv6"; // app secretct
        
        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig(
            "JavaTutorial/1.0", Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
        
        String authorizeUrl = webAuth.start();
        System.out.println("1. Go to: " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first)");
        System.out.println("3. Copy the authorization code.");
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
      //Se você rodar a aplicação novamente, o code gerado acima é inválido e será preciso criar um novo.
        
        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = authFinish.accessToken;
        DbxClient client = new DbxClient(config, accessToken);
       // System.out.println("Linked account: " + client.getAccountInfo().displayName);//dando erro aqui
        
        
        // uploud
        
        DbxClient client1 = new DbxClient(config, accessToken);


        //System.out.println("Linked account: " + client1.getAccountInfo().displayName);
        // colocar o arquivo
        File inputFile = new File("/home/lordsith/zipado.zip");
        FileInputStream inputStream = new FileInputStream(inputFile);
        try {
        	
            DbxEntry.File uploadedFile = client1.uploadFile("/home/lordsith/zipado.zip",
                DbxWriteMode.add(), inputFile.length(), inputStream);
            System.out.println("Uploaded: " + uploadedFile.toString());
        } finally {
            inputStream.close();
        }

        DbxEntry.WithChildren listing = client1.getMetadataWithChildren("/");
        System.out.println("Files in the root path:");
        for (DbxEntry child : listing.children) {
            System.out.println("	" + child.name + ": " + child.toString());
        }

        //download 
        /*FileOutputStream outputStream = new FileOutputStream("/home/lordsith/zipado.zip");
        try {
            DbxEntry.File downloadedFile = client1.getFile("/home/lordsith/zipado.zip", null,
                outputStream);
            System.out.println("Metadata: " + downloadedFile.toString());
        } finally {
            outputStream.close();
        }*/
    }
}