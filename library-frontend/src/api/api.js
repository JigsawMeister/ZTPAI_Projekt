const API_URL = "http://localhost:8080";

export async function login(username, password) {
    const res = await fetch(`${API_URL}/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    });

    return res.json();
}

export async function getBooks(token) {

    const res = await fetch("http://localhost:8080/books", {
    method: "GET",
    headers: {
      "Authorization": "Bearer " + token,
      "Content-Type": "application/json"
    }
  });
  if (!res.ok) throw new Error("Request failed: " + res.status);
  return res.json();
}

export async function borrowBook(bookId, userId, token) {
    const res = await fetch(`http://localhost:8080/loans/${id}?days=${days}`, {
        method: "POST",
        headers: {
          "Authorization": "Bearer " + token,
          "Content-Type": "application/json"
        }
      });
      if (!res.ok) throw new Error("Borrow failed: " + res.status);
      return res.json();
}