import "./App.css";
import { AppRoute } from "./routes/AppRoute";
import { createTheme } from "@mui/material/styles";
import CartProvider from "./context/CartProvider";
import { UserProvider } from "./context";

function App() {
  return (
    <CartProvider>
      <UserProvider>
        <AppRoute />
      </UserProvider>
    </CartProvider>
  );
}

export default App;
