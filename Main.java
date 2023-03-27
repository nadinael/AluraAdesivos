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
    URI endereco = URI.create(sAPI.getApiAlternativa());
    HttpClient cliente = HttpClient.newHttpClient();
    HttpRequest requisicao = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> resposta = cliente.send(requisicao, BodyHandlers.ofString());
    String corpo = resposta.body();
    JsonParser parser = new JsonParser();
    List<Map<String, String>> filmes = parser.extrair(corpo);

    System.out.println(filmes.size());
    for (Map<String, String> filme : filmes) {
      System.out.print(Estilo.ini() + Estilo.bold());
      System.out.print(Estilo.bgBlack() + Estilo.textCian());
      System.out.println("Filme: " + filme.get("title"));
      System.out.print(Estilo.textWhite());
      System.out.println("Poster: " + filme.get("image"));
      double nota = Double.parseDouble(filme.get("imDbRating"));
      System.out.print("Nota: " + nota + " ");
      for (int i = 0; i < nota; i++) {
        System.out.print("🌟");
      }
      /*
       * if (nota >= 9) {
       * System.out.print(" 👍");
       * } else {
       * System.out.print(" 👎");
       * }
       */

      System.out.println();
    }
    System.out.println("\u001b[3m Fim do programa!");
  }
}