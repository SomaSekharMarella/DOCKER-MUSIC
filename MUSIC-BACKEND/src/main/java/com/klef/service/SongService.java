package com.klef.service;


import com.klef.config.DatabaseConfig;
import com.klef.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private DatabaseConfig dbConfig;

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        try (Connection conn = dbConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM songs")) {

            while (rs.next()) {
                Song song = new Song();
                song.setId(rs.getInt("id"));
                song.setName(rs.getString("name"));
                song.setMovie(rs.getString("movie"));
                song.setSinger(rs.getString("singer"));
                song.setReleaseYear(rs.getInt("release_year"));
                songs.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }

    public boolean addSong(Song song) {
        String sql = "INSERT INTO songs (name, movie, singer, release_year) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, song.getName());
            ps.setString(2, song.getMovie());
            ps.setString(3, song.getSinger());
            ps.setInt(4, song.getReleaseYear());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSong(Song song) {
        String sql = "UPDATE songs SET name=?, movie=?, singer=?, release_year=? WHERE id=?";
        try (Connection conn = dbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, song.getName());
            ps.setString(2, song.getMovie());
            ps.setString(3, song.getSinger());
            ps.setInt(4, song.getReleaseYear());
            ps.setInt(5, song.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSong(int id) {
        String sql = "DELETE FROM songs WHERE id=?";
        try (Connection conn = dbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
