import './App.css'
import '@mantine/core/styles.css';


import { createTheme, MantineProvider } from '@mantine/core';
import './App.css'
import { BrowserRouter, Routes } from 'react-router-dom';
import Home from './components/Home/Home.component';

function App() {
  const theme = createTheme({
    colors: {
      'brightSun': ['#fffbeb', '#fff3c6', '#ffe588', '#ffd149', '#ffbd20', '#f99b07', '#dd7302', '#b75006', '#943c0c', '#7a330d',
        '#461902'],
      'mineShaft': ['#f6f6f6', '#e7e7e7', '#d1d1d1', '#b0b0b0', '#888888', '#6d6d6d', '#5d5d5d', '#4f4f4f', '#454545', '#3d3d3d', '#2d2d2d'],
      'green': ['#e9fef4', '#c7f9e0', '#94f4c4', '#55e9a3', '#23d082', '#02ba6a', '#029857', '#037645', '#085e38', '#0a4c2f', '#042a19']
    }
  })
  return (
    <>
      <MantineProvider theme={theme}>
        <BrowserRouter>
          <Routes>

          </Routes>
          <Home />
        </BrowserRouter>
      </MantineProvider>
    </>

  )
}

export default App;