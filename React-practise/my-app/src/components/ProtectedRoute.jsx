const ProtectedRoute = ({ element, token }) => {
  if (token !== "1234") {
    return <>Invalid user</>;
  }
  return element;
};

const Analytics = () => {
  return (
    <div>Analytics</div>
  )
}

const DashBoard = () => {
  return (
    <div>DashBoard</div>
  )
}

export const ProtectedRouteHome = () => {
  return (
    <div>
      <h4>Protected Route</h4>
      <ProtectedRoute element={<Analytics />} token={""} />
      <ProtectedRoute element={<DashBoard />} token={"1234"} />
    </div>
  );
};
