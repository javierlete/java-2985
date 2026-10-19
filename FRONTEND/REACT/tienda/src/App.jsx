import { Outlet } from 'react-router';
import './App.css';
import { Menu } from './App/Menu';
import { Pie } from './App/Pie';

function App() {
  return (
    <>
      <Menu />
      <main className="container my-3">
        <Outlet />
      </main>
      <Pie />
    </>
  )
}

export default App
