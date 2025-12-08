import React, { useState, useEffect } from "react";

export const useDebounce = (value, delay) => {
  const [debounceVal, setDebouncVal] = useState(value);
  useEffect(() => {
    const timeout = setTimeout(() => {
        setDebouncVal(value)
    }, delay * 1000);

    return () => {
      clearTimeout(timeout);
    };
  }, [value]);
  return debounceVal;
};
