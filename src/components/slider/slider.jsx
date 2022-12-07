/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState, useEffect } from 'react'
import axios from 'axios'
import OwlCarousel from 'react-owl-carousel'
import 'owl.carousel/dist/assets/owl.carousel.css';
import 'owl.carousel/dist/assets/owl.theme.default.css';
import SliderCards from '../../components/slidercards/slidercards'

import './slider.scss'




function slider(props) {
    const [favBook, setFavBook] = useState([])

    const getFavBook = async () => {
        try {
            const { data } = await axios.get('http://localhost:5000/favorite-book')
            console.log(data)
            setFavBook(data)
        } catch (error) {
            console.log(error)
        }
    }

    useEffect(() => {
        getFavBook()
    }, [])
    const options = {
        loop: true,
        margin: 10,
        nav: true,
        autoplay: true,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
        center: true,
        navText: [
            "<",
            ">"
        ],
        responsive: {
            0: {
                items: 1
            },
            600: {
                items: 1
            },
            1000: {
                items: 3
            }
        }
    }

    return (
        <div className="container-slider">
            <div className="slider">
                <OwlCarousel {...options}>
                    {favBook.map((v) => {
                        return <SliderCards title={v.title} image={v.image} author={v.author} />
                    })}
                </OwlCarousel>
            </div>
        </div>
    )
}

export default slider