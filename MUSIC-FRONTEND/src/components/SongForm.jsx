import { useState } from "react";

export default function SongForm({ onAdd }) {
  const [song, setSong] = useState({
    name: "",
    movie: "",
    singer: "",
    releaseYear: ""
  });

  const handleChange = (e) =>
    setSong({ ...song, [e.target.name]: e.target.value });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!song.name) return;
    onAdd({ ...song, releaseYear: parseInt(song.releaseYear) });
    setSong({ name: "", movie: "", singer: "", releaseYear: "" });
  };

  return (
    <form onSubmit={handleSubmit} className="song-form">
      <input
        name="name"
        placeholder="Song Title"
        value={song.name}
        onChange={handleChange}
        required
      />
      <input
        name="movie"
        placeholder="Movie Name"
        value={song.movie}
        onChange={handleChange}
      />
      <input
        name="singer"
        placeholder="Singer"
        value={song.singer}
        onChange={handleChange}
      />
      <input
        name="releaseYear"
        type="number"
        placeholder="Release Year"
        value={song.releaseYear}
        onChange={handleChange}
      />
      <button type="submit">Add Song</button>
    </form>
  );
}
