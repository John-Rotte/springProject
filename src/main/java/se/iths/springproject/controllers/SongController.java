package se.iths.springproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.dtos.SongTitle;
import se.iths.springproject.services.Service;
import se.iths.springproject.services.SongService;

import java.util.List;

@RestController
public class SongController {

    private Service service;


    //När en instans av Controller skapas så kommer också en instans av songService att skapas
    public SongController(Service service) { this.service = service;
    }

    //Här görs mappningnar för olika requests som ska skickas vidare till en databas
    @GetMapping("/songs")
    public List<SongDto> all(){
        return service.getAllSongs();
    }

    @GetMapping("/songs/{id}")
    public SongDto one(@PathVariable int id){
        return service.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Song with id " + id + " not found"));
//        if (result.isPresent())
//        return result.get();
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User with id " + id + " not found");
    }

    @PostMapping("/songs")
    @ResponseStatus(HttpStatus.CREATED)
    public SongDto create(@RequestBody SongDto song){

        return service.createSong(song);
    }

    @DeleteMapping("/songs/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/songs/{id}")
        public SongDto replace(@RequestBody SongDto songDto, @PathVariable int id){
        return service.replace(id, songDto);

    }

    @PatchMapping("/songs/{id}")
    public SongDto update(@RequestBody SongTitle songTitle, @PathVariable int id) {
        return service.update(id, songTitle);
    }

}
