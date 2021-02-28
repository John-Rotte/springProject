package se.iths.springproject.controllers;

import org.junit.jupiter.api.Test;
import se.iths.springproject.entities.Song;
import se.iths.springproject.services.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SongControllerTest {

    //Unit tests. Testing one thing at a time, in isolation.

    @Test
    void callingOneWithValidIdReturnsOnePerson(){
        SongController songController = new SongController(new TestService());

        var song = songController.one(1);

        assertThat(song.getTitle().contentEquals("Test"));
        assertThat(song.getAlbum().contentEquals("Test"));
        assertThat(song.getArtist().contentEquals("Test"));
        assertEquals(song.getLength(),1234);
    }

    @Test
    void callingOneWithInvalidIdThrowsExceptionWithResponseStatus404(){

    }
}