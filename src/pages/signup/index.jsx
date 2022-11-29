import React from 'react'
import { Link } from 'react-router-dom'
import './style.css'
import Bookshelf from '../../assets/bookshelf.svg'
import HeroImage from '../../assets/mollie-sivaram-_1gBVgy8gIU-unsplash.jpg'

function signup() {
  return (
    <main className='container'>
      <section className="row rgst">
        <div className="col-md left">
          <img src={HeroImage} alt="background" />
          <h3 className="txt-left">
            Book is a window<br />
            to the world
          </h3>

          <p className="fotoBy">Photo by Mark Pan4ratte on Unsplash</p>
        </div>

        <div className="col-md-5 right">
          <div className="header">
            <img src={Bookshelf} alt="bookshelf.svg" />
          </div>

          <div className="section-rgst">
            <div className="txtrgst">
              <h3>Register</h3>
              <p>Welcome Back, Please Register <br />to create account</p>
            </div>

            <div className="form">
              <form action="#" method="post">
                <div className="form-box">
                  <div className="form-group">
                    <label for="email">Username</label>
                    <input type="text" className="form-control" id="email" />
                  </div>

                  <div className="form-group ">
                    <label for="email">Full Name</label>
                    <input type="text" className="form-control" id="email" />
                  </div>

                  <div className="form-group">
                    <label for="email">Email Address</label>
                    <input type="text" className="form-control" id="email" />
                  </div>
                  <div className="form-group mb-3 ">
                    <label for="password">Password</label>
                    <input type="password" className="form-control" id="password" />

                  </div>
                </div>

                <div className="btn-rgst-lgn">
                  <Link to={'/'} className="btn btn-block btn-dark"> Sign Up</Link>
                  <Link to={'/login'} className="btn btn-block btn-light btn-outline-secondary">
                    Login
                  </Link>
                </div>

              </form>
            </div>

          </div>


          <div class="footer">
            <p>By signing up, you agree to Book's <br /><span>Terms and Conditions <span>& </span> Privacy
              Policy</span> </p>
          </div>
        </div>
      </section>

    </main>
  )
}

export default signup