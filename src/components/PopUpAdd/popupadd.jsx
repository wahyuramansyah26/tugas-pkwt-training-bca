import React, { useState } from 'react'
import axios from 'axios'
import { uid } from 'uid'
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faXmark } from '@fortawesome/free-solid-svg-icons'
import './popupadd.scss'

function Popupadd(props) {
    const [data, setData] = useState({
        image: "",
        title: "",
        description: ""
    })

    const onChangeInput = (event) => {

        setData({ ...data, [event.target.name]: event.target.value })
    }


    const postData = async (e) => {
        e.preventDefault();
        let bookks = [...props.books]
        let newData = {id: uid(), image: data.image, title: data.title, description: data.description }

        await axios.post("http://localhost:5000/books", newData).then(res => {
            alert("Berhasil menambah buku")
        })
        bookks.push(newData)
        props.setBooks(bookks)
        props.setTrigger(false)
    }

    return (props.trigger) ? (
        <div className="popup" id="popup">
            <div className="overlay"></div>
            <div className="popup-content">
                <div className="popup-header">
                    <h5 className="popup-title">Add Data</h5>
                    <Link onClick={() => props.setTrigger(false)}><FontAwesomeIcon icon={faXmark} /></Link>
                </div>

                <form onSubmit={postData} className="form-book">
                    <div className="txt-input">
                        <p>Url Image</p>
                        <input type="text" onChange={onChangeInput} name="image" className="form-control" placeholder="Url Image..." />
                    </div>

                    <div className="txt-input">
                        <p>Title</p>
                        <input type="text" onChange={onChangeInput} name="title" className="form-control" placeholder="Title..." />
                    </div>

                    <div className="txt-input">
                        <p>Description</p>
                        <textarea className="form-control description" onChange={onChangeInput} name="description" placeholder="Description...">
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

export default Popupadd