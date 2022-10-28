import {
  Box,
  Button,
  createTheme,
  Grid,
  Collapse,
  IconButton,
  Alert,
} from "@mui/material";
import { useContext, useEffect, useState } from "react";
import { CartContext, UserContext } from "../../../../context";
import { CartItem, CartProps } from "../../../../type";
import { confirmOrderAPI, getCartAPI } from "../../../auth/api";
import { CartElement } from "../components/CartElement";
import CloseIcon from "@mui/icons-material/Close";
import { useNavigate } from "react-router-dom";

const theme = createTheme({
  palette: {
    primary: {
      light: "#757ce8",
      main: "#3f50b5",
      dark: "#002884",
      contrastText: "#fff",
    },
    secondary: {
      light: "#ff7961",
      main: "#f44336",
      dark: "#ba000d",
      contrastText: "#000",
    },
  },
});

export const ShoppingCart = () => {
  const [openToast, setOpenToast] = useState(false);
  const [cartProps, setCartProps] = useState<CartItem[]>([]);
  const { cartId, cart, setCart, setCartId } = useContext(CartContext);
  const { id } = useContext(UserContext);
  const navigate = useNavigate();

  const handleConfirmCart = () => {
    if (cartId) {
      confirmOrderAPI(parseInt(cartId))
        .then((res) => {
          setOpenToast(true);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  };

  useEffect(() => {
    getCartAPI(parseInt(id))
      .then((res) => {
        const cartDetail: CartItem[] = res ? res[0]?.listDetail : [];
        localStorage.setItem("cartId", res[0]?.id);
        setCartId(res[0]?.id);
        setCartProps(cartDetail);
      })
      .catch((err) => {
        if (err.response.status == 403) navigate("/login");
      });

    return () => {};
  }, []);

  return (
    <Box>
      <Grid container alignItems={"center"} direction="column" paddingY="24px">
        <Grid
          container
          spacing={4}
          justifyContent={"center"}
          direction="column"
          width={"1200px"}
        >
          {cartProps?.map((item, index) => (
            <CartElement
              id={item.id}
              key={item.id}
              quantity={item.quantity}
              flower={item.flower}
            />
          ))}
        </Grid>
        <Grid item>
          <Button
            variant="contained"
            sx={{
              background: theme.palette.secondary.main,
              height: "48px",
              width: "140px",
              marginTop: "40px",
            }}
            onClick={handleConfirmCart}
          >
            BUY NOW
          </Button>
        </Grid>
      </Grid>
      <Collapse in={openToast}>
        <Alert
          action={
            <IconButton
              aria-label="close"
              color="inherit"
              size="small"
              onClick={() => {
                setOpenToast(false);
              }}
            >
              <CloseIcon fontSize="inherit" />
            </IconButton>
          }
          sx={{ mb: 2 }}
        >
          Close me!
        </Alert>
      </Collapse>
    </Box>
  );
};
