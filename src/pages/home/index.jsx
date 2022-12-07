import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Sidebar from '../../components/sidebar/sidebar'
import Navbar from '../../components/navbar/navbar'
import Cards from '../../components/cards/cards'
import './style.css'
import Slider from '../../components/slider/slider'



function Home() {
    const [books, setBooks] = useState([])
    const getBooks = async () => {
        try {
            const { data } = await axios.get('http://localhost:5000/books')
            setBooks(data)
        } catch (error) {
            console.log(error)
        }
    }


    useEffect(() => {
        getBooks()
    }, [])


    return (
        <div className="contain">
            <Sidebar books={books} setBooks={setBooks}/>
            <div className="main-content">
                <Navbar />
                <Slider />
                <div className="list-book">
                    <h4>List Book</h4>
                    <div className="container-card container">
                        <div className="row">
                            {books.map((v) => {
                                return <Cards id={v.id} title={v.title} image={v.image} description={v.description} />
                            })}
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Home