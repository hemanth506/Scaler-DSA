import { useState, useRef } from "react";

export const EditableText = () => {
  const [text, setText] = useState("");
  const spanRef = useRef(null);
  const inputRef = useRef(null);

  const clickEvent = () => {
    if (inputRef.current && spanRef.current) {
      inputRef.current.style.display = "block";
      spanRef.current.style.display = "none";
    }
  };

  const divClickEvent = () => {
    if (inputRef.current && spanRef.current) {
      inputRef.current.style.display = "none";
      spanRef.current.style.display = "block";
    }
  };

  const handleKeyDown = (e) => {
    if(e.key === 'Enter') {
        e.preventDefault();
        divClickEvent();
    }
  }

  return (
    <div>
      <h2>Editable text</h2>
      <span ref={spanRef} onClick={clickEvent} style={{ display: "block", cursor: "pointer" }}>
        {text || 'Click to edit'}
      </span>
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        ref={inputRef}
        style={{ display: "none" }}
        onBlur={divClickEvent}
        onKeyDown={handleKeyDown}
      />
    </div>
  );
};
