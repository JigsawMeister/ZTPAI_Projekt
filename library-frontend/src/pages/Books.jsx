import { useEffect, useState } from "react";
import { getBooks, borrowBook } from "../api/api";

export default function Books() {
  const [books, setBooks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem("token"); // pobieramy token z localStorage
    if (!token) {
      setError("No token found");
      setLoading(false);
      return;
    }

    async function loadBooks() {
      try {
        setLoading(true);
        const data = await getBooks(token);
        setBooks(data);
      } catch (err) {
        console.error(err);
        setError("Failed to load books");
      } finally {
        setLoading(false);
      }
    }

    loadBooks();
  }, []);

  async function borrow(id) {
    const token = localStorage.getItem("token");
    if (!token) {
      alert("No token found");
      return;
    }

    try {
      await borrowBook(id, 2, token);
      const data = await getBooks(token);
      setBooks(data);
    } catch {
      alert("Borrow failed");
    }
  }

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;

  return (
    <div>
      <h2>Books</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            {book.title} ({book.available} available)
            <button onClick={() => borrow(book.id)}>Borrow</button>
          </li>
        ))}
      </ul>
    </div>
  );
}