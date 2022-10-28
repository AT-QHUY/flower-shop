import {
  Box,
  Button,
  Card,
  CardContent,
  Grid,
  Typography,
  Input,
  TextField,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import { CartItem } from "../../../../type";
import AddIcon from "@mui/icons-material/Add";
import { useState } from "react";
import { deleteCartItemAPI, updateCartAPI } from "../../../auth/api";

interface CartElementProps extends CartItem {}

export const CartElement = ({ id, flower, quantity }: CartElementProps) => {
  const handleAdd = () => {
    updateCartAPI(id, flowerQuantity)
      .then(() => {
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
      });
  };
  const [flowerQuantity, setFlowerQuantity] = useState(quantity);
  const handleDelete = () => {
    deleteCartItemAPI(id)
      .then(() => {
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
      });
  };
  const handleChange = (e: any) => {
    setFlowerQuantity(e.target.value < 1 ? 1 : e.target.value);
  };
  return (
    <Grid
      item
      container
      boxShadow={2}
      display={"flex"}
      marginY={"20px"}
      alignItems="center"
      padding={"32px"}
      spacing={3}
    >
      <Grid xs={3} item>
        <img
          style={{
            height: "200px",
            width: "100%",
            objectFit: "cover",
            borderRadius: "12px",
            border: "1px solid #cacaca",
          }}
          src={flower?.image}
          alt="flower"
        ></img>
      </Grid>
      <Grid xs={7} item height="200px">
        <Card
          sx={{
            boxShadow: 0,
            display: "flex",
            flexDirection: "column",
            height: "100%",
            justifyContent: "space-between",
          }}
        >
          <CardContent>
            <Typography component="div" variant="h4" fontWeight={600}>
              {flower?.name}
            </Typography>
            <Typography
              variant="subtitle1"
              color="text.secondary"
              component="div"
              fontSize={"18px"}
            >
              {flower?.category?.name}
            </Typography>
          </CardContent>
          <CardContent>
            <Box display={"flex"} flexDirection={"row"} alignItems={"center"}>
              <Box
                display={"flex"}
                flexDirection={"row"}
                paddingRight={"100px"}
              >
                <Typography
                  fontWeight={600}
                  fontSize={"16px"}
                  paddingRight={"12px"}
                >
                  Price:{" "}
                </Typography>
                <Typography fontWeight={600} color={"#F53838"}>
                  {flower?.price}$
                </Typography>
              </Box>
              <TextField
                id="outlined-number"
                label="Quantity"
                type="number"
                InputLabelProps={{
                  shrink: true,
                }}
                onChange={handleChange}
                value={flowerQuantity}
              />
            </Box>
          </CardContent>
        </Card>
      </Grid>
      <Grid
        xs={2}
        item
        display={"flex"}
        justifyContent={"space-between"}
        paddingX={"16px"}
      >
        <Button
          variant="contained"
          sx={{ aspectRatio: "1/1" }}
          color={"success"}
          onClick={handleAdd}
        >
          <AddIcon />
        </Button>
        <Button
          variant="contained"
          sx={{ aspectRatio: "1/1" }}
          color={"error"}
          onClick={handleDelete}
        >
          <DeleteIcon />
        </Button>
      </Grid>
    </Grid>
  );
};
