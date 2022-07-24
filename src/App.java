import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexao http e buscar os top 250 filmes
        //var url = "https://alura-imdb-api.herokuapp.com/movies";
        //ProviderContents contentsProvider = new IMDBContents();

        var url = "https://api.nasa.gov/planetary/apod?api_key=POkzLYYt0Nb3mqQ6eq3bNm4cyizaUwxvwVZElAfj&start_date=2022-06-12&end_date=2022-06-14";
        ProviderContents contentsProvider = new NasaContents();

        var http = new ClientHttp();
        String json = http.getData(url);
        
        
        //melhor deixar fora do for para não alocar muito recurso.
        Stickers stickers = new Stickers();         
        List<Contents> atributsList = contentsProvider.getContents(json);
        //exibir
        for (int i = 0; i < 3; i++) {

            Contents contents = atributsList.get(i);

            String fileName = "sticker/" + contents.getTitle() + ".png";
            InputStream inputStream = new URL(contents.getUrlImage()).openStream();
            
            stickers.create(inputStream, fileName);
            System.out.println(contents.getTitle());            
            System.out.println();            
        }

        //Desafios
        /*
         * 1. Acessar outro endpoint do imdb
         * 2. Melhorar a saída System.out (exibir estrelas; classificação com cor; título e imagem com valor mais destacado)
         * 3. isolar a chave (extrair de um arquivo, variável de ambiente - properties, )
         * 4. Mega Desafio: Usar outra biblioteca como parser JAXON, GSON
         * 5. Mega Desafio: ter outro método para pontuar o filme, classe scanner para perguntar.
         */

    }
}
