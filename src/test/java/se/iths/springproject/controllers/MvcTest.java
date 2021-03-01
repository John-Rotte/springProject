package se.iths.springproject.controllers;


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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(SongController.class)
@Import(TestService.class)
public class MvcTest {

//    @Autowired
    @MockBean
    Service service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void callingWithUrlSongsShouldReturnAllSongsAsJson() throws Exception {
        //Tell mockito what to retyrn when calling Methods on Service
        when(service.getAllSongs()).thenReturn(List.of(new SongDto(1,"","","",0)));



        var result = mockMvc.perform(MockMvcRequestBuilders.get("/songs")
        .accept(MediaType.APPLICATION_JSON)).andReturn();


        assertThat(result.getResponse().getStatus()).isEqualTo(200);

    }

}
