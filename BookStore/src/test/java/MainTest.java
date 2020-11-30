import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class MainTest {
    @Disabled
    @Test
    void getTestStr() {
        Main m = new Main();
        String shouldBe = "Hello World!";
        Assertions.assertEquals(m.getTestStr(), shouldBe);
    }
}