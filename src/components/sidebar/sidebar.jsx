import React, { useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars, faBook } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'
import { useSelector, useDispatch } from 'react-redux'
import { logout } from '../../store/reducer/users'

import PopupAdd from '../../components/PopUpAdd/popupadd'
import './sidebar.scss'

function Sidebar(props) {
    const toggle = () => props.setTrigger(!props.trigger)


    const dispatch = useDispatch()
    const { isAuth, data } = useSelector((state) => state.users)
    const [buttonPopup, setButtonPopup] = useState(false)

    return (
        <div style={{ width: props.trigger ? "20vw" : "5vw" }} className="sidebar">
            <Link id="menu-button" className="push-menu" role="button">
                <FontAwesomeIcon icon={faBars} onClick={toggle} />
            </Link>

            {isAuth ? (
                <div style={{ display: props.trigger ? "block" : "none" }} className="header">
                    <div className="list-item">
                        <Link href="#">
                            <img className="profile-img" src="assets/foto-profile.svg" alt="profile" />
                            <span className="profile-name">{data.fullname}</span>
                        </Link>
                        <button type="button" className="btn-logout" onClick={() => dispatch(logout())}><img src="/assets/logout.svg" alt="logout" />Logout</button>
                    </div>
                </div>
            ) : (
                <div style={{ display: props.trigger ? "block" : "none" }} className="header">
                    <div className="list-item">
                        <Link to={"/login"}>
                            <button type="button" className="btn-login"><img src="/assets/login.svg" alt="logout" />  Login</button>
                        </Link>
                        
                    </div>
                </div>
            )}


            <div style={{ display: props.trigger ? "block" : "none" }} className="main">
                <div className="list-item">
                    <a href="#">
                        <span className="description">Explore</span>
                    </a>
                </div>
                <div className="list-item">
                    <a href="#">
                        <span className="description">History</span>
                    </a>
                </div>
                <div className="list-item">
                    {isAuth && data.role === "admin"? (
                        <Link onClick={() => setButtonPopup(true)}>
                            <span className="description">Add Book*</span>
                        </Link>
                    ) : null}

                </div>
            </div>

            <PopupAdd trigger={buttonPopup} setTrigger={setButtonPopup} books={props.books} setBooks={props.setBooks}>

            </PopupAdd>
        </div>
    )
}



export default Sidebar