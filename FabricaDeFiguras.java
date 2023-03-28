import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.*;

import javax.imageio.ImageIO;

public class FabricaDeFiguras {

  public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
    System.out.println("GERANDO...");
    // String img = System.getProperty("user.dir") + "/entrada/filme-maior.jpg";
    // ler imagem
    // InputStream inputStream = new FileInputStream(new File(img));
    /*
     * InputStream inputStream = new URL(
     * "https://m.media-amazon.com/images/M/MV5BN2EwM2I5OWMtMGQyMi00Zjg1LWJkNTctZTdjYTA4OGUwZjMyXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg"
     * ).openStream();
     */
    BufferedImage original = ImageIO.read(inputStream);
    // criar nova imagem com alpha
    int largura = original.getWidth();
    int altura = original.getHeight();
    int novaAltura = altura + 200;
    BufferedImage imagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
    // copiar imagem original
    Graphics2D grafico = (Graphics2D) imagem.getGraphics();
    grafico.drawImage(original, 0, 0, null);
    // formatando
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 54);
    grafico.setColor(Color.CYAN);
    grafico.setFont(fonte);

    // escrever uma frase em uma imagem
    grafico.drawString("Imersao Alura", 100, novaAltura - 120);
    // guardar a imagem
    String img = System.getProperty("user.dir") + "/saida/" + nomeArquivo;
    ImageIO.write(imagem, "png", new File(img));
    System.out.println("Adesivo criado.");
  }

}