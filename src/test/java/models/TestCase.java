package models;

/**
 * Created by Tetiana on 17-Apr-15.
 */
public class TestCase {
    public static String TEST_CASE_NAME = "TC-01-Search for device";
    public static String TEST_CASE_PRECONDITIONS = "Go to http://rozetka.com.ua/";
    public static String TC_STEP_1 = "Enter 'Lenovo Y510P' request in the search field";
    public static String TC_EXPECTED_RESULT_1 = "Search request string should be specified in search field";
    public static String TC_STEP_2 = "Choose category 'Компьютеры и ноутбуки' near the search field";
    public static String TC_EXPECTED_RESULT_2 = "Category 'Компьютеры и ноутбуки' should be chosen";
    public static String TC_STEP_3 = "Click 'Найти' button";
    public static String TC_EXPECTED_RESULT_3 = "List of devices (that meets the search criteria) should be observed on the screen";


}
