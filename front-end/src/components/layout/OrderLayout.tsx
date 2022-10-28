import { Box } from "@mui/material";
import { useContext, useState, useEffect } from "react";
import { UserContext } from "../../context";
import { getOrderByUser_IdAPI } from "../../features/home/landing/api";
import { Order } from "../../type";
import { OrderItem } from "../common/order";
import { styled } from "@mui/material/styles";
import { useNavigate } from "react-router-dom";

const Div = styled("div")(({ theme }) => ({
  ...theme.typography.button,
  padding: theme.spacing(1),
  color: "#303030",
  fontSize: "28px",
  fontWeight: "600",
  paddingTop: "40px",
}));

export const OrderLayout = () => {
  const { id } = useContext(UserContext);
  const [orderList, setOrderList] = useState<Order[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    getOrderByUser_IdAPI(parseInt(id))
      .then((res) => {
        setOrderList(res);
      })
      .catch((err) => {
        if (err.response.status == 403) {
          navigate("/login");
        }
      });
  }, []);

  return (
    <Box
      display={"flex"}
      flexDirection={"column"}
      justifyContent={"center"}
      alignItems={"center"}
    >
      <Div>{"Order List"}</Div>
      {orderList.map((item, index) => (
        <OrderItem
          key={index}
          count={index + 1}
          orderDetailArray={item.listDetail}
          status={item.status}
        />
      ))}
    </Box>
  );
};
