import React from "react";
import { DebouncedSearch } from "./components/DeboundedSearch";
import { InfiniteScroll } from "./components/InfiniteScroll";
import { LazyLoading } from "./components/LazyLoading";
import { StarRating } from "./components/StarRating";
import { CountDownTimer } from "./components/CountdownTimer";
import  {CommentBox}  from "./components/CommentThread";

function App() {
  return (
    <>
      {/* <DebouncedSearch /> */}
      {/* <InfiniteScroll /> */}
      {/* <LazyLoading /> */}
      {/* <StarRating /> */}
      {/* <CountDownTimer /> */}
      <CommentBox />
    </>
  );
}

export default App;
