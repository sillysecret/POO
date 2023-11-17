package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.JSONArray;
import org.json.JSONObject;



public class API {
    public void setRequestMethod() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .GET()
          .timeout(Duration.ofSeconds(10))
          .uri(URI.create("https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood&key=AIzaSyCVdUBvL4qKPFp5XgGcYwW3P6OtlrqJ0i4"))
          .build();
        
          HttpResponse<String> response;
          try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
             String dados = response.body();



              JSONObject object = new JSONObject (dados.toString());
              System.out.println(dados.toString());
              object = new JSONObject (object.get("routes").toString());
              object = new JSONObject (object.get("legs").toString());
              System.out.println(object.toString());


          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
            

           
          }
        }
