package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class ApiFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IOException {
        String getJson=getJsonFormApi(urlString);
        try {
            return parseJson(getJson, attributeName);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON", e);
        }
    }

    private String getJsonFormApi(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try(BufferedReader in =new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            }finally {
                connection.disconnect();
            }
        } catch (Exception e) {
            throw new IOException("Failed to fetch or read from URL: " + urlString, e);
        }
    }
    private String parseJson(String json,String attributeName) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        Object value = jsonObject.get(attributeName);
        if (value == null) {
            throw new IllegalArgumentException("Attribute not found in JSON");
        }
        return value.toString();
    }
}
