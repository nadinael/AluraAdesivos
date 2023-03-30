import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws Exception {
    var sis = new Sistema();
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "O QUE VOCE DESEJA FAZER? \n 1 = GERAR FIGURAS DA NASA, 2 = GERAR FIGURAS DOS MELHORES FILMES, 3 = LISTAR OS MELHORES FILMES DO IMDB.");
    char ch = sc.next().charAt(0);

    switch (ch) {
      case '1':
        sis.fabricarFigurasNasa();
        break;
      case '2':
        sis.fabricarFigurasImdb();
        break;
      default:
        sis.listarFilmes();
        break;

    }

    System.out.println("\u001b[3m Fim do programa!");
    sc.close();
  }
}