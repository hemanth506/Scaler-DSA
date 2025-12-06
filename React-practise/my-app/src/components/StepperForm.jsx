import { useEffect, useState, useRef } from "react";

export const StepperForm = () => {
  const [curPage, setCurPage] = useState(0);
  const parentRef = useRef(null);
  const prevEvent = () => {
    setCurPage((prev) => {
      if (prev === 0) {
        return 4;
      } else {
        return prev - 1;
      }
    });
  };

  const nextEvent = () => {
    setCurPage((prev) => {
      if (prev === 4) {
        return 0;
      } else {
        return prev + 1;
      }
    });
  };

  useEffect(() => {
    if (parentRef.current) {
      const childNodes = parentRef.current.children;
      for (let nodes of childNodes) {
        if (nodes.id == `child-${curPage}`) {
          nodes.style.display = "block";
        } else {
          nodes.style.display = "none";
        }
      }
    }
  }, [curPage]);
  return (
    <>
      <div>Stepper form</div>
      <div id="Parent" ref={parentRef}>
        <div id="child-0" style={{ display: "block" }}>
          <h5>Page 1</h5>
          <input type="text" placeholder="Enter first name" />
          <input type="text" placeholder="Enter last name" />
        </div>
        <div id="child-1" style={{ display: "block" }}>
          <h5>Page 2</h5>
          <input type="text" placeholder="Enter DOB" />
          <input type="text" placeholder="Enter Blood group" />
        </div>
        <div id="child-2" style={{ display: "block" }}>
          <h5>Page 3</h5>
          <input type="text" placeholder="Enter Address" />
          <input type="text" placeholder="Enter City" />
          <input type="text" placeholder="Enter State" />
        </div>
        <div id="child-3" style={{ display: "block" }}>
          <h5>Page 4</h5>
          <input type="text" placeholder="Enter Spouse name" />
          <input type="text" placeholder="Enter Mother name" />
          <input type="text" placeholder="Enter Father name" />
        </div>
        <div id="child-4" style={{ display: "block" }}>
          <h5>Page 5</h5>
          <input type="text" placeholder="Enter Occupication" />
        </div>
      </div>
      <div style={{ display: "flex", gap: "30px", fontSize: "10px" }}>
        <span onClick={prevEvent} style={{ cursor: "pointer" }}>
          Previous
        </span>
        <span onClick={nextEvent} style={{ cursor: "pointer" }}>
          Next
        </span>
      </div>
    </>
  );
};
