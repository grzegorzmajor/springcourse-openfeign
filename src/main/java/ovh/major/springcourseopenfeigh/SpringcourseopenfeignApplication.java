package ovh.major.springcourseopenfeigh;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class SpringcourseopenfeignApplication {

    @Autowired
    ITunesProxy iTunesProxy;

    public static void main(String[] args) {
        SpringApplication.run(SpringcourseopenfeignApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequest(){
        try {
            ITunesResponse response = iTunesProxy.search("shawnmendes", 2);
            List<ITunesResults> results = response.results();
            log.info(results);
        } catch (FeignException.FeignClientException feignException) {
            log.error("client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            log.error("server exception: " + feignException.status());
        } catch (FeignException feignException) {
            log.error(feignException.getMessage() + " || " + feignException.status());
        }
    }

}
