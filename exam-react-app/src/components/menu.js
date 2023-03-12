import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";
import flower from "../images/flower.png";

export function Menu(){
    return(
<div>
<Navbar bg="dark" variant="dark">
        <Container>
        <Link className='text-decoration-none' to={'/'}><Navbar.Brand href="#home"><img
              alt=""
              src={flower}
              // src="../images/flower.png"
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{' '} Best Blog</Navbar.Brand></Link>
          <Nav className="me-auto">            
            <Link className='text-decoration-none' to={'blogposts/create/'}><Nav.Link href="#create">Kurti naują įrašą</Nav.Link></Link>          
          </Nav>
        </Container>
      </Navbar>
</div>
    )
}