// import React from "react";
import { useLocation, useParams } from "react-router-dom";
import { useEffect, useRef, useState } from "react";
// import Header from "./Header";
import "./styles/Building.css";
import { Link } from "react-router-dom";
import { FaPlus } from "react-icons/fa";
const Building = () => {
    const location = useLocation();
    const { data } = location.state || {};
    const params = useParams();

    const [pokaziDrugi, setpokaziDrugi] = useState(false);
    const toggleDrugi = () => {
        setpokaziDrugi(!pokaziDrugi);
    };

    const [data1, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    const [dataDisk, setDataDisk] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("https://webovci.onrender.com/api/apartment-buildings/" + params.buildingId);
                const data = await res.json();
                setDataDisk(data);
            } catch (error) {
                console.log("Error fetching data:", error);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, []);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("https://webovci.onrender.com/api/apartment-buildings/getTenants/" + params.buildingId);
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

    const [dodavanjeDiskusije, setDodavanjeDiskusije] = useState(false);
    const toggleDodavanjeDiskusije = () => {
        setDodavanjeDiskusije((prev) => !prev);
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
            // const result = await response.json();
        } catch (error) {
            console.error("Error:", error);
        }
    };
    const [ImeDiskusije, setImeDiskusije] = useState("");
    const handleDiskusije = async (event) => {
        event.preventDefault();
        toggleDodavanjeDiskusije();
    };

    return (
        <>
            <div className="middle">
                <div className="building_description">
                    <p>Opis zgrade</p>
                    <hr></hr>
                    <p>{data.address}</p>
                    <div className={`additional-paragraphs ${pokaziDrugi ? "show" : ""}`}>
                        <p>
                            {data.city} , {data.zipCode}
                        </p>
                        <p>ukupan broj članova</p>
                    </div>
                    <button onClick={toggleDrugi}>{pokaziDrugi ? "Sakrij" : "Pokaži više"}</button>
                </div>
                <div className="dodavanje_diskusije" onClick={toggleDodavanjeDiskusije}>
                    <p>Dodajte diskusiju</p>
                    <hr></hr>
                    <FaPlus size={100} opacity={0.7} />
                </div>
                <div className="diskusije">
                    <p>NALAZIS SE U DISKUSIJ ZGRADE {data.id}</p>
                    <hr></hr>
                    <div className="sve_diskusije">
                        {dataDisk.map((item, index) => (
                            <Link
                                key={index}
                                className="odabirDiskusijeLinkk"
                                to={`${location.pathname}/discussions/${item.id}`}
                                state={{ data: item }}
                            >
                                <div className="diskusija" key={index}>
                                    <h1 key={index}>{JSON.stringify(item.title)} </h1>
                                    <p key={index}> {JSON.stringify(item.description)}</p>
                                </div>
                            </Link>
                        ))}
                    </div>
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
            {dodavanjeDiskusije && (
                <div className="addNewMember" ref={targetDivRef}>
                    <h2>dodavanje diskusije</h2>
                    <hr></hr>
                    <form onSubmit={handleDiskusije}>
                        <div className="formaAddNew">
                            <label>
                                ime nove diskusije:
                                <input type="text" value={ImeDiskusije} onChange={(e) => setImeDiskusije(e.target.value)}></input>
                            </label>
                            <br />
                            <button type="submit">Submit</button>
                        </div>
                    </form>
                    <buton className="closeNewMember" onClick={toggleDodavanjeDiskusije}>
                        X
                    </buton>
                </div>
            )}
        </>
    );
};

export default Building;
