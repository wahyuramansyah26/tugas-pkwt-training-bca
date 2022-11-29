import React from 'react'
import './slidercards.scss'

function slidercards(props) {
    return (
        <div className="slider-card">
            <div className="card text-white">
                <img className="card-img-top" src={props.image} alt="" />
                    <div className="card-img-overlay flex-end h-100 d-flex flex-column justify-content-end">
                        <h5 className="card-title">{props.title}</h5>
                        <p className="card-text">{props.author}</p>
                    </div>
            </div>
        </div>
    )
}

export default slidercards