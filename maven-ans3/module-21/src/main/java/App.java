import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class App {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger log = Logger.getLogger(App.class.getName());
        log.info("From module-21");
    }
}
