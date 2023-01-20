import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Button } from "bootstrap";
import { CreateComment } from "./newComment";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function CommentsPart(props) {
  const [comments, setComments] = useState([]);

  const fetchComments = () => {
    fetch("/api/v1/comments")
      .then((response) => response.json())
      .then((jsonResponse) => setComments(jsonResponse));
  };

  useEffect(() => {
    fetchComments();
  }, []);

  return (
    <div>
      
      <table>
        <tbody>
          {comments.map(comment => (
            <tr key={comment.id}>
              <td>{comment.createdDate}</td>
              <td>{comment.author}</td>
              <td>{comment.comment}</td>
              <td>                
              </td>
              
            </tr>
          ))}
        </tbody>
      </table>
      <CreateComment/>
    </div>
  );
}
