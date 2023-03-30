import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Sistema {
  // classe que vai gerenciar as funcoes do sistema
  ServidorAPI api;
  ClienteHttp http;

  public void fabricarFigurasNasa() {
    String corpo = http.buscarDados(api.getNasaApi());
    var ext = new ExtratorConteudoNasa();
    List<Conteudo> conteudos = ext.extrairConteudo(corpo);
    int qtpics = 0;
    var fabrica = new FabricaDeFiguras();
    try {
      for (int i = 0; i < 3; i++) {
        Conteudo conteudo = conteudos.get(i);
        InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
        String nomeArquivo = conteudo.getTitulo();
        if (qtpics < 5) {
          fabrica.criar(inputStream, nomeArquivo);
        }
        qtpics++;

      }

    } catch (MalformedURLException ex) {
      System.out.println(ex.getStackTrace());
    } catch (IOException ex) {
      ex.getStackTrace();
    } catch (Exception ex) {
      ex.getStackTrace();
    }
    // trecho para limitar o uso da memoria em testes.

  }

  public void fabricarFigurasImdb() {
    String corpo = http.buscarDados(api.getApiAlternativa());
    var ext = new ExtratorConteudoImdb();
    List<Conteudo> conteudos = ext.extrairConteudo(corpo);
    int qtpics = 0;
    var fabrica = new FabricaDeFiguras();

    try {
      for (int i = 0; i < 3; i++) {
        Conteudo conteudo = conteudos.get(i);
        InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
        String nomeArquivo = conteudo.getTitulo();
        if (qtpics < 5) {
          fabrica.criar(inputStream, nomeArquivo);
        }
        // trecho para limitar o uso da memoria em testes.
        qtpics++;

      }

    } catch (MalformedURLException ex) {
      ex.getStackTrace();
    } catch (IOException ex) {
      ex.getStackTrace();
    } catch (Exception ex) {
      ex.getStackTrace();
    }

  }

  public void listarFilmes() {
    String corpo = http.buscarDados(api.getApiAlternativa());
    var ext = new ExtratorConteudoImdb();
    List<Filme> filmes = ext.extrairFilmes(corpo);
    Catalogo catalogo = new Catalogo();
    catalogo.listarFilmes(filmes);

  }

  public Sistema() {
    this.api = new ServidorAPI();
    this.http = new ClienteHttp();
  }
}