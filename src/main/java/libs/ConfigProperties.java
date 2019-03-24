package libs;
import org.aeonbits.owner.Config;


public interface ConfigProperties extends Config {
    long TIME_FOR_DEFAULT_WAIT();
    long TIME_FOR_EXPLICIT_WAIT_LOW();
    long TIME_FOR_EXPLICIT_WAIT_HIGHT();
    String base_url();

    final String LOGIN = "ssls.automation+5@gmail.com";
    final String PASSWORD = "123456";

}
