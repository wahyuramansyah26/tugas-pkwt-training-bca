/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars, faBook } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'
import profile from '../../assets/foto-profile.svg'
import logout from '../../assets/logout.svg'
import PopupAdd from '../../components/PopUpAdd/popupadd'
import './sidebar.scss'

function sidebar() {
    const [isOpen, setIsOpen] = useState(true);
    const toggle = () => setIsOpen(!isOpen)

    const [buttonPopup, setButtonPopup] = useState(false)

    return (
        <div style={{width: isOpen ? "20vw" : "5vw"}} className="sidebar">
            <a id="menu-button" className="push-menu" role="button">
                <FontAwesomeIcon icon={faBars} onClick={toggle} />
            </a>
            <div style={{display: isOpen ? "block" : "none"}} className="header">
                <div className="list-item">
                    <a href="#">
                        <img className="profile-img" src={profile} alt="profile" />
                        <span className="profile-name">Niki Zefanya</span>
                    </a>
                    <Link to={'/login'}>
                        <button type="button" className="logout"><img src={logout} alt="logout" />Logout</button>
                    </Link>
                </div>
            </div>

            <div style={{display: isOpen ? "block" : "none"}} className="main">
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
                    <Link onClick={() => setButtonPopup(true)}>
                        <span className="description">Add Book*</span>
                    </Link>
                </div>
            </div>

            <PopupAdd trigger={buttonPopup} setTrigger={setButtonPopup}>

            </PopupAdd>
        </div>
    )
}



export default sidebar