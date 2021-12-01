package Data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "validNameData")
    public static Object[][] validName() {
        return new Object [][] {{"Ilya"}, {"Илья"}};
    }

    @DataProvider(name = "withoutLettersData")
    public static Object[][] numbersAndSigns() {
        return new Object[][] {{"1234"}, {"<>?@"}};
    }

    @DataProvider(name = "twoAlphabetNameData")
    public static Object[][] twoAlphabetName() {
        return new Object[][] {{"Аnthony"}, {"Tоny"}};
    }

    @DataProvider(name = "withNumberData")
    public static Object[][] withNumber() {
        return new Object [][] {{"1lya"}, {"N4than"}, {"T0ny"}};
    }

}

