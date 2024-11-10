import React from 'react'
import { Link } from 'react-router-dom';
import "./BuildingsChoice.css"
import { BsFillBuildingsFill } from "react-icons/bs";
import { FaPlus } from "react-icons/fa";
const BuildingsChoice = ({data}) => {

    const saljem={ime:"ime"}
  return (
    <div className="odabirZgrade">
          {data.map((item, index) => (
            <Link
            key={index}
            className="odabirZgradeLink"
            to={`/buildings/${item.id}`}
            state={{ data: item }} 
          >
            <div className="zgrada" key={index}>
              <h1>{JSON.stringify(item.adress)}</h1>
              <BsFillBuildingsFill    size={200} opacity={0.5}/>
            </div>
            </Link>
          ))}
        <a className='odabirZgradeLink'>
        <div className="zgrada">
          <p>dodaj zgradu</p>
          <hr className='linijaDodat'></hr>
          <FaPlus size={200} opacity={0.7}/>
        </div>
        </a>
      </div>
  )
}

export default BuildingsChoice