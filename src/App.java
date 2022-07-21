import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://api.mocki.io/v2/549a5d8b";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
       
        String url = "https://api.nasa.gov/planetary/apod?api_key=gW9P8i295dNP5HQyBRhXiog7hwIRARfFaVSZGEQ8&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();
        for (int i =0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);
                
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
