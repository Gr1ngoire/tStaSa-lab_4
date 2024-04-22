import { NavLink } from "react-router-dom";
import { Button } from "../../components/Button/Button";
import { Input } from "../../components/Input/Input";

import styles from "./styles.module.css";

const LoginPage = () => {

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const formData = new FormData(e.currentTarget);
    const email = formData.get("email") as string;
    const password = formData.get("password") as string;

    fetch("http://localhost:8080/api/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
      })
      .catch((err) => console.log(err));
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Login</h1>
      <form className={styles.form} onSubmit={handleSubmit}>
        <Input
          placeholder="Email"
          label="Email"
          name="email"
        />
        <Input
          placeholder="Password"
          label="Password"
          type="password"
          name="password"
        />
        <Button
          text="Login"
          onClick={() => console.log("Login")}
        />
        <p className={styles.register}>
          Don't have an account? <NavLink to="/register">Register</NavLink>
        </p>
      </form>
    </div>
  );
};

export { LoginPage };
