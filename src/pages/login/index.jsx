import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { login } from '../../store/reducer/users'
import './style.css'

function Login() {

    const [formData, setFormData] = useState({
        email: "",
        password: ""
    })

    const [errMsg, setErrMsg] = useState("")

    const dispatch = useDispatch()
    const navigate = useNavigate()

    const { isAuth } = useSelector((state) => state.users)
    useEffect(() => {
        if (isAuth) {
            navigate('/')
        }
    }, [isAuth])

    const handleSubmit = async (e) => {
        e.preventDefault()
        await axios.request({
            method: "POST",
            url: "http://localhost:5000/login",
            data: formData
        })
            .then((res) => {
                dispatch(login(res.data))
            })
            .catch((err) => setErrMsg(err.response.data))
    }

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value })
    }

    return (
        <main className='container'>
            <section className="row login">
                <div className="col-md-5 left">
                    <img src="/assets/mollie-sivaram-_1gBVgy8gIU-unsplash.jpg" alt="background" />
                    <h3 className="txt-left">
                        Book is a window<br />
                        to the world
                    </h3>

                    <p className="fotoBy">Photo by Mark Pan4ratte on Unsplash</p>
                </div>

                <div className="col-md-4 right">
                    <div className="header-right">
                        <img src="/assets/bookshelf.svg" alt="bookshelf.svg" />
                    </div>

                    <div className="section-login">
                        <div className="txtlogin">
                            <h3>Login</h3>
                            <p>Welcome back, Please login <br />to your account</p>
                        </div>

                        <div className="login-fail">
                            <p>{errMsg}</p>
                        </div>

                        <div className="form">
                            <form onSubmit={e => handleSubmit(e)} action="#" method="post">
                                <div className="form-box">

                                    <div className="form-group">
                                        <label for="email">Email Address</label>
                                        <input name="email" type="text" className="form-control" id="email" value={formData.email} onChange={handleChange} />
                                    </div>
                                    <div className="form-group mb-3">
                                        <label for="password">Password</label>
                                        <input name="password" type="password" className="form-control" id="password" value={formData.password} onChange={handleChange} />

                                    </div>
                                </div>


                                <div className="remember">
                                    <div className="checkbox">
                                        <input type="checkbox" />
                                        <label className="control control--checkbox mb-0">
                                            <span className="caption">Remember me</span>
                                        </label>
                                    </div>

                                    <span className="ml-auto"><a href="#" className="forgot-pass">Forgot Password</a></span>
                                </div>

                                <div className="btn-lgn-rgst">
                                    <button type='submit' className="btn btn-block btn-dark"> Login</button>
                                    <Link to={'/signup'} className="btn btn-block btn-light btn-outline-secondary">
                                        Sign Up
                                    </Link>
                                </div>

                            </form>
                        </div>

                    </div>


                    <div class="footer">
                        <p>By signing up, you agree to Book's <br /><span>Terms and Conditions <span>& </span> Privacy Policy</span>
                        </p>
                    </div>
                </div>
            </section>
        </main>
    )
}

export default Login