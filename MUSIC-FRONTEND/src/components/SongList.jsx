import { useState } from "react";

export default function SongList({ songs, onDelete, onUpdate }) {
  const [editId, setEditId] = useState(null);
  const [form, setForm] = useState({});

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const saveEdit = () => {
    onUpdate({ ...form, id: editId, releaseYear: parseInt(form.releaseYear) });
    setEditId(null);
  };

  return (
    <div className="song-list">
      {songs.map((song) => (
        <div key={song.id} className="song-card">
          {editId === song.id ? (
            <>
              <input
                name="name"
                value={form.name}
                onChange={handleChange}
                placeholder="Song Title"
              />
              <input
                name="movie"
                value={form.movie}
                onChange={handleChange}
                placeholder="Movie Name"
              />
              <input
                name="singer"
                value={form.singer}
                onChange={handleChange}
                placeholder="Singer"
              />
              <input
                name="releaseYear"
                type="number"
                value={form.releaseYear}
                onChange={handleChange}
                placeholder="Release Year"
              />
              <button onClick={saveEdit}>Save</button>
              <button onClick={() => setEditId(null)}>Cancel</button>
            </>
          ) : (
            <>
              <h3>{song.name}</h3>
              <p><b>Movie:</b> {song.movie}</p>
              <p><b>Singer:</b> {song.singer}</p>
              <p><b>Year:</b> {song.releaseYear}</p>
              <div className="buttons">
                <button
                  onClick={() => {
                    setEditId(song.id);
                    setForm(song);
                  }}
                >
                  Edit
                </button>
                <button onClick={() => onDelete(song.id)}>Delete</button>
              </div>
            </>
          )}
        </div>
      ))}
    </div>
  );
}
