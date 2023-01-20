import { useEffect, useState } from 'react';
import { useHref } from 'react-router-dom';

export function CreateNewBlogPost(props) {
    const [title, setTitle] = useState("");
    const [text, setText] = useState("");    

    const listUrl = useHref('/');

    const clear = () => {
        setTitle("");
        setText("");       
    }

    const applyResult = (result) => {
        if (result.ok) {
            clear();
        } else {
            window.alert("Nepavyko sukurt: " + result.status);
        }
    };

    const createBlogPost = () => {
        fetch(
            '/api/v1/blogposts', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    title,
                    text                    
                })
        }).then(applyResult)
        .then(() => window.location = listUrl);
    };

    useEffect(() => {
        if (title === "") {
            document.getElementById('name').style.background = 'red';
        } else {
            document.getElementById('name').style.background = 'green';
        }
    });

    return (
        <fieldset id="create">
            <legend>Sukurti naują įrašą</legend>

            <div>
                <label htmlFor="title">Įrašo pavadinimas</label>
                <input id="name" value={title} onChange={(e) => setTitle(e.target.value)}/>
            </div>
            <div>
                <label htmlFor="text">Text</label>               
                <textarea 
                    id="text" 
                    value={text} 
                    onChange={(e) => setText(e.target.value)} 
                />
            </div>
            <div>
                <button onClick={createBlogPost}>Create</button>
            </div>
        </fieldset>
    )
}