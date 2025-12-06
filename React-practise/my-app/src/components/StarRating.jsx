import { useEffect, useState } from "react";

export default function HollowStar({ filled, onTrigger }) {
  return (
    <svg
      width={50}
      height={50}
      viewBox="0 0 24 24"
      fill={filled ? "gold" : "none"}
      stroke="black"
      strokeWidth={2}
      strokeLinejoin="round"
      style={{ cursor: "pointer" }}
      onClick={onTrigger}
      onMouseEnter={onTrigger}
    >
      <path d="M12 2 L15 9 H22 L17 14 L19 21 L12 17 L5 21 L7 14 L2 9 H9 Z" />
    </svg>
  );
}


export const StarRating = () => {
  const [rating, setRating] = useState(0);

  const triggerEvent = (num) => {
    setRating(num);
  };

  return (
    <>
      {[1, 2, 3, 4, 5].map((num) => (
        <HollowStar
          key={num}
          filled={num <= rating}
          onTrigger={() => triggerEvent(num)}
          onMouseEnter={() => triggerEvent(num)}
        />
      ))}
    </>
  );
};

