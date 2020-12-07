import org.example.TempBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    void getBean() {
        String shouldBe = "hello from temp bean";

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        TempBean bean = (TempBean) context.getBean("tempBean");

        Assertions.assertEquals(bean.greet(), shouldBe);
    }
}
