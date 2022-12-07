import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate} from 'react-router-dom'
import './style.css'

function Signup() {
  const [formData, setFormData] = useState({
    username: "",
    fullname: "",
    email: "",
    password: "",
    role: ""
  })

  const [errMsg, setErrMsg] = useState("")

  const navigate = useNavigate()

  const handleSubmit = async (e) => {
    e.preventDefault()
    await axios.request({
      method: "POST",
      url: "http://localhost:5000/users",
      data: formData
    })
      .then((res) => navigate('/login'))
      .catch((err) => setErrMsg(err.response.data))
  }

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value })
  }

  return (
    <main className='container'>
      <section className="row rgst">
        <div className="col-md-5 left">
          <img src="/assets/mollie-sivaram-_1gBVgy8gIU-unsplash.jpg" alt="background" />
          <h3 className="txt-left">
            Book is a window<br />
            to the world
          </h3>

          <p className="fotoBy">Photo by Mark Pan4ratte on Unsplash</p>
        </div>

        <div className="col-md-4 right-rgst">
          <div className="header-right">
            <img src="/assets/bookshelf.svg" alt="bookshelf.svg" />
          </div>

          <div className="section-rgst">
            <div className="txtrgst">
              <h3>Register</h3>
              <p>Welcome Back, Please Register <br />to create account</p>
            </div>

            <div className="register-fail">
              <p>{errMsg}</p>
            </div>

            <div className="form">
              <form onSubmit={e => handleSubmit(e)} action="#" method="post">
                <div className="form-box">
                  <div className="form-group">
                    <label for="username">Username</label>
                    <input name="username" type="text" className="form-control" id="username" value={formData.username} onChange={e => handleChange(e)} required/>
                  </div>

                  <div className="form-group ">
                    <label for="fullname">Full Name</label>
                    <input name="fullname" type="text" className="form-control" id="fullname" value={formData.fullname} onChange={e => handleChange(e)} required />
                  </div>

                  <div className="form-group">
                    <label for="email">Email Address</label>
                    <input name="email" type="text" className="form-control" id="email" value={formData.email} onChange={e => handleChange(e)} required/>
                  </div>
                  <div className="form-group mb-3 ">
                    <label for="password">Password</label>
                    <input name="password" type="password" className="form-control" id="password" value={formData.password} onChange={e => handleChange(e)} required/>

                  </div>
                </div>

                <div className="btn-rgst-lgn">
                  <button type="submit" className="btn btn-block btn-dark"> Sign Up</button>
                  <Link to={'/login'} className="btn btn-block btn-light btn-outline-secondary">
                    Login
                  </Link>
                </div>

              </form>
            </div>

          </div>


          <div className="footer">
            <p>By signing up, you agree to Book's <br /><span>Terms and Conditions <span>& </span> Privacy
              Policy</span> </p>
          </div>
        </div>
      </section>

    </main>
  )
}

export default Signup