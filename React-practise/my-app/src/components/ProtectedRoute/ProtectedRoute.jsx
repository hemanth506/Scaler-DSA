import React from "react";

export const ProtectedRoute = ({ element, token }) => {
  if (token !== "1234") {
    return <>Invalid user</>;
  }
  return element;
};
