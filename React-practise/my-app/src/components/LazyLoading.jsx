import { useEffect, useRef, useState, Suspense } from "react";

const PAGE_SIZE = 30;

export const LazyLoading = () => {
  const [todos, setTodos] = useState([]);
  const imgRef = useRef(null);
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    const url = `https://jsonplaceholder.typicode.com/todos?_page=1&_limit=${PAGE_SIZE}`;
    fetch(url)
      .then((response) => response.json())
      .then((json) => {
        setTodos((prev) => [...prev, ...json]);
      })
      .catch((err) => console.error("fetch todos failed", err));
  }, []);

  useEffect(() => {
    const obs = new IntersectionObserver(([entry]) => {
      if (entry.isIntersecting) {
        setIsVisible(() => true);
      }
    });
    if (imgRef.current) {
      obs.observe(imgRef.current);
    }

    return () => {
      if (imgRef.current) {
        obs.unobserve(imgRef.current);
      }
    };
  });

  return (
    <>
      {todos && todos.map((todo, idx) => <li key={idx}>{todo.title}</li>)}
      <img
        src={
          isVisible
            ? "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Kobe_Bryant_Dec_2014.jpg/500px-Kobe_Bryant_Dec_2014.jpg"
            : null
        }
        alt="lazy-load-image"
        ref={imgRef}
      />
    </>
  );
};
