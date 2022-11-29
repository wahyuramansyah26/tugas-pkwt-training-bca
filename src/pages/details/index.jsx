import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import dilanCover from '../../assets/covernya.svg'
import seniCover from '../../assets/977994_346fec47-0d83-4c64-ac50-b3e121e797d0_700_700.svg'
import reactCover from '../../assets/3992f708-3a68-412d-b583-e19d6a02df80.svg'
import dilanCover2 from '../../assets/cover-dilan.svg'
import dilanBook from '../../assets/book-dilan.svg'
import arrow from '../../assets/Arrow.svg'
import PopupEdit from '../../components/PopUpEdit/popupedit'
import PopupDelete from '../../components/PopUpDelete/popupdelete'
import './style.css'
import { Link } from 'react-router-dom'

const books = [
  {
    'id': '0',
    'title': 'Dilan 1990',
    'typebook': 'Novel',
    'image': dilanCover,
    'image2': dilanCover2,
    'image3': dilanBook,
    'author': 'Pidi Baiq',
    'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ac diam eget est rutrum ultrices. Donec laoreet enim a massa dapibus, cursus egestas dui pulvinar. Proin sit amet accumsan lectus. Nullam auctor auctor consequat. Donec semper magna erat, sed fringilla lacus pretium eget. Crasporttitor, nibh sit amet interdum bibendum, nibh velit accumsan tellus, vel vehicula tellus leovitae ipsum. Praesent sit amet libero sed orci ullamcorper efficitur. Pellentesque in euismod purus,sit amet ultrices tortor. Vestibulum ante dui, tempor at dui id, tincidunt euismod diam. Integerpellentesque massa nibh, ac eleifend odio malesuada sed. Phasellus orci sem, cursus nec orci ut,accumsan facilisis lacus. Nullam at elementum nibh, ac gravida felis. In sagittis rhoncus nisitempus dignissim. Sed fringilla consequat ante vitae lobortis. Cras posuere ligula vel enim suscipitmalesuada. Vivamus non nulla ut ante imperdiet euismod quis nec massa.'
  },

  {
    'id': '1',
    'title': 'Sebuah Seni Untuk Bersikap Bodo Amat',
    'typebook': 'Encyclopedia',
    'image': seniCover,
    'author': 'Mark Manson',
    'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ac diam eget est rutrum ultrices. Donec laoreet enim a massa dapibus, cursus egestas dui pulvinar. Proin sit amet accumsan lectus. Nullam auctor auctor consequat. Donec semper magna erat, sed fringilla lacus pretium eget. Crasporttitor, nibh sit amet interdum bibendum, nibh velit accumsan tellus, vel vehicula tellus leovitae ipsum. Praesent sit amet libero sed orci ullamcorper efficitur. Pellentesque in euismod purus,sit amet ultrices tortor. Vestibulum ante dui, tempor at dui id, tincidunt euismod diam. Integerpellentesque massa nibh, ac eleifend odio malesuada sed. Phasellus orci sem, cursus nec orci ut,accumsan facilisis lacus. Nullam at elementum nibh, ac gravida felis. In sagittis rhoncus nisitempus dignissim. Sed fringilla consequat ante vitae lobortis. Cras posuere ligula vel enim suscipitmalesuada. Vivamus non nulla ut ante imperdiet euismod quis nec massa.'
  },

  {
    'id': '2',
    'title': 'React Native',
    'typebook': 'Textbook',
    'image': reactCover,
    'author': 'Emilio Rodriguez Martinez',
    'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ac diam eget est rutrum ultrices. Donec laoreet enim a massa dapibus, cursus egestas dui pulvinar. Proin sit amet accumsan lectus. Nullam auctor auctor consequat. Donec semper magna erat, sed fringilla lacus pretium eget. Crasporttitor, nibh sit amet interdum bibendum, nibh velit accumsan tellus, vel vehicula tellus leovitae ipsum. Praesent sit amet libero sed orci ullamcorper efficitur. Pellentesque in euismod purus,sit amet ultrices tortor. Vestibulum ante dui, tempor at dui id, tincidunt euismod diam. Integerpellentesque massa nibh, ac eleifend odio malesuada sed. Phasellus orci sem, cursus nec orci ut,accumsan facilisis lacus. Nullam at elementum nibh, ac gravida felis. In sagittis rhoncus nisitempus dignissim. Sed fringilla consequat ante vitae lobortis. Cras posuere ligula vel enim suscipitmalesuada. Vivamus non nulla ut ante imperdiet euismod quis nec massa.'
  }
]

function Details() {
  const { id } = useParams()
  const [book, setBook] = useState([])

  useEffect(() => {
    setBook(books.find(x => x.id === id))

  }, [])

  const [buttonPopup, setButtonPopup] = useState(false)
  const [buttonPopup2, setButtonPopup2] = useState(false)

  return (
      <main className='d-flex flex-column'>
        <div className='header' >
          <div className="cover">
            <img src={book.image2} alt="" />
          </div>
          <div className="top">
            <div className="back">
              <Link to={'/'}>
                <img src={arrow} alt="arrow" />
              </Link>
            </div>
            <div className="right-header">
              <Link onClick={() => setButtonPopup(true)} className="edit-delete">Edit</Link>
              <Link onClick={() => setButtonPopup2(true)} className="edit-delete">Delete</Link>
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
                  <p>{book.typebook}</p>
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

        <PopupEdit trigger={buttonPopup} setTrigger={setButtonPopup} book={book}>

        </PopupEdit>

        <PopupDelete trigger={buttonPopup2} setTrigger={setButtonPopup2} book={book}>

        </PopupDelete>
      </main>
  )
}

export default Details