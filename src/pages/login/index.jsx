import React from 'react'
import { Link } from 'react-router-dom'
import './style.css'
import Bookshelf from '../../assets/bookshelf.svg'
import HeroImage from '../../assets/mollie-sivaram-_1gBVgy8gIU-unsplash.jpg'

function Login() {
    
    return (
        <main className='container'>
            <section className="row login">
                <div className="col-md left">
                    <img src={HeroImage} alt="background"  />
                    <h3 className="txt-left">
                        Book is a window<br />
                            to the world
                    </h3>

                    <p className="fotoBy">Photo by Mark Pan4ratte on Unsplash</p>
                </div>

                <div className="col-md-5 right">
                    <div className="header">
                        <img src={ Bookshelf } alt="bookshelf.svg"/>
                    </div>

                    <div className="section-login">
                        <div className="txtlogin">
                            <h3>Login</h3>
                            <p>Welcome back, Please login <br />to your account</p>
                        </div>

                        <div className="form">
                            <form action="#" method="post">
                                <div className="form-box">

                                    <div className="form-group">
                                        <label for="email">Email Address</label>
                                        <input type="text" className="form-control" id="email" />
                                    </div>
                                    <div className="form-group mb-3">
                                        <label for="password">Password</label>
                                        <input type="password" className="form-control" id="password" />

                                    </div>
                                </div>


                                <div className="remember">
                                    <div className="checkbox">
                                        <input type="checkbox"/>
                                        <label className="control control--checkbox mb-0">
                                             <span className="caption">Remember me</span>
                                        </label>
                                    </div>

                                    <span className="ml-auto"><a href="#" className="forgot-pass">Forgot Password</a></span>
                                </div>

                                <div className="btn-lgn-rgst">
                                    <Link to={'/'} className="btn btn-block btn-dark"> Login</Link>
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