import React, { useEffect, useState } from "react";
import CircularProgress from "@mui/material/CircularProgress";
import { HomeCarousel } from "../../../../components/common/carousel";
import { Grid } from "@mui/material";
import { getProductAPI, getProductCountAPI } from "../api";
import { Product } from "../../../../components/common/product";
import { Pagination, ProductData } from "../../../../type";

type Props = {};

const LandingPage = (props: Props) => {
  const [banner, setBanner] = useState<ProductData[]>([]);
  const [pagination, setPagination] = useState<Pagination>({
    offset: 1,
    limit: 8,
  });
  const [loading, setLoading] = useState<boolean>(false);
  const [count, setCount] = useState<number>(0);

  useEffect(() => {
    getProductCountAPI()
      .then((res) => setCount((res - (res % 8)) / 8 + 1))
      .catch((err) => {
        console.log(err);
      });

    return () => {};
  }, []);

  useEffect(() => {
    getProductAPI(pagination.offset, pagination.limit)
      .then((res) => setBanner([...res]))
      .catch((err) => {
        console.log(err);
      });

    return () => {};
  }, [pagination]);

  return (
    <div>
      <HomeCarousel data={banner} />
      <Product
        data={banner}
        count={count}
        setPagination={setPagination}
        pagination={pagination}
      />
    </div>
  );
};

export default LandingPage;
