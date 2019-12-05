package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jsonPairs;
    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = Arrays.asList(jsonPairs);
    }

    @Override
    public String toJson() {
        StringBuilder one = new StringBuilder("[");
        for (JsonPair jsonPair: jsonPairs){
            one.append(jsonPair.toString());
        }
        one.append("]");
        return one.toString();
    }

    public void add(JsonPair jsonPair) {
        jsonPairs.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair jsonPair: jsonPairs){
            if (jsonPair.key.equals(name)){
                return jsonPair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (String name: names){
            for (JsonPair jsonPair: jsonPairs){
                if (jsonPair.key.equals(name)){
                    jsonObject.add(jsonPair);
                }
            }
        }
        return jsonObject;
    }
}
