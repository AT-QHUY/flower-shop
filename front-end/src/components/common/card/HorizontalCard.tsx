import { useMemo } from "react";
import { useTheme } from "@mui/material/styles";
import { styled } from "@mui/material/styles";
import { Grid, Box, Paper, Typography, Button, TextField } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import DeleteIcon from "@mui/icons-material/Delete";
import { Controller, useForm } from "react-hook-form";
interface HorizontalCardProps {
  id: Number;
  image: string;
  name: string;
  price: Number;
  category: string;
}

export const HorizontalCard = ({
  id,
  image,
  name,
  price,
  category,
}: HorizontalCardProps) => {
  const theme = useTheme();
  const inputArray = useMemo(() => {
    return [
      {
        name: "",
        value: "",
        label: "",
        type: "",
        rules: { required: "This field shouldn't be empty" },
      },
      {
        name: "",
        value: "",
        label: "",
        type: "",
        rules: { required: "This field shouldn't be empty" },
      },
      {
        name: "",
        value: "",
        label: "",
        type: "",
        rules: { required: "This field shouldn't be empty" },
      },
    ];
  }, []);

  const {
    control,
    handleSubmit,
    watch,
    formState: { errors },
    reset,
  } = useForm();

  const onSubmit = () => {};

  return (
    <Grid
      container
      spacing={2}
      sx={{
        justifyItems: "center",
        alignItems: "center",
        marginY: "20px",
      }}
    >
      <Grid item xs={3}>
        <img
          style={{
            marginLeft: "20px",
            borderRadius: "16px",
          }}
          height={"240px"}
          width={"280px"}
          src={image}
          alt=""
        />
      </Grid>
      <Grid item xs={2}>
        <Controller
          name={name}
          control={control}
          render={({ field }) => {
            return (
              <TextField
                {...field}
                fullWidth
                variant="standard"
                type="String"
                value={name}
              ></TextField>
            );
          }}
        ></Controller>
      </Grid>
      <Grid item xs={2}>
        <Typography>{category}</Typography>
      </Grid>
      <Grid item xs={2}>
        <Typography variant="inherit">{+price}</Typography>
      </Grid>
      <Grid item xs={3}>
        <Button
          sx={{
            height: "68px",
            width: "68px",
            marginRight: "120px",
            marginLeft: "50px",
            backgroundColor: "#357a38",
          }}
          variant="contained"
        >
          <AddIcon />
        </Button>
        <Button
          sx={{ height: "68px", width: "68px", backgroundColor: "#ff1744" }}
          variant="contained"
        >
          <DeleteIcon />
        </Button>
      </Grid>
    </Grid>
  );
};
