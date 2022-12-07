import React from 'react'
import './cards.scss'
import { Link } from 'react-router-dom'

function cards(props) {
    return (
        <div className="col-md">
            <div className="card">
                <img className="card-img-top" src={props.image} alt="" />
                <div className="card-body">
                    <h5 className="card-title">{props.title.substring(0, 17)}</h5>
                    <p className="card-text">{props.description.substring(0, 117)}</p>
                </div>
                <Link to={`/detail/${props.id}`} className="stretched-link"></Link>
            </div>
        </div>


    )
}

export default cards