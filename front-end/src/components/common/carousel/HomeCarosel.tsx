import React, { Component } from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { Box, Grid, Container } from "@mui/material";
import { ProductDataArray, ProductProps } from "../../../type";

export const HomeCarousel = ({ data = [] }: ProductDataArray) => {
  const settings = {
    dots: true,
    infinite: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
  };

  return (
    <Box>
      <Slider {...settings}>
        {data.map((item, index) => (
          <div key={index}>
            <img
              src={item.image}
              alt={item.name}
              style={{ width: "100%", height: "600px" }}
            />
          </div>
        ))}
      </Slider>
    </Box>
  );
};
