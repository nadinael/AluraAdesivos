import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa {

  public List<Conteudo> extrairConteudo(String json) {
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributos = parser.extrair(json);
    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listaAtributos) {
      var conteudo = new Conteudo(atributos.get("title"), atributos.get("url"));
      conteudos.add(conteudo);
    }

    return conteudos;
  }

  public void testeConteudo(String json) {
        if(json!=null){
          System.out.println(json);
        } else{
          System.out.println("parametro nulo.");
        }
    //List<Map<String, String>> listaAtributos = parser.extrair(json);
    

    //for (Map<String, String> atributos : listaAtributos) {
      //System.out.println(atributos.get("title"));
      //System.out.println(atributos.get("url"));
    //}

  }

}