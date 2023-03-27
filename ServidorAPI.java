import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ServidorAPI {
  Properties propriedades;

  private void configurar() {
    String caminho = System.getProperty("user.dir");
    caminho = caminho + "/apis.properties";
    try {
      InputStream inputStream = new FileInputStream(caminho);
      propriedades.load(inputStream);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String getMoviedbAPI() {
    return propriedades.getProperty("api-moviedb");
  }

  public String getAluraFilmesAPI() {
    return propriedades.getProperty("api-alura");
  }

  public String getSHBase() {
    return propriedades.getProperty("api-herois-chave");
  }

  public String getAluraTop2() {
    return propriedades.getProperty("api-movies");
  }
public String getApiAlternativa() {
    return propriedades.getProperty("api-luska");
  }
  

  ServidorAPI() {
    propriedades = new Properties();
    configurar();
    System.out.println("construtor executado.");
  }
}