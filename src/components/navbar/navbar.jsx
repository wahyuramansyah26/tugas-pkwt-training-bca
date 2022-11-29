import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'
import './navbar.scss'
import bookshelf from '../../assets/bookshelf.svg'
import { Link } from 'react-router-dom'
import Dropdown from 'react-bootstrap/Dropdown';

function navbar() {
    return (
        <header>
            <div className="menu">
                <Dropdown>
                    <Dropdown.Toggle variant="none" id="dropdown-basic">
                        All Categories
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item >Categories 1</Dropdown.Item>
                        <Dropdown.Item >Categories 2</Dropdown.Item>
                        <Dropdown.Item >Categories 3</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>

                <Dropdown>
                    <Dropdown.Toggle variant="none" id="dropdown-basic">
                        All Time
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item >Time 1</Dropdown.Item>
                        <Dropdown.Item >Time 2</Dropdown.Item>
                        <Dropdown.Item >Time 3</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </div>

            <div className="search-bar">
                <form className="form-search">
                    <div className="form-group">
                        <span><FontAwesomeIcon icon={faMagnifyingGlass} /></span>
                        <input type="search" className="form-control" placeholder="Search Book" />
                    </div>
                </form>
            </div>
            <a href="index.html" className="logo">
                <img src={bookshelf} alt="bookshelf.svg" />
                <span className="brand-text">Library</span>
            </a>
        </header>
    )
}

export default navbar