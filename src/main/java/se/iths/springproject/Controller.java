package se.iths.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private SongRepository songRepository;

    @Autowired
    //När en instans av Controller skapas så kommer också en instans av songRepository att skapas
    public Controller(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    //Här görs mappningnar för olika requests som ska skickas vidare till en databas
    @GetMapping("/hello")
    public String sayHello(){
        SongRepository songRepository;


        return "Hello World";

    }
}
