import React from "react";
import { ProtectedRoute } from "./ProtectedRoute";
import { Analytics } from "./Analytics";
import { DashBoard } from "./DashBoard";

export const Home = () => {
  return (
    <div>
      <h4>Protected Route</h4>
      <ProtectedRoute element={<Analytics />} token={""} />
      <ProtectedRoute element={<DashBoard />} token={"1234"} />
    </div>
  );
};
