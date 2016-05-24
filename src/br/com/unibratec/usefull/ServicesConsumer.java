package br.com.unibratec.usefull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServicesConsumer {
	
public String executePost(Player p){
		
		String targetURL = "http://localhost:9010/casino/players/add";
		
		ObjectMapper mapper = new ObjectMapper();
		
		String urlParameters = null;
		
		try {
			urlParameters = mapper.writeValueAsString(p);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    URL url;
	    HttpURLConnection connection = null;  
	    try {
	      //Create connection
	      url = new URL(targetURL);
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", 
	           "application/json");
				
	      connection.setRequestProperty("Player", urlParameters) ;
	                
				
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();

	      //Get Response	
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      return response.toString();

	    } catch (Exception e) {

	      e.printStackTrace();
	      return null;

	    } finally {	

	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
	    
	  }

	public List<Player> getList(){


		URL url;  

		ObjectMapper mapper = new ObjectMapper();
		List<Player> players =  new ArrayList<Player>(); 

		try {

			url = new URL("http://localhost:9010/casino/players/list");			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();

			JsonFactory factory = new JsonFactory();
			factory.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false); // all configuration before use
			JsonParser jp = factory.createParser(is);


			JsonNode actualObj = mapper.readTree(jp);

			for (int x = 0; x < actualObj.size(); x++) {

				Player p = mapper.convertValue(actualObj.get(x), Player.class);
				players.add(p);

			}

		} catch (Exception e) {

			return null;
		}


		return players;
	}	  

}
