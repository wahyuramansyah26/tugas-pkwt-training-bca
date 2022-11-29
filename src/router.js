import React from 'react'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './pages/home'
import Detail from './pages/details'
import Login from './pages/login'
import Signup from './pages/signup'

function Router() {
  return (
    <BrowserRouter>
        <Routes>
            <Route exact path='/' element={<Home />}></Route>
            <Route exact path='/detail/:id' element={<Detail />}></Route>
            <Route exact path='/login' element={<Login />}></Route>
            <Route exact path='/signup' element={<Signup />}></Route>
        </Routes>
    </BrowserRouter>
  )
}

export default Router