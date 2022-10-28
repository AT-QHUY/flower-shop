import { Box } from "@mui/material";
import * as React from "react";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { OrderDetail } from "../../../type/index";

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.primary.main,
    color: theme.palette.common.white,
    fontSize: 18,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 16,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  "&:nth-of-type(odd)": {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  "&:last-child td, &:last-child th": {
    border: 0,
  },
}));

interface OrderProps {
  count: Number;
  orderDetailArray: OrderDetail[];
  status: Number;
}

const statusArray = ["Canceled", "In cart", "On progress", "Finished"];

export const OrderItem = ({ count, orderDetailArray, status }: OrderProps) => {
  return (
    <TableContainer component={Paper} sx={{ marginTop: "20px" }}>
      <Table sx={{ minWidth: 700 }} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell
              sx={{
                paddingLeft: "60px",
                fontSize: "24px",
                fontWeight: "600",
                backgroundColor: "#333333",
              }}
            >{` Order so ${count}`}</StyledTableCell>
            <StyledTableCell align="center">Name</StyledTableCell>
            <StyledTableCell align="center">Quantity</StyledTableCell>
            <StyledTableCell align="center">Price</StyledTableCell>
            <StyledTableCell align="center">
              {statusArray[+status]}
            </StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {orderDetailArray.map((detail) => (
            <StyledTableRow key={detail.id}>
              <StyledTableCell
                sx={{ paddingLeft: "40px" }}
                align="left"
                component="th"
                scope="row"
              >
                <Box
                  component="img"
                  sx={{
                    height: 200,
                    width: 240,
                  }}
                  alt="The house from the offer."
                  src={detail.flower.image}
                />
              </StyledTableCell>
              <StyledTableCell align="center">
                {detail.flower.name}
              </StyledTableCell>
              <StyledTableCell align="center">
                {detail.quantity}
              </StyledTableCell>
              <StyledTableCell align="center">
                {detail.flower.price}
              </StyledTableCell>
              <StyledTableCell align="center"></StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};
