package se.iths.springproject.controllers;

import org.junit.jupiter.api.Test;
import se.iths.springproject.entities.Song;
import se.iths.springproject.services.Service;

import static org.junit.jupiter.api.Assertions.*;

class SongControllerTest {

    //Unit tests. Testing one thing at a time, in isolation.

    @Test
    void callingOneWithValidIdReturnsOnePerson(){
        SongController songController = new SongController(new TestService());
    }

    @Test
    void callingOneWithInvalidIdThrowsExceptionWithResponseStatus404(){

    }
}