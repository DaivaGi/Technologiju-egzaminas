import { useEffect, useState } from 'react';
import { useHref } from 'react-router-dom';

export function CreateComment(props) {
    const [author, setTitle] = useState("");
    const [comment, setText] = useState("");    

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

    const createComment = () => {
        fetch(
            '/api/v1/comments', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    author,
                    comment                    
                })
        }).then(applyResult)
        
    };

  

    return (
        <fieldset id="create">
            <legend>Naujas Komentaras</legend>

            <div>
                <label htmlFor="title">Autorius</label>
                <input id="name" value={author} onChange={(e) => setTitle(e.target.value)}/>
            </div>
            <div>
                <label htmlFor="text">Komentaras</label>               
                <textarea 
                    id="text" 
                    value={comment} 
                    onChange={(e) => setText(e.target.value)} 
                />
            </div>
            <div>
                <button onClick={createComment}>Create</button>
            </div>
        </fieldset>
    )
}