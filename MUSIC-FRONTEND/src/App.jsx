import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";
import SongForm from "./components/SongForm";
import SongList from "./components/SongList";

const API_URL = import.meta.env.VITE_API_URL; // from .env

function App() {
  const [songs, setSongs] = useState([]);

  const fetchSongs = async () => {
    try {
      const res = await axios.get(API_URL);
      setSongs(res.data);
    } catch (error) {
      console.error("Error fetching songs:", error);
    }
  };

  useEffect(() => {
    fetchSongs();
  }, []);

  const addSong = async (song) => {
    try {
      await axios.post(API_URL, song);
      fetchSongs();
    } catch (error) {
      console.error("Error adding song:", error);
    }
  };

  const updateSong = async (song) => {
    try {
      await axios.put(API_URL, song);
      fetchSongs();
    } catch (error) {
      console.error("Error updating song:", error);
    }
  };

  const deleteSong = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      fetchSongs();
    } catch (error) {
      console.error("Error deleting song:", error);
    }
  };

  return (
    <div className="container">
      <h1>🎶 Music Library</h1>
      <SongForm onAdd={addSong} />
      <SongList songs={songs} onDelete={deleteSong} onUpdate={updateSong} />
    </div>
  );
}

export default App;
