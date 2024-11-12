import React from "react";
import { useLocation } from "react-router-dom";
import { useState } from "react";
import Header from "./Header";
import "./Building.css";
const Building = () => {
    const location = useLocation();
    const { data } = location.state || {};

    const [pokaziDrugi, setpokaziDrugi] = useState(false);
    const toggleDrugi = () => {
        setpokaziDrugi(!pokaziDrugi);
    };
    return (
        <>
            <div className="middle">
                <div className="building_description">
                    <p>Opis zgrade</p>
                    <hr></hr>
                    <p>{data.adress}</p>
                    <div className={`additional-paragraphs ${pokaziDrugi ? "show" : ""}`}>
                        <p>
                            {data.city} , {data.zipCode}
                        </p>
                        <p>ukupan broj članova</p>
                    </div>
                    <button onClick={toggleDrugi}>{pokaziDrugi ? "Sakrij" : "Pokaži više"}</button>
                </div>
                <div className="diskusije">
                    <p>NALAZIS SE U DISKUSIJ ZGRADE {data.id}</p>
                    <hr></hr>
                </div>
                <div className="members_list">
                    <p>popis članova zgrade</p>
                    <hr></hr>
                </div>
            </div>
        </>
    );
};

export default Building;
