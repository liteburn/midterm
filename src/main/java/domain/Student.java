package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected List<Json> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = new List<Json>;
        for(Tuple<String, Integer> exam: exams){
            this.exams.add(new JsonPair(exam.key, exam.value));
        }
    }

    public JsonObject toJsonObject() {
        // ToDo
        return new JsonObject(new JsonPair("name", new JsonString(name)),
                new JsonPair("surname", new JsonString(surname)),
                new JsonPair("year", new JsonNumber(year)), new JsonPair("exams", new JsonArray(exams)));
    }
}
