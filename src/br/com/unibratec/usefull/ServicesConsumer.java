package br.com.unibratec.usefull;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServicesConsumer {

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
