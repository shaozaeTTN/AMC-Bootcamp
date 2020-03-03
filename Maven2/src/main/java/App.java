import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(App.class.getName());
        logger.info("Hello");
    }
}
