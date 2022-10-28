import * as React from "react";
import Card, { CardProps } from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import { Box } from "@mui/system";

interface HorizontalCardProps extends CardProps {
  image: string;
  title: string;
  content: React.ReactNode;
  action?: React.ReactNode;
}

export default function VerticalCard({
  image,
  content,
  title,
  action,
  sx,
  ...rest
}: HorizontalCardProps) {
  return (
    <Card sx={{ width: 400, ...sx }} {...rest}>
      <CardMedia
        component="img"
        width="100%"
        height="240"
        image={image}
        alt="green iguana"
      />
      <CardContent sx={{ paddingBottom: "0" }}>
        <Typography gutterBottom variant="h5" component="div">
          {title}
        </Typography>
        <Typography gutterBottom variant="subtitle1" component="div">
          {content}
        </Typography>
      </CardContent>
      {action && (
        <CardActions>
          <Box display={"flex"} justifyContent={"space-between"}>
            {action}
          </Box>
        </CardActions>
      )}
    </Card>
  );
}
