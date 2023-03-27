import java.util.*;

//import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

class Main {
  public static void main(String[] args) throws IOException, Exception {
    ServidorAPI sAPI = new ServidorAPI();
    URI endereco = URI.create(sAPI.getAluraFilmesAPI());
    HttpClient cliente = HttpClient.newHttpClient();
    HttpRequest requisicao = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> resposta = cliente.send(requisicao, BodyHandlers.ofString());
    String corpo = resposta.body();
    JsonParser parser = new JsonParser();
    List<Map<String, String>> filmes = parser.extrair(corpo);

    System.out.println(filmes.size());
    for (Map<String, String> filme : filmes) {
      System.out.println(filme.get("title"));
      System.out.println(filme.get("image"));
      System.out.println(filme.get("imDbRating"));
      System.out.println();
    }
    System.out.println("Fim do programa!");
  }
}