/*
Задача 1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task1 {

    public static void main(String[] args) throws IOException, ParseException, FileNotFoundException {
        String[] arr = readJsonFile();
        StringBuilder sb = new StringBuilder().append("select * from students WHERE ");

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" AND ");
            }
        }

        System.out.println(sb);
    }

    public static String[] readJsonFile() throws IOException, ParseException, FileNotFoundException {
        Object o = new JSONParser().parse(new FileReader("file.json"));
        JSONObject j = (JSONObject) o;
        String name = (String) j.get("name");
        String country = (String) j.get("country");
        String city = (String) j.get("city");
        String age = (String) j.get("age");
        String[] array = { "name = " + name, "country = " + country, "city = " + city, "age is " + age };
        return array;
    }
}
