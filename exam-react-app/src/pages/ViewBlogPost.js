import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { CommentsPart } from "../components/commentsPart";


export function ViewBlogPost() {
    const [blogPost, setBlogPost] = useState({});
    
    const params = useParams();

    useEffect(() => {
        fetch('/api/v1/blogposts/' + params.id)
            .then((response) => response.json())
            .then(setBlogPost)
    }, [params.id]);

    return (<div> 

        <div>{blogPost.createdDate}</div>

        
        <div>{blogPost.title}</div>

        
        <div>{blogPost.text}</div>

        {/* <CommentsPart /> */}

        
    </div>);
}
