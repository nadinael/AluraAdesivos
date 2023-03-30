import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Catalogo {

  public void listarFilmes(List<Filme> filmes) {
    for (int i = 0; i < filmes.size(); i++) {
      System.out.print(Estilo.ini() + Estilo.bold());
      System.out.print(Estilo.bgBlack() + Estilo.textCian());

      System.out.println("Filme: " + filmes.get(i).getTitulo());

      System.out.print(Estilo.textWhite());

      System.out.println("Ano: " + +filmes.get(i).getAno() + "   Analises: " +
          filmes.get(i).getImdbCount());
      System.out.println("Poster: " + filmes.get(i).getUrlImage());
      double nota = filmes.get(i).getNota();
      System.out.print("Nota: " + filmes.get(i).getNota() + " ");
      for (int y = 0; y < nota; y++) {
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

  }

  public Catalogo() {

  }
}