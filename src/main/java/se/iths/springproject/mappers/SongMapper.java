package se.iths.springproject.mappers;

import org.springframework.stereotype.Component;
import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.entities.Song;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Component automaticly maps the class so that the "bean" can be found
@Component
public class SongMapper {
    public SongMapper() {
    }

    public SongDto mapp(Song song) {
        return new SongDto(song.getId(), song.getTitle(), song.getAlbum(), song.getArtist()
                , song.getLength());
    }

    public Song mapp(SongDto songDto) {
        return new Song(songDto.getId(), songDto.getTitle(), songDto.getAlbum(), songDto.getArtist()
                , songDto.getLength());
    }

    public Optional<SongDto> mapp(Optional<Song> optionalSong) {
        if (optionalSong.isEmpty())
            return Optional.empty();

        return Optional.of(mapp(optionalSong.get()));
    }

    public List<SongDto> mapp(List<Song> songList) {
        return songList
                .stream()
                .map(this::mapp)                //It is possible to expand this with filter()
                .collect(Collectors.toList());  //Or limit() the objects read to a specified nr

//        List <SongDto> songDtoList = new ArrayList<>();
//        for (var song: songList) {
//            songDtoList.add(mapp(song));
//        }
//        return songDtoList;
    }
}