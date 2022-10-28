import { Box } from "@mui/material";
import { useState, useEffect } from "react";
import { getAllProductAPI } from "../../../features/dashboard/api";
import { ProductData } from "../../../type";
import { HorizontalCard } from "../card";

export const Dashboard = () => {
  const [flowerList, setflowerList] = useState<ProductData[]>([]);
  useEffect(() => {
    getAllProductAPI()
      .then((data) => {
        setflowerList(data);
      })
      .catch((err) => {
        console.log(err);
      });
    return () => {};
  }, []);

  return (
    <Box>
      {flowerList.map((item) => (
        <HorizontalCard
          key={item.id}
          id={item.id}
          category={item.category.name}
          image={item.image}
          name={item.name}
          price={+item.price}
        />
      ))}
    </Box>
  );
};
