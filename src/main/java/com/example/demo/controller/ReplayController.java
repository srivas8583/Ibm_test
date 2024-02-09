package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ReplaySection;



@RestController
@RequestMapping("/api/replay")
public class ReplayController {

	private List<ReplaySection> replaySections = new ArrayList<>();
	 @PostMapping("/track")
	    public void trackReplaySection(@RequestBody ReplaySection replaySection) {
	        // Store replay section in memory
	        replaySections.add(replaySection);
	    }

	    @GetMapping("/get/{videoId}")
	    public List<ReplaySection> getReplaySections(@PathVariable String videoId) {
	        // Retrieve replay sections for a specific video
	        List<ReplaySection> result = new ArrayList<>();
	        for (ReplaySection section : replaySections) {
	            if (section.getVideoId().equals(videoId)) {
	                result.add(section);
	            }
	        }
	        return result;
	    }
}
