import React from 'react'
import { useLocation } from 'react-router-dom';
import Header from './Header'
import './Building.css'
const Building = () => {
  const location = useLocation();
  const { data } = location.state || {};
  return (
    <>
    <Header />
    <div className='middle'>
      <div className='building_description'>
        <p>Opis zgrade</p>
        <hr></hr>
        <p>{data.adress}</p>
        <p>{data.city} , {data.zipCode}</p>
        <p>ukupno članova</p>
        <button>Pokaži više</button>
      </div>
      <div className='diskusije'>NALAZIS SE U DISKUSIJ ZGRADE {data.id}</div>
      <div className='members:list'></div>
    </div>
    </>
  )
}

export default Building