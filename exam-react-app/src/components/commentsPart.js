import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Button } from "bootstrap";

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
          {comments.filter(comment => comment.blogPost === props.id)
          .map(filteredComment => (
            <tr key={filteredComment.id}>
              <td>{filteredComment.createdDate}</td>
              <td>{filteredComment.author}</td>
              <td>{filteredComment.comment}</td>
              <td>                
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
