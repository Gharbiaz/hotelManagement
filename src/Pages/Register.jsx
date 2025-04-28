import { useState } from "react";
import ReCAPTCHA from "react-google-recaptcha";
import "./Register.css";
function Register() {
    const [formData, setFormData] = useState({
        username: "",
        email: "",
        password: "",
        confirmPassword: ""
    });

    const [captchaValue, setCaptchaValue] = useState(null); // for real captcha
    const [error, setError] = useState("");
    const [confirmTouched, setConfirmTouched] = useState(false);

    const SITE_KEY = "6LcmOycrAAAAAAXosdj2ylZGCMYqK8vsgEsej8cw"; // <-- put your real site key here

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (formData.password !== formData.confirmPassword) {
            setError("Passwords do not match.");
            return;
        }

        if (!captchaValue) {
            setError("Please complete the captcha.");
            return;
        }

        setError("");

        console.log("Form submitted:", formData, "Captcha value:", captchaValue);

        // After that you should send captchaValue to your backend for verification

        // Reset
        setFormData({
            username: "",
            email: "",
            password: "",
            confirmPassword: ""
        });
        setCaptchaValue(null);
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

                {/* Google reCAPTCHA */}
                <div style={{ margin: "20px 0" }}>
                    <ReCAPTCHA
                        sitekey={SITE_KEY}
                        onChange={(value) => setCaptchaValue(value)}
                    />
                </div>

                <button type="submit">Register</button>
            </form>
        </div>
    );
}

export default Register;
