import React, { useContext } from "react";
import { useTheme, useMediaQuery, Grid, Typography } from "@mui/material";
import { ProductProps } from "../../../type";
import { Box, Pagination } from "@mui/material";
import HorizontalCard from "../card/VerticalCard";
import { useNavigate } from "react-router-dom";
import Button from "@mui/material/Button";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import { UserContext, CartContext } from "../../../context";
import { addToCartAPI, getCartAPI } from "../../../features/auth/api";

export const Product = ({
  data = [],
  count,
  setPagination,
  pagination,
}: ProductProps) => {
  const navigate = useNavigate();
  const { id } = useContext(UserContext);
  const { cartId, setCartId } = useContext(CartContext);
  const handleAddToCart = (flowerId: any) => {
    if (id == "") navigate("/login");
    if (cartId == "") {
      const cart = getCartAPI(parseInt(id))
        .then((res) => {
          localStorage.setItem("cartId", res[0]?.id);
          setCartId(res[0]?.id);
        })
        .catch((err) => {
          console.log(err);
        });
    }
    addToCartAPI(parseInt(id), flowerId, 1)
      .then()
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <Box
      maxWidth={"1800px"}
      margin={"auto"}
      display={"flex"}
      alignItems={"center"}
      flexDirection={"column"}
      paddingTop={"80px"}
    >
      <Typography
        variant="h2"
        fontWeight={"600"}
        color={"#4b403e"}
        paddingBottom={"32px"}
      >
        Flower List
      </Typography>

      <Grid container spacing={6} display={"flex"} margin={"auto"}>
        {data.map((item) => (
          <Grid key={item.id} item display={"flex"} justifyContent={"center"}>
            <HorizontalCard
              title={item.name}
              content={<p>Price: {item.price}</p>}
              image={item.image}
              action={
                <Button
                  size="small"
                  onClick={() => {
                    handleAddToCart(item.id);
                  }}
                  variant="outlined"
                  sx={{
                    fontSize: "16px",
                    fontWeight: "600",
                    marginBottom: "12px",
                  }}
                >
                  ADD TO CART{" "}
                  <AddShoppingCartIcon
                    sx={{ paddingLeft: "8px" }}
                  ></AddShoppingCartIcon>{" "}
                </Button>
              }
            />
          </Grid>
        ))}
      </Grid>
      <Pagination
        sx={{ marginTop: "40px" }}
        color="primary"
        count={count}
        onChange={(e, p) => {
          setPagination({ ...pagination, offset: p });
        }}
      />
    </Box>
  );
};
