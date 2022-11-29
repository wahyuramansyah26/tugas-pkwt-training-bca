import React from 'react'
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faXmark } from '@fortawesome/free-solid-svg-icons'
import './popupedit.scss'

function popupedit(props) {
  return (props.trigger) ? (
    <div className="popup" id="popup">
        <div className="overlay"></div>
        <div className="popup-content">
            <div className="popup-header">
                <h5 className="popup-title">Edit Data</h5>
                <Link onClick={() => props.setTrigger(false)}><FontAwesomeIcon icon={faXmark} /></Link>
            </div>

            <form className="form-book">
                <div className="txt-input">
                    <p>Url Image</p>
                    <input type="text" className="form-control" value={`http://gambar.com/${props.book.title}.jpg`} />
                </div>

                <div className="txt-input">
                    <p>Title</p>
                    <input type="text" className="form-control" value={props.book.title} />
                </div>

                <div className="txt-input">
                    <p>Description</p>
                    <textarea className="form-control description" value="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ac diam eget est rutrum ultrices. Donec laoreet enim a massa dapibus, cursus egestas dui pulvinar.">
                    </textarea>
                </div>

            </form>
            <div className="popup-footer">
                <button type="button" className="btn btn-warning text-white" onClick={() => props.setTrigger(false)}>Save</button>
            </div>


        </div>
    </div>
  ) : "";
}

export default popupedit