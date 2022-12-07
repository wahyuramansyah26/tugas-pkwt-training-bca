import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import PopupEdit from '../../components/PopUpEdit/popupedit'
import PopupDelete from '../../components/PopUpDelete/popupdelete'
import './style.css'
import { Link } from 'react-router-dom'
import axios from 'axios'


function Details() {
  const { id } = useParams()
  const [book, setBook] = useState([])
  const [data, setData] = useState([])

  const getBook = async () => {
    try {
      const { data } = await axios.get(`http://localhost:5000/books/${id}`)
      setBook(data)
      setData(data)
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    getBook()
  }, [])

  const [buttonPopup, setButtonPopup] = useState(false)
  const [buttonPopup2, setButtonPopup2] = useState(false)

  const handleDelete = () => {
    if (window.confirm("Delete Book ?") == true) {
      axios.delete(`http://localhost:5000/books/${id}`)
      setButtonPopup2(true)
    } else {
      setButtonPopup2(false)
    }  
  }

  return (
    <main className='d-flex flex-column'>
      <div className='header' >
        <div className="cover">
          <img src={book.image} alt="" />
        </div>
        <div className="top">
          <div className="back">
            <Link to={'/'}>
              <img src="/assets/Arrow.svg" alt="arrow" />
            </Link>
          </div>
          <div className="right-header">
            <Link onClick={() => setButtonPopup(true)} className="edit-delete">Edit</Link>
            <Link onClick={handleDelete} className="edit-delete">Delete</Link>
          </div>
        </div>
        <div className="book">
          <img src={book.image3} alt="" />
        </div>
      </div>

      <div className="article-content">
        <article className="books">
          <div className="aheader">

            <div className="book-info">
              <div className="type-book">
                <p>Novel</p>
              </div>
              <div className="title">
                <h2>{book.title}</h2>
              </div>
              <div className="date">
                <p>19 Juni 2019</p>
              </div>
            </div>

            <h4>Available</h4>

          </div>
          <div className="body-text">
            <p>
              {book.description}
            </p>
          </div>

        </article>

        <div className="btn-book">
          <button className="btn-borrow btn btn-warning text-white">Borrow</button>
        </div>
      </div>

      <PopupEdit trigger={buttonPopup} setTrigger={setButtonPopup} data={data} setData={setData} book={book} setBook={setBook} >

      </PopupEdit>

      <PopupDelete trigger={buttonPopup2} setTrigger={setButtonPopup2} book={book}>

      </PopupDelete>
    </main>
  )
}

export default Details