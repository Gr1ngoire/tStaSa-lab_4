import { useEffect, useState } from "react";
import styles from "./styles.module.css";
import { Button } from "../../../../components/Button/Button";

type Appointment = {
  id?: number;
  date: string;
  time: string;
};

const days = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
const months = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December",
];

const hours = ["08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00"];

const fetchAppointments = async () => {
  const response = await fetch("http://localhost:8080/api/appointments");
  const data = await response.json();
  return data;
};

export const AppointmentsPage = () => {
  const [appointments, setAppointments] = useState<Appointment[]>([]);
  const [week, setWeek] = useState<number>(0);

  const createAppointment = async (appointment: Appointment) => {
    await fetch("http://localhost:8080/api/appointments", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(appointment),
    })
      .then((response) => response.json())
      .then((data) =>
        setAppointments((appointments) => [...appointments, data])
      );
  };

  useEffect(() => {
    fetchAppointments().then((data) => setAppointments(data));
  }, []);

  // get day of this week monday
  const thisWeek = new Date();
  const selectedWeek = new Date(
    thisWeek.setDate(thisWeek.getDate() - thisWeek.getDay() + 1 + week * 7)
  );

  const thisWeekAppointments = days.map(
    (day, index) =>
      appointments.filter(
        (appointment) =>
          appointment.date ===
          new Date(selectedWeek.getTime() + index * 24 * 60 * 60 * 1000)
            .toISOString()
            .slice(0, 10)
      ) || {}
  );

  return (
    <div className={styles.container}>
      <h1>Appointments</h1>
      <div className={styles.appointments}>
        <table className={styles.table}>
          <thead>
            <tr className={styles.tableHeaderRow}>
              <th className={styles.tableHeader}></th>
              {days.map((day, index) => (
                <th
                  key={index}
                  className={styles.tableHeader}
                >
                  <div className={styles.day}>
                    <span>{day}</span>
                    <span className={styles.date}>
                      {
                        months[
                          new Date(
                            selectedWeek.getTime() + index * 24 * 60 * 60 * 1000
                          ).getMonth()
                        ]
                      }{" "}
                      {new Date(
                        selectedWeek.getTime() + index * 24 * 60 * 60 * 1000
                      ).getDate()}
                    </span>
                  </div>
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {hours.map((hour, index) => (
              <tr
                key={index}
                className={styles.tableRow}
              >
                <td className={styles.tableData}>{hour}</td>
                {thisWeekAppointments.map((day, index) => (
                  <td
                    key={index}
                    className={styles.tableData}
                  >
                    {!day.find((appointment) => appointment.time === hour) ? (
                      <button
                        className={styles.appointmentFree}
                        key={index}
                        onClick={() =>
                          createAppointment({
                            date: new Date(
                              selectedWeek.getTime() +
                                index * 24 * 60 * 60 * 1000
                            )
                              .toISOString()
                              .slice(0, 10),
                            time: hour,
                          })
                        }
                      >
                        +
                      </button>
                    ) : (
                      <div
                        className={styles.appointmentTaken}
                        key={index}
                      >
                        Taken
                      </div>
                    )}
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
        <div className={styles.week}>
          <Button
            onClick={() => setWeek(week - 1)}
            text="Previous week"
            disabled={week === 0}
          />
          <Button
            onClick={() => setWeek(week + 1)}
            text="Next week"
          />
        </div>
      </div>
    </div>
  );
};
