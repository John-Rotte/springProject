package se.iths.springproject.services;

import org.springframework.stereotype.Service;
import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.entities.Song;
import se.iths.springproject.mappers.SongMapper;
import se.iths.springproject.repositories.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongMapper songMapper;
    private SongRepository songRepository;

    public SongService(SongRepository songRepository, SongMapper songMapper) {
        this.songMapper = songMapper;
        this.songRepository = songRepository;
    }

    public List <SongDto> getAllSongs() {
        return songMapper.mapp(songRepository.findAll());
    }



    public Optional <SongDto>  getOne(int id){
        return songMapper.mapp(songRepository.findById(id));
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Song with id " + id + " not found"));
    }

    public SongDto createSong(SongDto songDto){
        if(songDto.getTitle().isEmpty())
            throw new RuntimeException();

        //Save as song and return songDto object
        return songMapper.mapp(songRepository.save(songMapper.mapp(songDto)));
    }


}
