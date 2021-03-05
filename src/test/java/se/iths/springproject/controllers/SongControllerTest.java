//Used for building unit tests
//
//
//
// package se.iths.springproject.controllers;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ResponseStatusException;
//import se.iths.springproject.entities.Song;
//import se.iths.springproject.services.Service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SongControllerTest {
//
//    //Unit tests. Testing one thing at a time, in isolation.
//
//    @Test
//    void callingOneWithValidIdReturnsOnePerson(){
//        SongController songController = new SongController(new TestService());
//
//        var song = songController.one(1);
//
//        assertThat(song.getId()).isEqualTo(1);
//        assertThat(song.getTitle()).isEqualTo("Test");
//        assertThat(song.getAlbum()).isEqualTo("Test");
//        assertThat(song.getArtist()).isEqualTo("Test");
//        assertThat(song.getLength()).isEqualTo(1234);
//    }
//
//    @Test
//    void callingOneWithInvalidIdThrowsExceptionWithResponseStatus404(){
//        SongController songController = new SongController(new TestService());
//
//        var exception = assertThrows(ResponseStatusException.class, () -> songController.one(2));
//
//        assertThat(exception.getStatus().equals(HttpStatus.NOT_FOUND));
//    }
//}