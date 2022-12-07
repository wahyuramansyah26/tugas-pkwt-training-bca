import React from 'react'
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faXmark } from '@fortawesome/free-solid-svg-icons'
import './popupdelete.scss'

function popupdelete(props) {
  return (props.trigger) ? (
    <div class="popup" id="popup2">
        <div className="overlay"></div>
        <div class="popup-content2">
            <div class="popup-header">
                <h5 class="popup-title">         </h5>
                <Link onClick={() => props.setTrigger(false)} to={"/"}><FontAwesomeIcon icon={faXmark} /></Link>
            </div>

            <div class="popup-body">
                <img src="/assets/checked.svg" alt="" />
                <h3>Data <span>{props.book.title}</span> berhasil dihapus!</h3>
            </div>    
        </div>
    </div>
  ) : "";
}

export default popupdelete