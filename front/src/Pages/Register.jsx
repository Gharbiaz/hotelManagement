import { useState } from "react";

function Register() {
    const [formData, setFormData] = useState({
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
        captchaInput: ""
    });

    const [captcha, setCaptcha] = useState(generateCaptcha());
    const [error, setError] = useState("");
    const [confirmTouched, setConfirmTouched] = useState(false); // track if confirmPassword was touched

    function generateCaptcha() {
        const chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        let result = "";
        for (let i = 0; i < 6; i++) {
            result += chars.charAt(Math.floor(Math.random() * chars.length));
        }
        return result;
    }

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Validate passwords match
        if (formData.password !== formData.confirmPassword) {
            setError("Passwords do not match.");
            return;
        }

        // Validate captcha
        if (formData.captchaInput !== captcha) {
            setError("Captcha is incorrect.");
            return;
        }

        // Clear errors
        setError("");

        console.log("Form submitted:", formData);

        // Reset form
        setFormData({
            username: "",
            email: "",
            password: "",
            confirmPassword: "",
            captchaInput: ""
        });
        setCaptcha(generateCaptcha());
        setConfirmTouched(false);
    };

    const passwordsMatch = formData.password && formData.confirmPassword && formData.password === formData.confirmPassword;

    return (
        <div className="register-container">
            <h2>Register</h2>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    value={formData.username}
                    onChange={handleChange}
                    required
                /><br />

                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                /><br />

                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={formData.password}
                    onChange={handleChange}
                    required
                /><br />

                <input
                    type="password"
                    name="confirmPassword"
                    placeholder="Confirm Password"
                    value={formData.confirmPassword}
                    onChange={handleChange}
                    onFocus={() => setConfirmTouched(true)}
                    required
                    style={{
                        borderColor:
                            confirmTouched && formData.confirmPassword
                                ? passwordsMatch
                                    ? "green"
                                    : "red"
                                : ""
                    }}
                /><br />

                {/* Captcha */}
                <div style={{ margin: "10px 0", fontWeight: "bold" }}>
                    {captcha}
                </div>
                <input
                    type="text"
                    name="captchaInput"
                    placeholder="Enter Captcha"
                    value={formData.captchaInput}
                    onChange={handleChange}
                    required
                /><br />

                <button type="submit">Register</button>
            </form>
        </div>
    );
}

export default Register;
