document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    // Evento para el login
    if (loginForm) {
        loginForm.addEventListener("submit", async (e) => {
            e.preventDefault();

            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;

            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password }),
            });

            const data = await response.json();
            console.log("data:", data);

            if (!data.token) {
                alert("Usuario o contraseña invalida");
                window.location.href = "/login"; // Redirigir a login
            }else{
                alert("Login Exitoso")
                localStorage.setItem("token", data.token);
                window.location.href = "/"; // Redirigir a inicio
            }
        });
    }

    // Evento para el registro de usuario
    if (registerForm) {
        registerForm.addEventListener("submit", async (e) => {
            e.preventDefault();

            const newUsername = document.getElementById("newUsername").value;
            const newPassword = document.getElementById("newPassword").value;

            const response = await fetch("/api/auth/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username: newUsername, password: newPassword }),
            });
            const data = await response.json();
            console.log("data:", data);

            if (!response.ok) {
                alert("Registro exitoso, ahora puedes iniciar sesión");
                window.location.href = "/register";
            } else {
                alert("Registro exitoso, ahora puedes iniciar sesión");
                window.location.href = "/login";
            }
        });
    }
});
