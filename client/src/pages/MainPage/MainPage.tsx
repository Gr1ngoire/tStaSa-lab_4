import { NavLink, Outlet } from "react-router-dom";
import styles from "./styles.module.css";

export const MainPage = () => {
  return (
    <div className={styles.container}>
      <nav className={styles.nav}>
        <ul>
          <li>
            <NavLink to="/home">Home</NavLink>
          </li>
          <li>
            <NavLink to="/home/appointments">Appointments</NavLink>
          </li>
          <li>
            <NavLink to="/home/payments">Payments</NavLink>
          </li>
          <li>
            <NavLink to="/home/contacts">Contacts</NavLink>
          </li>
        </ul>
      </nav>
      <div className={styles.main}>
        <Outlet />
      </div>
    </div>
  );
};
