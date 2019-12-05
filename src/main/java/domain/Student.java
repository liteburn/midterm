package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected List<JsonPair> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);

    }

    public JsonObject toJsonObject() {
        // ToDo
        return new JsonObject(new JsonPair("name", new JsonString(name)),
                new JsonPair("surname", new JsonString(surname)));
    }
}
