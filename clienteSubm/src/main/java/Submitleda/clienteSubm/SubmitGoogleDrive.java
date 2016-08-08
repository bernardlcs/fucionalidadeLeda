package Submitleda.clienteSubm;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;

//import com.google.api.client.json.jackson.JacksonFactory;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//import com.google.api.services.drive.model.File;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;

public class SubmitGoogleDrive {
	
	//adicione aqui o CLIENT_ID que nós criamos 
	private static String CLIENT_ID	="CLIENT_ID AQUI"; //adicione aqui o CLIENT_SECRET que nós criamos 
	private	static String CLIENT_SECRET	="CLIENT_SECRET AQUI"; //a REDIRECT_URI vai ser a mesma sempre (provavelmente) 
	private	static String REDIRECT_URI ="urn:ietf:wg:oauth:2.0:oob"; 
	
}

