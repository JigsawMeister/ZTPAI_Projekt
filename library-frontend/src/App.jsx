import { useState } from "react";
import Login from "./pages/Login";
import Books from "./pages/Books";

function App() {

  const [token, setToken] = useState(localStorage.getItem("token"));

  function logout() {

    localStorage.removeItem("token");

    setToken(null);

  }

  if (!token) {

    return <Login setToken={setToken} />;

  }

  return (
    <div>

      <button onClick={logout}>
        Logout
      </button>

      <Books token={token} />

    </div>
  );
}

export default App;