package se.iths.springproject.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.iths.springproject.dtos.SongDto;
import se.iths.springproject.services.Service;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SongController.class)
//@Import(TestService.class)
public class MvcTest {

    @MockBean
    Service service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllSongsFromRepository() throws Exception {
        when(service.getAllSongs()).thenReturn(List.of(
                new SongDto(1,"Test1","Test1","Test1",1234)
                , new SongDto(2,"Test2","Test2","Test2",1234)));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/songs")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getOneSongWithIdFromRepository() throws Exception {
        when(service.getOne(1)).thenReturn(Optional.of(
                new SongDto(1, "test1","test1","test1",1234)));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/songs/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void postOneSongToRepository() throws Exception {
        var newSong = new SongDto(1, "TestPost","TestPost","TestPost",1234);
        when(service.createSong(any(SongDto.class)))
                .thenReturn(newSong);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/songs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newSong))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("title").value(newSong.getTitle()));
    }

    @Test
    void putOneSongToRepository() throws Exception {
        var updatedSongPut = new SongDto(1, "TestPut" , "TestPut", "TestPut", 1234);
        when(service.replace(any(Integer.class), any(SongDto.class)))
                .thenReturn(updatedSongPut);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/songs/{id}","1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedSongPut))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("title").value(updatedSongPut.getTitle()));
    }

    @Test
    void patchSongWithNewSongTitleInRepository() throws Exception {
        var updatedSongPatch = new SongDto(1, "Test","Test","Test",1234);
        when(service.update(any(Integer.class), any(SongDto.class)))
                .thenReturn(updatedSongPatch);

        mockMvc.perform(MockMvcRequestBuilders
                .patch("/songs/{id}","1")
                .content(asJsonString(updatedSongPatch))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("title").value(updatedSongPatch.getTitle()));
    }

    @Test
    void deleteOneSongFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/songs/1"))
                .andExpect(status().isOk());
    }

    @Test
    void searchForSongWithCorrectTitle() throws Exception {

        List<SongDto> list = List.of(
                new SongDto(1, "Waldo", "test", "test" ,1234),
                new SongDto(2, "Large population", "test", "test", 12345)
        );

        when(service.search("Waldo")).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/songs/search?title=Waldo")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void callingWithUrlSongsShouldReturnAllSongsAsJson() throws Exception {
        //Tell mockito what to retyrn when calling Methods on Service
        when(service.getAllSongs()).thenReturn(List.of(new SongDto(1,"","","",0)));



        var result = mockMvc.perform(MockMvcRequestBuilders.get("/songs")
        .accept(MediaType.APPLICATION_JSON)).andReturn();


        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
