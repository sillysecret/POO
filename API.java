import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {
    public void setRequestMethod() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .GET()
          .timeout(Duration.ofSeconds(10))
          .uri(URI.create("https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood&key=AIzaSyCVdUBvL4qKPFp5XgGcYwW3P6OtlrqJ0i4"))
          .build();
        
          HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            System.out.println(body);
          }
        }
