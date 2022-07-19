import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    // Leitura da imagem
    //InputStream inputStream = new FileInputStream("entrada/shawshank.jpg");
    //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    //cria uma imagem com transparência e tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para a nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a fonte do texto
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.GREEN);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 200, novaAltura - 100);

    // escrever a imagem nova em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }

 // public static void main(String[] args) throws Exception {
   // var geradora = new GeradoraDeFigurinhas();
 //   geradora.cria();
  //}
  
}
