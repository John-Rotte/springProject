package se.iths.springproject.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.dtos.SongTitle;
import se.iths.springproject.entities.Song;
import se.iths.springproject.mappers.SongMapper;
import se.iths.springproject.repositories.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements se.iths.springproject.services.Service {

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

    public void delete(int id) {
        if (songRepository.findById(id).isEmpty())
            throw new RuntimeException();
        songRepository.deleteById(id);
    }

    public SongDto replace(int id, SongDto songDto) {
        Optional <Song> song = songRepository.findById(id);
        if (song.isPresent())
        {
            Song updatedSong = song.get();
            if (songDto.getTitle() != null)
            updatedSong.setTitle(songDto.getTitle());
            if (songDto.getAlbum() != null)
            updatedSong.setAlbum(songDto.getAlbum());
            if (songDto.getArtist() != null)
                updatedSong.setArtist(songDto.getArtist());
            if (songDto.getLength() != 0)
                updatedSong.setLength(songDto.getLength());

            return songMapper.mapp(songRepository.save(updatedSong));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Song with id " + id + " not found");

    }

    public SongDto update(int id, SongTitle songTitle) {
        Optional <Song> song = songRepository.findById(id);
        if (song.isPresent())
        {
            Song updatedSong = song.get();
            if (songTitle.getTitle() != null)
                updatedSong.setTitle(songTitle.getTitle());


            return songMapper.mapp(songRepository.save(updatedSong));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Song with id " + id + " not found");

    }

}
