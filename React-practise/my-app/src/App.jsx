import React from "react";
import { DebouncedSearch } from "./components/DeboundedSearch";
import { InfiniteScroll } from "./components/InfiniteScroll";
import { LazyLoading } from "./components/LazyLoading";
import { StarRating } from "./components/StarRating";
import { CountDownTimer } from "./components/CountdownTimer";
import  {CommentBox}  from "./components/CommentThread";
import { StepperForm } from "./components/StepperForm";
import { EditableText } from "./components/EditableText";
import { ProtectedRouteHome } from "./components/ProtectedRoute";
import { ProgressBar } from "./components/ProgressBar";
import { Home } from "./hooks/Home";
import { OtpValidator } from "./components/otpValidator";

function App() {
  return (
    <>
      {/* <DebouncedSearch /> */}
      {/* <InfiniteScroll /> */}
      {/* <LazyLoading /> */}
      {/* <StarRating /> */}
      {/* <CountDownTimer /> */}
      {/* <CommentBox /> */}
      {/* <StepperForm /> */}
      {/* <EditableText /> */}
      {/* <ProtectedRouteHome /> */}
      {/* <ProgressBar /> */}
      {/* <Home /> */}
      <OtpValidator />
    </>
  );
}

export default App;
