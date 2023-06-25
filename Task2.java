/*
Задача 2. Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл.
 */

import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Task2 {

    private static final Logger logger = Logger.getLogger(Task2.class.getName());

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 1, 4 };

        try {
            logger.setLevel(Level.INFO);
            FileHandler fh = new FileHandler("log.xml");
            fh.setFormatter(new XMLFormatter());
            logger.addHandler(fh);
            logger.info("Source array: " + Arrays.toString(array));

            // Сортировка пузырьком
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        logger.info("Iteration " + (i + 1) + ": " + Arrays.toString(array));
                    }
                }
            }
            fh.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception occurred", e);
        }
    }
}