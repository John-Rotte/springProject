package se.iths.springproject;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private SongRepository songRepository;

    @Autowired
    //När en instans av Controller skapas så kommer också en instans av songRepository att skapas
    public Controller(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    //Här görs mappningnar för olika requests som ska skickas vidare till en databas
    @GetMapping("/songs")
    public List<Song> all(){
        return songRepository.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song one(@PathVariable int id){
        return songRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Song with id " + id + " not found"));
//        if (result.isPresent())
//        return result.get();
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User with id " + id + " not found");
    }

    @PostMapping("/songs")
    @ResponseStatus(HttpStatus.CREATED)
    public Song create(@RequestBody Song song){

        return songRepository.save(song);
    }

}
