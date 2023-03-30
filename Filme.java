public class Filme {
  private final String titulo;
  private final String urlImage;
  private final double nota;
  private int ano;
  private int imdbCount;

  public String getTitulo() {
    return this.titulo;
  }

  public String getUrlImage() {
    return this.urlImage;
  }

  public double getNota() {
    return this.nota;
  }

  public double getAno() {
    return this.ano;
  }

  public int getImdbCount() {
    return this.imdbCount;
  }

  public Filme(String titulo, String urlImage, double nota, int ano, int imdbCount) {
    this.titulo = titulo;
    this.urlImage = urlImage;
    this.nota = nota;
    this.ano = ano;
    this.imdbCount = imdbCount;
  }
}