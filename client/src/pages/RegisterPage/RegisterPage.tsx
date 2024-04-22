import { NavLink } from "react-router-dom";
import { Button } from "../../components/Button/Button";
import { Input } from "../../components/Input/Input";
import styles from "../LoginPage/styles.module.css";

type User = {
  id: number;
  name: string;
  email: string;
  password: string;
};

const RegisterPage = () => {
  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const formData = new FormData(e.currentTarget);
    const name = formData.get("name") as string;
    const email = formData.get("email") as string;
    const password = formData.get("password") as string;

    fetch("http://localhost:8080/api/auth/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, email, password }),
    })
      .then((res) => res.json() as Promise<User>)
      .then((data: User) => {
        console.log(data)
        localStorage.setItem("user", JSON.stringify(data));
      })
      .catch((err) => console.log(err));
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Register</h1>
      <form
        className={styles.form}
        onSubmit={handleSubmit}
      >
        <Input
          placeholder="Name"
          label="Name"
          name="name"
        />
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
          text="Register"
          onClick={() => console.log("Register")}
        />
        <p className={styles.register}>
          Already have an account? <NavLink to="/login">Login</NavLink>
        </p>
      </form>
    </div>
  );
};

export { RegisterPage };
