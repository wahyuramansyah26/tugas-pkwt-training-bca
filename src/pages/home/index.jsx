import React from 'react'
import Sidebar from '../../components/sidebar/sidebar'
import Navbar from '../../components/navbar/navbar'
import Cards from '../../components/cards/cards'
import './style.css'
import dilanCover from '../../assets/covernya.svg'
import seniCover from '../../assets/977994_346fec47-0d83-4c64-ac50-b3e121e797d0_700_700.svg'
import reactCover from '../../assets/3992f708-3a68-412d-b583-e19d6a02df80.svg'
import Slider from '../../components/slider/slider'

const books = [
    {
        'id': '0',
        'title': 'Dilan 1990',
        'image': dilanCover,
        'author': 'Pidi Baiq',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    },

    {
        'id': '1',
        'title': 'Sebuah Seni Untuk Bersikap Bodo Amat',
        'image': seniCover,
        'author': 'Mark Manson',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    },

    {
        'id': '2',
        'title': 'React Native',
        'image': reactCover,
        'author': 'Emilio Rodriguez Martinez',
        'description': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis lacus mi, sit amet vehicula nisl consequat id.'
    }
]


function Home() {
    return (
        <div className="contain">
            <Sidebar />
            <div className="main-content">
                <Navbar />
                <Slider />
                <div className="list-book">
                    <h4>List Book</h4>
                    <div className="container-card">
                        {books.map((v) => {
                            return <Cards id = {v.id} title={v.title} image={v.image} description={v.description} />
                        })}

                    </div>
                </div>
            </div>
        </div>

    )
}

export default Home