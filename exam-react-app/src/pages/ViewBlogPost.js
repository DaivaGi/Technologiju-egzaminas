import { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { useParams, NavLink } from "react-router-dom";
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

        <div className="mt-5" ><em>{blogPost.createdDate}</em></div>

        
        <h1 className="text-center mt-3 mb-5">{blogPost.title}</h1>

        
        <div>{blogPost.text}</div>
        <div className="d-grid justify-content-md-end">
        <Button variant="dark" className="mt-5" as={NavLink} exact to='/'>Atgal</Button>
        </div>
        <hr  className="hr my-5"/>
        

        {<CommentsPart id={params.id} />}

        
    </div>);
}
