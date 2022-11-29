import React from 'react'
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faXmark } from '@fortawesome/free-solid-svg-icons'
import './popupadd.scss'

function popupadd(props) {
    return (props.trigger) ? (
        <div className="popup" id="popup">
            <div className="overlay"></div>
            <div className="popup-content">
                <div className="popup-header">
                    <h5 className="popup-title">Add Data</h5>
                    <Link onClick={() => props.setTrigger(false)}><FontAwesomeIcon icon={faXmark}  /></Link>
                </div>

                <form className="form-book">
                    <div className="txt-input">
                        <p>Url Image</p>
                        <input type="text" className="form-control" placeholder="Url Image..." />
                    </div>

                    <div className="txt-input">
                        <p>Title</p>
                        <input type="text" className="form-control" placeholder="Title..." />
                    </div>

                    <div className="txt-input">
                        <p>Description</p>
                        <textarea className="form-control description" placeholder="Description...">
                        </textarea>
                    </div>

                </form>
                <div className="popup-footer">
                    <button type="button" className="btn btn-warning text-white" onClick={() => props.setTrigger(false)}>Save</button>
                </div>
                { props.children }
            </div>
        </div>
    ) : "";
}

export default popupadd