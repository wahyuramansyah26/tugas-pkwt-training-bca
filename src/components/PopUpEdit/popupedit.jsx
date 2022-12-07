import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faXmark } from '@fortawesome/free-solid-svg-icons'
import './popupedit.scss'


function Popupedit(props) {
    const onChangeInput = (event) => {
        props.setData({ ...props.data, [event.target.name]: event.target.value })
    }

    const editData = async (e) => {
        e.preventDefault();
        await axios.put("http://localhost:5000/books/" + props.data.id, { id: props.data.id, image: props.data.image, title: props.data.title, description: props.data.description }).then(res => {
            alert("Berhasil mengubah data")
        })
        props.setBook({id: props.data.id, image: props.data.image, title: props.data.title, description: props.data.description})
        props.setTrigger(false)
    }

    return (props.trigger) ? (
        <div className="popup" id="popup">
            <div className="overlay"></div>
            <div className="popup-content">
                <div className="popup-header">
                    <h5 className="popup-title">Edit Data</h5>
                    <Link onClick={() => props.setTrigger(false)}><FontAwesomeIcon icon={faXmark} /></Link>
                </div>

                <form onSubmit={editData} className="form-book">
                    <div className="txt-input">
                        <p>Url Image</p>
                        <input type="text" onChange={onChangeInput} name="image" className="form-control" value={props.data.image} />
                    </div>

                    <div className="txt-input">
                        <p>Title</p>
                        <input type="text" onChange={onChangeInput} name="title" className="form-control" value={props.data.title} />
                    </div>

                    <div className="txt-input">
                        <p>Description</p>
                        <textarea onChange={onChangeInput} name="description" className="form-control description" value={props.data.description}>
                        </textarea>
                    </div>

                    <div className="popup-footer">
                        <button type="submit" className="btn btn-warning text-white">Save</button>
                    </div>

                </form>



            </div>
        </div>
    ) : "";
}

export default Popupedit