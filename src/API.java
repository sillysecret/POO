

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Arrays;



public class API {
    public double setRequestMethod(Carga carga) {
        String [] origem = carga.getOrigem().getNomeCidade().split(" ");
        String [] destino =carga.getDestino().getNomeCidade().split(" ");

        String resultado =  Arrays.stream(origem)
                .reduce((s1, s2) -> s1 + "+" + s2)
                .orElse("");
        String resultado2 =  Arrays.stream(destino)
                .reduce((s1, s2) -> s1 + "+" + s2)
                .orElse("");


        URI URL = URI.create("https://maps.googleapis.com/maps/api/directions/json?origin="+resultado+"&destination="+resultado2+"&key=SUAKEYAKI");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .GET()
          .timeout(Duration.ofSeconds(10))
          .uri(URL)
          .build();
        
          HttpResponse<String> response;
          try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
             String dados = response.body();



              JSONObject object = new JSONObject (dados.toString());
              JSONArray routes = object.getJSONArray("routes");
              JSONObject routesObject = routes.getJSONObject(0);
              JSONArray legs = routesObject.getJSONArray("legs");
              JSONObject legsObject = legs.getJSONObject(0);
              JSONObject Distancedata = legsObject.getJSONObject("distance");
              Double meters = Distancedata.getDouble("value");

              System.out.println(Distancedata.toString());

              return meters/1000;
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
            
            return -1;
           
          }
        }
