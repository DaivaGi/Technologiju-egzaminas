import { HashRouter, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Menu } from './components/menu';
import { BlogPostListPage } from './pages/BlogPostList';
import { ViewBlogPost } from './pages/ViewBlogPost';
import { CreateNewBlogPost } from './pages/CreateNewBlogPost';

function App() {
  return (
    <div className='container'>
      <HashRouter>
        <Menu />

        <Routes>
        <Route path='/' element={<BlogPostListPage />} />
        <Route path='/blogposts/view/:id' element={<ViewBlogPost />} />
        <Route path='blogposts/create' element={<CreateNewBlogPost/>} />
          {/* 
          
          
          <Route path='/animals/update/:id' element={<UpdateAnimalPage />} /> */}
        </Routes>
      </HashRouter> 
    </div>
  );
}

export default App;
