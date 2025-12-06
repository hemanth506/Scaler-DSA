import { useState } from "react";

const CommentThread = ({ updateReply, com }) => {
  const [text, setText] = useState("");
  const [showInput, setShowInput] = useState(false);
  const postClickEvent = () => {
    updateReply(com.id, text);
    setText("");
    setShowInput(false);
  };

  return (
    <div style={{ paddingLeft: "25px", paddingTop: "15px" }}>
      <span>{com.text}</span>
      <br />
      <span
        style={{ cursor: "pointer", fontSize: "10px" }}
        onClick={() => setShowInput(!showInput)}
      >
        Reply
      </span>
      {showInput && (
        <div>
          <input
            type="text"
            value={text}
            onChange={(e) => setText(e.target.value)}
          />
          <button onClick={postClickEvent}>Post</button>
        </div>
      )}

      {com.children &&
        com.children.map((child) => (
          <CommentThread key={child.id} com={child} updateReply={updateReply} />
        ))}
    </div>
  );
};

export const CommentBox = () => {
  const [comments, setComments] = useState([]);
  const [text, setText] = useState("");

  const updateReply = (parentId, replyText) => {
    if (parentId !== null) {
      function recursivelyUpdate(list) {
        return list.map((com) => {
          if (com.id === parentId) {
            return {
              ...com,
              children: [
                ...com.children,
                { id: Date.now(), text: replyText, children: [] },
              ],
            };
          }
          return { ...com, children: recursivelyUpdate(com.children) };
        });
      }
      setComments(recursivelyUpdate(comments));
    } else {
      const newComments = [
        ...comments,
        { id: Date.now(), text: text, children: [] },
      ];
      setComments(newComments);
    }
  };

  const commentClickEvent = () => {
    if (!text.trim()) return;
    updateReply(null, text);
    setText("");
  };

  return (
    <>
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
      />
      <button onClick={commentClickEvent}>Comment</button>
      {comments &&
        comments.map((com) => (
          <CommentThread key={com.id} updateReply={updateReply} com={com} />
        ))}
    </>
  );
};
