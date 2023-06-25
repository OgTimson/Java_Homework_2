/*
Задача 3. Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task3 {

    public static void main(String[] args) throws IOException, ParseException, FileNotFoundException {
        JSONArray jsonArray = readJsonFile();
        StringBuilder sb = new StringBuilder();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String surname = (String) jsonObject.get("фамилия");
            String grade = (String) jsonObject.get("оценка");
            String subject = (String) jsonObject.get("предмет");

            String studentInfo = "Студент " + surname + " получил " + grade + " по предмету " + subject + ".";
            sb.append(studentInfo).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static JSONArray readJsonFile() throws IOException, ParseException, FileNotFoundException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("task3.json", StandardCharsets.UTF_8));
        return (JSONArray) obj;
    }
}
