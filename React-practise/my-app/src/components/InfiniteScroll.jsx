import { useEffect, useRef, useState } from "react";

const PAGE_SIZE = 30;

export const InfiniteScroll = () => {
  const [todos, setTodos] = useState([]);
  const [page, setPage] = useState(1);
  const loadRef = useRef(null);

  useEffect(() => {
    const url = `https://jsonplaceholder.typicode.com/todos?_page=${page}&_limit=${PAGE_SIZE}`;
    fetch(url)
      .then((response) => response.json())
      .then((json) => {
        setTodos((prev) => [...prev, ...json]);
      })
      .catch((err) => console.error("fetch todos failed", err));
  }, [page]);

  useEffect(() => {
    const obs = new IntersectionObserver((entries) => {
      const entry = entries[0];
      if (entry && entry.isIntersecting) {
        console.log("is intersecting", page);
        setPage((prev) => prev + 1);
      }
    }, { root: null, rootMargin: '0px', threshold: 0.1 });

    const curRef = loadRef.current;
    if (curRef) {
      obs.observe(curRef);
    }

    return () => {
      if (curRef) {
        obs.unobserve(loadRef.current);
        obs.disconnect();
      }
    };
  }, [todos.length]);

  return (
    <>
      {todos &&
        todos.map((todo, idx) => (
          <li key={idx} ref={idx === todos.length - 1 ? loadRef : null}>
            {todo.title}
          </li>
        ))}
    </>
  );
};
