import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";

export function Menu(){
    return(
<div>
<Navbar bg="dark" variant="dark">
        <Container>
        <Link className='text-decoration-none' to={'/'}><Navbar.Brand href="#home">Best Blog</Navbar.Brand></Link>
          <Nav className="me-auto">
          <Link className='text-decoration-none' to={'/'}> <Nav.Link href="#home">Home</Nav.Link> </Link>  
            <Link className='text-decoration-none' to={'blogposts/create/'}><Nav.Link href="#create">Create New Post</Nav.Link></Link>          
          </Nav>
        </Container>
      </Navbar>
</div>
    )
}