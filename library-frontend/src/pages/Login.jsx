import { useState } from "react";
import { login } from "../api/api";

export default function Login({ setToken }) {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    async function handleLogin() {

        const data = await login(username, password);

        if (data.token) {
            setToken(data.token);
            localStorage.setItem("token", data.token);
        } else {
            alert("Login failed");
        }
    }

    return (
        <div>
            <h2>Login</h2>

            <input
                placeholder="username"
                value={username}
                onChange={e => setUsername(e.target.value)}
            />

            <input
                type="password"
                placeholder="password"
                value={password}
                onChange={e => setPassword(e.target.value)}
            />

            <button onClick={handleLogin}>
                Login
            </button>
        </div>
    );
}