import React, { useState } from "react";

export const ProgressBar = () => {
  const [percentage, setPercentage] = useState(10);
  const [color, setColor] = useState("tomato");
  const updateColor = (curPer) => {
    if (curPer <= 10) {
      setColor("tomato");
    } else if (curPer <= 30) {
      setColor("orange");
    } else if (curPer <= 50) {
      setColor("yellow");
    } else if (curPer <= 70) {
      setColor("olive");
    } else if (curPer <= 90) {
      setColor("green");
    } else {
      setColor("teal");
    }
  };
  const handlePlus = () => {
    if (percentage === 100) return;
    setPercentage((prev) => {
      updateColor(prev + 10);
      return prev + 10;
    });
  };

  const handleMinus = () => {
    if (percentage === 10) return;
    setPercentage((prev) => {
      updateColor(prev - 10);
      return prev - 10;
    });
  };
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        width: "80%",
      }}
    >
      <h3>Progress Bar</h3>
      <div
        id="outer"
        style={{
          width: "100%",
          border: "1px solid black",
          borderRadius: "10px",
        }}
      >
        <div
          id="inner"
          style={{
            display: "flex",
            justifyContent: "center",
            width: `${percentage}%`,
            backgroundColor: `${color}`,
            borderRadius: "10px",
          }}
        >
          <strong>{percentage}%</strong>
        </div>
      </div>
      <div
        style={{
          display: "flex",
          gap: "20px",
          padding: "10px",
          justifyContent: "center"
        }}
      >
        <button onClick={handleMinus}>-10</button>
        <button onClick={handlePlus}>+10</button>
      </div>
    </div>
  );
};
