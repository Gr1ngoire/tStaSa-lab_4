import { useEffect, useState } from "react";
import styles from "../AppointmentsPage/styles.module.css";

type User = {
  id: number;
  name: string;
};

type Appointment = {
  id: number;
  date: string;
  time: string;
  client_id: number;
  doctor_id: number;
};

type Doctor = {
  id: number;
  name: string;
};

const getAppointments = async () => {
  const userId = JSON.parse(localStorage.getItem("user") || "{}").id;
  const response = await fetch(
    `http://localhost:8080/api/appointments/client/${userId}`
  );
  const data = await response.json();
  return data;
};

const getDoctorById = async (doctorId: number) => {
  const response = await fetch(`http://localhost:8080/api/doctors/${doctorId}`);
  const data = await response.json();
  return data;
};

export const HomePage = () => {
  const user = JSON.parse(localStorage.getItem("user") || "{}") as User;

  const [appointments, setAppointments] = useState<Appointment[]>([]);
  const [doctors, setDoctors] = useState<Doctor[]>([]);

  useEffect(() => {
    getAppointments().then((data) => {
      const appointments = data as Appointment[];
      const doctorIds = appointments.map(
        (appointment) => appointment.doctor_id
      );
      const doctors = doctorIds.map((doctorId) => getDoctorById(doctorId));

      Promise.all(doctors).then((doctors) => {
        setDoctors(doctors);
      });
      setAppointments(appointments);
    });
  }, []);

  return (
    <div className={styles.container}>
      <h2>Welcome, {user.name}!</h2>
      <h3>Your appointments:</h3>
      <table className={styles.table}>
        <thead>
          <tr className={styles.tableHeaderRow}>
            <th className={styles.tableHeader}>Date</th>
            <th className={styles.tableHeader}>Time</th>
            <th className={styles.tableHeader}>Doctor</th>
          </tr>
        </thead>
        <tbody>
          {appointments.map((appointment, index) => (
            <tr
              key={appointment.id}
              className={styles.tableRow}
            >
              <td className={styles.tableCell}>{appointment.date}</td>
              <td className={styles.tableCell}>{appointment.time}</td>
              <td className={styles.tableCell}>{doctors[index]?.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
