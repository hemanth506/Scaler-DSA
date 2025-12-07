import { useEffect, useState } from "react";

export const ProgressBar = () => {
  const [percentage, setPercentage] = useState(5);
  const [color, setColor] = useState("tomato");
  const updateColor = (curPer) => {
    if (curPer <= 10) setColor("tomato");
    else if (curPer <= 30) setColor("orange");
    else if (curPer <= 50) setColor("yellow");
    else if (curPer <= 75) setColor("olive");
    else if (curPer <= 90) setColor("green");
    else setColor("teal");
  };

  useEffect(() => {
    const interval = setInterval(() => {
      setPercentage((prev) => {
        if (prev === 100) return 100;
        updateColor(prev + 1);
        return prev + 1;
      });
    }, 400);
    return () => {
      clearInterval(interval);
    };
  }, []);

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
        style={{
          width: "100%",
          border: "1px solid #555",
          borderRadius: "12px",
          padding: "3px",
          background: "#f3f3f3",
        }}
      >
        <div
          style={{
            width: `${percentage}%`,
            backgroundColor: color,
            borderRadius: "10px",
            transition: "width 0.4s ease, background-color 0.3s ease",
            padding: "8px 0",
            display: "flex",
            justifyContent: "center",
            color: "#222",
            fontWeight: "bold",
            minWidth: "40px",
          }}
        >
          {percentage}%
        </div>
      </div>
      <div
        style={{
          display: "flex",
          gap: "20px",
          padding: "10px",
          justifyContent: "center",
          flexDirection: "row",
        }}
      >
        {percentage === 100 && <div>🎉 Completed!</div>}
      </div>
    </div>
  );
};
