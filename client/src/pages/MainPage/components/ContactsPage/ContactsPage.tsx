import { useEffect, useState } from "react";
import styles from "../AppointmentsPage/styles.module.css";

type Doctor = {
  id: number;
  name: string;
  email: string;
};

const getDoctors = async () => {
  const response = await fetch("http://localhost:8080/api/doctors");
  const data = await response.json();
  return data;
};

export const ContactsPage = () => {
  const [doctors, setDoctors] = useState<Doctor[]>([]);

  useEffect(() => {
    getDoctors().then((data) => setDoctors(data));
  }, []);

  return (
    <div className={styles.container}>
      <h1>Contacts</h1>
      <div className={styles.doctors}>
        <table className={styles.table}>
          <thead>
            <tr className={styles.tableHeaderRow}>
              <th className={styles.tableHeader}>Name</th>
              <th className={styles.tableHeader}>Email</th>
            </tr>
          </thead>
          <tbody>
            {doctors.map((doctor: Doctor) => (
              <tr
                key={doctor.id}
                className={styles.tableRow}
              >
                <td className={styles.tableCell}>{doctor.name}</td>
                <td className={styles.tableCell}>{doctor.email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
