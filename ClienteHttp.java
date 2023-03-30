import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {

  public String buscarDados(String url) {
    System.out.println("buscando.");
    System.out.println(url);
    try {
      URI endereco = URI.create(url);
      HttpClient cliente = HttpClient.newHttpClient();
      HttpRequest requisicao = HttpRequest.newBuilder(endereco).GET().build();
      HttpResponse<String> resposta = cliente.send(requisicao, BodyHandlers.ofString());
      System.out.println("RESPOSTA");
      System.out.println(resposta.body());
      return resposta.body();

    } catch (IOException ex) {
      ex.getStackTrace();
      return null;
    } catch (InterruptedException ex) {
      ex.getStackTrace();
      return null;
    }
  }

  public ClienteHttp() {

  }
}