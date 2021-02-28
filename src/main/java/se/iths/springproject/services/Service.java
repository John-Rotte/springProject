package se.iths.springproject.services;

import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.dtos.SongTitle;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<SongDto> getAllSongs();

    Optional<SongDto> getOne(int id);

    SongDto createSong(SongDto songDto);

    void delete(int id);

    SongDto replace(int id, SongDto songDto);

    SongDto update(int id, SongTitle songTitle);
}
