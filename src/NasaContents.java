import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContents implements ProviderContents {
    public List<Contents> getContents(String json){
        // extrair só os dados que interessam (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> atributsList = parser.parse(json);
        List<Contents> contentsList = new ArrayList<>();
   
        //popular 
        for(Map<String, String> atributs: atributsList){
            String title = atributs.get("title");
            String urlImage = atributs.get("url");
            var contents = new Contents(title, urlImage);
            contentsList.add(contents);
        }

        return contentsList;
    }
}
