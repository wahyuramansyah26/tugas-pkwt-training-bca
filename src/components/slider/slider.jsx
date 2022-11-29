import React from 'react'
import OwlCarousel from 'react-owl-carousel'
import 'owl.carousel/dist/assets/owl.carousel.css';
import 'owl.carousel/dist/assets/owl.theme.default.css';
import SliderCards from '../../components/slidercards/slidercards'
import dilanCover from '../../assets/covernya.svg'
import reactCover from '../../assets/3992f708-3a68-412d-b583-e19d6a02df80.svg'
import uburCover from '../../assets/d96eff85-ae75-4f56-bdfc-dd7a055e7400.svg'
import laskarCover from '../../assets/laskar-300x220.svg'
import './slider.scss'


const sliderbooks = [
    {
        'id' : '0',
        'title': 'Dilan 1990',
        'image': dilanCover,
        'author': 'Pidi Baiq',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    },

    {
        'id': '2',
        'title': 'React Native',
        'image': reactCover,
        'author': 'Emilio Rodriguez Martinez',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    },

    {
        'id' : '3',
        'title': 'Ubur-Ubur Lembur',
        'image': uburCover,
        'author': 'Raditya Dika',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    },

    {
        "id" : "4",
        'title': 'Laskar Pelangi',
        'image': laskarCover,
        'author': 'Andrea Hirata',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    }
]

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

function slider() {
    return (
        <div className="container-slider">
            <div className="slider">
                <OwlCarousel {...options}>
                    {sliderbooks.map((v) => {
                        return <SliderCards title={v.title} image={v.image} author={v.author} />
                    })}
                </OwlCarousel>
            </div>
        </div>
    )
}

export default slider