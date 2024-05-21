import { useEffect, useState } from "react";
import styles from "../AppointmentsPage/styles.module.css";
import { NavLink } from "react-router-dom";

const getAppointments = async () => {
  const userId = JSON.parse(localStorage.getItem("user") || "{}").id;
  const response = await fetch(
    `http://localhost:8080/api/appointments/client/${userId}`
  );
  const data = await response.json();
  return data;
};

const getPaymentByAppointmentId = async (appointmentId: number) => {
  const response = await fetch(
    `http://localhost:8080/api/payments/appointment/${appointmentId}`
  );
  if (response.headers.get("content-length") === "0") {
    return null;
  }
  const data = await response.json();
  console.log(data);
  return data;
};

type Appointment = {
  id: number;
  date: string;
  time: string;
  doctor_id: number;
};

type Payment = {
  id: number;
  amount: number;
  appointmentId: number;
};

export const PaymentsPage = () => {
  const [appointments, setAppointments] = useState<Appointment[]>([]);
  const [payments, setPayments] = useState<Payment[]>([]);

  useEffect(() => {
    getAppointments().then((data) => {
      const appointments = data as Appointment[];
      setAppointments(appointments);
      const appointmentIds = appointments.map((appointment) => appointment.id);
      const payments = appointmentIds.map((appointmentId) =>
        getPaymentByAppointmentId(appointmentId)
      );
      Promise.all(payments).then((payments) => {
        setPayments(payments);
      });
    });
  }, []);

  return (
    <div className={styles.container}>
      <h1>Payments</h1>
      <div className={styles.payments}>
        <table className={styles.table}>
          <thead>
            <tr className={styles.tableHeaderRow}>
              <th className={styles.tableHeader}>Date</th>
              <th className={styles.tableHeader}>Time</th>
              <th className={styles.tableHeader}>Status</th>
            </tr>
          </thead>
          <tbody>
            {appointments.map((appointment: Appointment, index) => (
              <tr
                key={appointment.id}
                className={styles.tableRow}
              >
                <td className={styles.tableCell}>{appointment.date}</td>
                <td className={styles.tableCell}>{appointment.time}</td>
                <td className={styles.tableCell}>
                  {payments[index] ? (
                    "Paid"
                  ) : (
                    <NavLink to={`/payment/${appointment.id}`}>Pay</NavLink>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
