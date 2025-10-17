package com.klef.controller;

import com.klef.model.Song;
import com.klef.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "http://localhost:5173") // React default port
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @PostMapping
    public String addSong(@RequestBody Song song) {
        return songService.addSong(song) ? "Song added successfully" : "Failed to add song";
    }

    @PutMapping
    public String updateSong(@RequestBody Song song) {
        return songService.updateSong(song) ? "Song updated successfully" : "Failed to update song";
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable int id) {
        return songService.deleteSong(id) ? "Song deleted successfully" : "Failed to delete song";
    }
}
