import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb {

  public List<Conteudo> extrairConteudo(String json) {
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributos = parser.extrair(json);
    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listaAtributos) {

      String urlImagem = atributos.get("image");
      urlImagem = urlImagem.replace("._V1_UX128_CR0,12,128,176_AL_", "");
      var conteudo = new Conteudo(atributos.get("title"), urlImagem);
      conteudos.add(conteudo);
    }

    return conteudos;
  }

  public List<Filme> extrairFilmes(String json) {
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributos = parser.extrair(json);
    List<Filme> filmes = new ArrayList<>();

    for (Map<String, String> atributos : listaAtributos) {

      String urlImagem = atributos.get("image");
      double nota = Double.parseDouble(atributos.get("imDbRating"));
      int ano = Integer.parseInt(atributos.get("year"));
      int imdbCount = Integer.parseInt(atributos.get("imDbRatingCount"));
      urlImagem = urlImagem.replace("._V1_UX128_CR0,12,128,176_AL_", "");
      var filme = new Filme(atributos.get("title"), urlImagem, nota, ano, imdbCount);
      // Filme(String titulo, String urlImage, double nota, int ano, int imdbCount)
      filmes.add(filme);
    }

    return filmes;
  }

  public ExtratorConteudoImdb() {

  }
}