package com.example.demo;

import com.example.demo.controller.ReplayController;
import com.example.demo.model.ReplaySection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReplayController.class)

class IbmTestAssignmentApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ReplayController replayController;

    @Test
    public void testTrackReplaySection() throws Exception {
        ReplaySection replaySection = new ReplaySection("test_video", 10, 30);

        mockMvc.perform(post("/api/replay/track")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(replaySection)))
                .andExpect(status().isOk());

        verify(replayController, times(1)).trackReplaySection(any());
    }

    @Test
    public void testGetReplaySections() throws Exception {
        ReplaySection replaySection = new ReplaySection("test_video", 10, 30);

        when(replayController.getReplaySections("test_video"))
                .thenReturn(Arrays.asList(replaySection));

        mockMvc.perform(get("/api/replay/get/test_video"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].videoId").value("test_video"))
                .andExpect(jsonPath("$[0].startSecond").value(10))
                .andExpect(jsonPath("$[0].endSecond").value(30));

        verify(replayController, times(1)).getReplaySections("test_video");
    }
}
