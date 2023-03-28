import java.net.URI;
import java.net.URL;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    // System.out.println(filmes.size()); tamanho da lista (250)

    // exibir a resposta da api formatada.
    var fabrica = new FabricaDeFiguras();
    // trecho para limitar o uso da memoria em testes.
    int qtpics = 0;
    for (Map<String, String> filme : filmes) {
      String urlImagem = filme.get("image");
      urlImagem = urlImagem.replace("._V1_UX128_CR0,12,128,176_AL_", "");
      String titulo = filme.get("title");

      InputStream inputStream = new URL(urlImagem).openStream();
      String nomeArquivo = titulo + ".png";
      if (qtpics < 5) {
        fabrica.criar(inputStream, nomeArquivo);
      }
      // trecho para limitar o uso da memoria em testes.
      qtpics++;

      System.out.print(Estilo.ini() + Estilo.bold());
      System.out.print(Estilo.bgBlack() + Estilo.textCian());

      System.out.println("Filme: " + titulo);

      System.out.print(Estilo.textWhite());

      System.out.println("Ano: " + filme.get("year") + "   Analises: " + filme.get("imDbRatingCount"));
      System.out.println("Poster: " + urlImagem);
      double nota = Double.parseDouble(filme.get("imDbRating"));
      System.out.print("Nota: " + nota + " ");
      for (int i = 0; i < nota; i++) {
        System.out.print("🌟");
      }

      if (nota >= 9) {
        System.out.print(" 👍");
      } else {
        System.out.print(" 👎");
      }

      System.out.println();
      System.out.println();
    }

    System.out.println("\u001b[3m Fim do programa!");
  }
}