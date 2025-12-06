import { useEffect, useState } from "react";

export const CountDownTimer = () => {
  const [time, setTime] = useState(0);
  const [start, setStart] = useState(false);

  useEffect(() => {
    let interval;

    if (start) {
      interval = setInterval(() => {
        setTime((prev) => prev + 1);
      }, 1000);
    }

    return () => {
      clearInterval(interval);
    };
  }, [start]);

  const handleReset = () => {
    setStart(false); // stop current interval
    setTime(0); // reset value

    // Re-start cleanly AFTER cleanup happens
    setTimeout(() => setStart(true), 0);
  };

  return (
    <>
      <h1>{time}</h1>
      <button onClick={() => setStart(true)}>Start</button>
      <button onClick={() => setStart(false)}>Stop</button>
      <button onClick={handleReset}>Reset</button>
    </>
  );
};
