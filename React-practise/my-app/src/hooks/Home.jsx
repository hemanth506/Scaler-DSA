import React, { useCallback, useEffect, useState } from "react";
import { useDebounce } from "./useDebounce";
import { useThrottle } from "./useThrottle";
import { useLocalStorage } from "./useLocalStorage";

const key = "currCount";

export const Home = () => {
  const [ct, setCt] = useState(0);
  // const debouncedCt = useDebounce(ct, 2)

  // const useThrottleFn = useThrottle(() => {
  //   console.log("Executes in ", Date.now());
  // }, 5);

  // useEffect(() => {
  //   useLocalStorage(key, ct);
  // }, [ct]);

  return (
    <>
      <div>
        {/* <div>{debouncedCt}</div> */}
      </div>
      <button
        onClick={() => {
          setCt((prev) => prev + 1);
          //   useThrottleFn();
        }}
      >
        Increase
      </button>
    </>
  );
};
