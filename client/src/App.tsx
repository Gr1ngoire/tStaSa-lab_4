import { Navigate, Route, Routes } from "react-router-dom";
import "./App.css";
import { LoginPage } from "./pages/LoginPage/LoginPage";
import { RegisterPage } from "./pages/RegisterPage/RegisterPage";
import { MainPage } from "./pages/MainPage/MainPage";
import { HomePage } from "./pages/MainPage/components/HomePage/HomePage";
import { AppointmentsPage } from "./pages/MainPage/components/AppointmentsPage/AppointmentsPage";
import { ContactsPage } from "./pages/MainPage/components/ContactsPage/ContactsPage";
import { PaymentsPage } from "./pages/MainPage/components/PaymentsPage/PaymentsPage";

function App() {
  return (
    <>
      <header>
        <h1>Dental clinic app </h1>
      </header>
      <main>
        <Routes>
          <Route
            path="/"
            element={<Navigate to="/login" />}
          />
          <Route
            path="/login"
            element={<LoginPage />}
          />
          <Route
            path="/register"
            element={<RegisterPage />}
          />
          <Route
            path="/home"
            element={<MainPage />}
            children={[
              <Route
                path="/home"
                element={<HomePage />}
              />,
              <Route
                path="appointments"
                element={<AppointmentsPage />}
              />,
              <Route
                path="payments"
                element={<PaymentsPage />}
              />,
              <Route
                path="contacts"
                element={<ContactsPage />}
              />,
            ]}
          />
        </Routes>
      </main>
    </>
  );
}

export default App;
