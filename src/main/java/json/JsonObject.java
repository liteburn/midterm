package json;

import java.util.*;

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
        return getJsonLObjectBody();
    }

    public void add(JsonPair jsonPair) {
        jsonPairs.add(jsonPair);
    }

    private String getJsonLObjectBody() {
        String jsonStr = "";
        for (JsonPair jsonPair: jsonPairs) {

            jsonStr += "'" + jsonPair.key + "': " + "'" + jsonPair.value.toString() + "'" + ",";

            jsonStr += ", ";
        }
        StringBuilder jsonStr1 = new StringBuilder("{");
        for (int i = 0; i < jsonStr.length() - 1; i++){
            jsonStr1.append(jsonStr.charAt(i));
        }
        jsonStr1.append("}");
        return jsonStr1.toString();
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
