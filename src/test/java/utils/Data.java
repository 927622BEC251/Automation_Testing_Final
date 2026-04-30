package utils;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "searchData")
    public static Object[][] getSearchData() throws Exception {

        String path = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";

        return ExcelUtil.getData(path, "Sheet1");
    }
}