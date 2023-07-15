package ovh.major.springcourseopenfeigh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "itunes-client", url = "${app.url}" )
public interface ITunesProxy {

    //https://itunes.apple.com/search?term=shawnmendes&limit=1;

    @GetMapping("/search")
    ITunesResponse search(
            @RequestParam("term") String term,
            @RequestParam("limit") Integer limit
    );

}
