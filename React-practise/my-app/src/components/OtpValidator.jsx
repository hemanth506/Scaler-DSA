import { useEffect, useRef, useState } from "react";

export const OtpValidator = () => {
  const [input, setInput] = useState(Array(5).fill(""));
  const inputRefs = useRef([]);

  useEffect(() => {
    if (inputRefs.current) {
      inputRefs.current[0].focus();
    }
  }, []);

  const handleClickEvent = (e, idx) => {
    const value = e.target.value;
    console.log("trigger number", value);
    if (!/^[0-9]?$/.test(value)) return;

    const newArr = [...input];
    newArr[idx] = value;
    setInput(newArr);

    if (value && idx < 4) {
      inputRefs.current[idx + 1].focus();
    }
  };

  const keyDownEvent = (e, idx) => {
    console.log("trigger Backspace");
    if (e.key === "Backspace") {
      if (input[idx] === "" && idx > 0) {
        inputRefs.current[idx - 1].focus();
      }
    }
  };

  return (
    <div
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      <div>
        <h2>OPT validator</h2>
      </div>
      <div style={{ display: "flex", gap: "3px" }}>
        {input.map((val, idx) => (
          <input
            ref={(el) => (inputRefs.current[idx] = el)}
            style={inputStyle}
            key={idx}
            maxLength={1}
            onChange={(e) => handleClickEvent(e, idx)}
            onKeyDown={(e) => keyDownEvent(e, idx)}
            value={val}
          />
        ))}
      </div>
    </div>
  );
};

const inputStyle = {
  width: "20px",
  height: "30px",
  caretColor: "transparent",
  borderRadius: "8px",
  border: "2px solid #ccc",
  textAlign: "center",
};
