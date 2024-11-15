import React from "react";
import { Link } from "react-router-dom";
import "./styles/BuildingsChoice.css";
import { useState, useEffect, useRef } from "react";
import { BsFillBuildingsFill } from "react-icons/bs";
import { FaPlus } from "react-icons/fa";


const BuildingsChoice = ({ data }) => {


    const [showAddNew, setShowAddNew] = useState(false);
    const targetDivRef = useRef(null);

    const [address, setAddress] = useState("");
    const [zipCode, setZipCode] = useState("");
    const [city, setCity] = useState("");
    const [numberOfIndividualApartments, setNoia] = useState("");

    const [divs, setDivs] = useState([]);
    const handleSubmit = async (event) => {
        event.preventDefault();

        if (address == "" || zipCode == "" || numberOfIndividualApartments == "" || zipCode == "") {
            alert("sva polja trebaju biti puna");
            return;
        }
        if (parseInt(zipCode, 10) < 0) {
            alert("Zip Code mora biti broj veći od 0");
            return;
        }
        if (parseInt(numberOfIndividualApartments, 10) < 0) {
            alert("broj apartmana mora biti broj veći od 0");
            return;
        }
        if (isNaN(parseInt(zipCode, 10)) || isNaN(parseInt(numberOfIndividualApartments, 10))) {
            alert("Zip code i broj apartmana mora biti broj");
            return;
        }

        const data = {
            address,
            zipCode: parseInt(zipCode, 10),
            city,
            numberOfIndividualApartments: parseInt(numberOfIndividualApartments, 10),
        };
        console.log(data)
        try {
            const response = await fetch("https://webovci.onrender.com/api/apartment-buildings/new", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data),
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const result = await response.json();

            const newDiv = (
                <Link key={divs.length} className="odabirZgradeLink" >
                        <div className="zgrada">
                            <h1>{address}</h1>
                            <BsFillBuildingsFill size={200} opacity={0.5} />
                        </div>
                    </Link>
            );
            setDivs([...divs, newDiv]);

            toggleAddNew();
            setAddress("");
            setCity("");
            setNoia("");
            setZipCode("");
        } catch (error) {}
    };

    const toggleAddNew = () => {
        setShowAddNew((prev) => !prev);
    };

    useEffect(() => {
        if (showAddNew && targetDivRef.current) {
            targetDivRef.current.scrollIntoView({ behavior: "smooth" });
            setTimeout(() => {
                window.scrollBy({ top: -300, behavior: "smooth" });
            }, 0);
        }
    }, [showAddNew]);

    return (
        <>
            <div className="odabirZgrade">
                {data.map((item, index) => (
                    <Link key={index} className="odabirZgradeLink" to={`${item.id}`} state={{ data: item }}>
                        <div className="zgrada">
                            <h1>{item.address}</h1>
                            <BsFillBuildingsFill size={200} opacity={0.5} />
                        </div>
                    </Link>
                ))}
                {divs}
                <a className="odabirZgradeLink" onClick={toggleAddNew}>
                    <div className="zgrada">
                        <p>dodaj zgradu</p>
                        <hr className="linijaDodat"></hr>
                        <FaPlus size={200} opacity={0.7} />
                    </div>
                </a>
            </div>
            {showAddNew && (
                <div ref={targetDivRef} className="login-form">
                    <h2>Dodavanje nove zgrade</h2>
                    <hr></hr>
                    <form onSubmit={handleSubmit}>
                        <div className="tekst_login">
                            <label>
                                Adresa:
                                <input type="text" name="addresstxt" value={address} onChange={(e) => setAddress(e.target.value)} />
                            </label>
                            <br />
                            <label>
                                Poštanski broj:
                                <input
                                    type="text"
                                    name="zipCodetxt"
                                    value={zipCode}
                                    onChange={(e) => setZipCode(e.target.value)}
                                />
                            </label>
                            <br />
                            <label>
                                Grad:
                                <input type="text" name="citytxt" value={city} onChange={(e) => setCity(e.target.value)} />
                            </label>
                            <br />
                            <label>
                                Broj stanova u zgradi:
                                <input
                                    className="text"
                                    type="text"
                                    name="numberOfIndividualApartmentstxt"
                                    value={numberOfIndividualApartments}
                                    onChange={(e) => setNoia(e.target.value)}
                                />
                            </label>
                            <br />

                            <button type="submit">Dodaj zgradu</button>
                        </div>
                    </form>
                    <button className="close_login" onClick={toggleAddNew}>
                        X
                    </button>
                </div>
            )}
        </>
    );
};

export default BuildingsChoice;
