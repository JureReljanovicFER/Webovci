import React from "react";
import { useLocation } from "react-router-dom";
import { useEffect, useRef, useState } from "react";
import Header from "./Header";
import "./styles/Building.css";
const Building = () => {
    const location = useLocation();
    const { data } = location.state || {};

    const [pokaziDrugi, setpokaziDrugi] = useState(false);
    const toggleDrugi = () => {
        setpokaziDrugi(!pokaziDrugi);
    };

    const [data1, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("http://localhost:8000/Popisclanova");
                const data = await res.json();
                setData(data);
            } catch (error) {
                console.log("Error fetching data:", error);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, []);

    const [addNewMember, setAddNewMember] = useState(false);
    const toggleAddNewMember = () => {
        setAddNewMember((prev) => !prev);
    };

    const targetDivRef = useRef(null);

    useEffect(() => {
        if (addNewMember && targetDivRef.current) {
            targetDivRef.current.scrollIntoView({ behavior: "smooth" });
            setTimeout(() => {
                window.scrollBy({ top: -300, behavior: "smooth" });
            }, 0);
        }
    }, [addNewMember]);

    const [email, setEmail] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert("Please enter a valid email address.");
            return;
        }
        toggleAddNewMember();

        const NewMember = {
            user: email,
            apartmentBuilding: parseInt(data.id),
            isRepresentative: true,
        };
        console.log(NewMember);
        try {
            const response = await fetch('https://webovci.onrender.com/api/user/addUserBuilding"', {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(NewMember),
            });
            setEmail("");
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const result = await response.json();
        } catch (error) {
            console.error("Error:", error);
        }
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
                    <div className="members_list_p">
                        {data1.map((item, index) => (
                            <p key={index}>
                                {JSON.stringify(item.ime)} {JSON.stringify(item.prezime)}
                            </p>
                        ))}
                    </div>
                    <button className="add_member_btn" onClick={toggleAddNewMember}>
                        dodaj_člana
                    </button>
                </div>
            </div>
            {addNewMember && (
                <div className="addNewMember" ref={targetDivRef}>
                    <h2>Dodavanje novog člana</h2>
                    <hr></hr>
                    <form onSubmit={handleSubmit}>
                        <div className="formaAddNew">
                            <label>
                                Mail novog korisnika:
                                <input type="text" value={email} onChange={(e) => setEmail(e.target.value)}></input>
                            </label>
                            <br />
                            <button type="submit">Submit</button>
                        </div>
                    </form>
                    <buton className="closeNewMember" onClick={toggleAddNewMember}>
                        X
                    </buton>
                </div>
            )}
        </>
    );
};

export default Building;
