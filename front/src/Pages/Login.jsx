import { useState } from "react";
import { Link } from "react-router-dom"; // For the "Go to Register" link
import "./Login.css"; // Link the CSS file for the Login page

function Login() {
    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });

    const [error, setError] = useState("");

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Basic validation
        if (!formData.email || !formData.password) {
            setError("Please fill in both fields.");
            return;
        }

        // Clear error and log form data
        setError("");
        console.log("Login form submitted:", formData);

        // Here, you would usually send the login details to your backend (e.g., API call).
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                />
                <br />
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={formData.password}
                    onChange={handleChange}
                    required
                />
                <br />
                <button type="submit">Login</button>
            </form>
           <center> <p>
                Don't have an account? <Link to="/register">Register here</Link>
            </p></center>
        </div>
    );
}

export default Login;
