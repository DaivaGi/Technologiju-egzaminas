import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Button } from "bootstrap";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function BlogPostListPage() {
  const [blogPosts, setBlogPosts] = useState([]);

  const fetchBlogPosts = async () => {
    fetch("/api/v1/blogposts")
      .then((response) => response.json())
      .then((jsonResponse) => setBlogPosts(jsonResponse));
  };

  useEffect(() => {
    fetchBlogPosts();
  }, []);

  return (
    <div>
      
      <table>
        <tbody>
          {blogPosts.map((blogPost) => (
            <tr key={blogPost.id}>
              <td>{blogPost.createdDate}</td>
              <td>{blogPost.title}</td>
              <td>{blogPost.text}</td>
              <td>
                <Link to={"blogposts/view/" + blogPost.id}>
                  <button variant="outline-success">Daugiau...</button>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
