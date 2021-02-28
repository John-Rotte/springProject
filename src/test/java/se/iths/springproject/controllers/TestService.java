package se.iths.springproject.controllers;

import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.dtos.SongTitle;
import se.iths.springproject.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<SongDto> getAllSongs() {
        return null;
    }

    @Override
    public Optional<SongDto> getOne(int id) {
        return Optional.empty();
    }

    @Override
    public SongDto createSong(SongDto songDto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public SongDto replace(int id, SongDto songDto) {
        return null;
    }

    @Override
    public SongDto update(int id, SongTitle songTitle) {
        return null;
    }
}
