import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.sling.scripting.sightly.pojo.Use;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import javax.script.Bindings;
public class Ques2 implements Use {
    private List<Map<String,String>> resourceChild;
    @Override
    public void init(Bindings bindings) {
        String json;
        try {
            URL url = new URL("http://localhost:8080/content/my-htl/child.data.json");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            json = in.readLine();
            System.out.println(json);
            Gson googleJson = new Gson();
             resourceChild = googleJson.fromJson(json, new TypeToken<List<Map<String, String>>>() {}.getType());
             in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Map<String,String>> getResourceChild()
    {

        return this.resourceChild;
    }
}