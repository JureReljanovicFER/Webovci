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

  const [clanovi, setClanovi] = useState([]);
  const [loading, setLoading] = useState(true);

  const [diskusije, setDiskusije] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await fetch(
          "https://webovci.onrender.com/api/apartment-buildings/" +
            params.buildingId
        );
        const data = await res.json();

        const response = await fetch(
          "https://webovci.onrender.com/api/discussions/getAll"
        );
        const discussionsData = await response.json();

        const discussions = discussionsData.filter(
          (discussion) =>
            discussion.apartmentBuildingId == parseInt(params.buildingId)
        );

        const finalDiscussions = [];

        discussions.forEach((discussion) => {
          finalDiscussions.push({ ...discussion, show: true });
          discussion.visibilities.forEach((visibility) => {
            if (visibility.appUser == params.userId) {
              if (visibility.canUserSeeDiscussion == true) {
                finalDiscussions.push({ ...discussion, show: true });
              } else {
                finalDiscussions.push({ ...discussion, show: false });
              }
            }
          });
        });

        console.log(finalDiscussions);

        setDiskusije(finalDiscussions);
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
        const res = await fetch(
          "https://webovci.onrender.com/api/apartment-buildings/getTenants/" +
            params.buildingId
        );
        const clanovi = await res.json();

        if (clanovi.data) {
          setClanovi(clanovi.data);
        }
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
      const response = await fetch(
        'https://webovci.onrender.com/api/user/addUserBuilding"',
        {
          method: "POST",
          mode: "no-cors",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(NewMember),
        }
      );
      setEmail("");
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleVisibilityChange = (userId) => {
    setVisibilitySettings((prevSettings) => ({
      ...prevSettings,
      [userId]: !prevSettings[userId],
    }));
  };

  const [visibilitySettings, setVisibilitySettings] = useState({});
  const [ImeDiskusije, setImeDiskusije] = useState("");
  const [OpisDiskusije, setOpisDiskusije] = useState("");
  const handleDiskusije = async (event) => {
    event.preventDefault();
    toggleDodavanjeDiskusije();
    const visibilities = Object.keys(visibilitySettings).map((userId) => ({
      userId: parseInt(userId),
      canUserSee: visibilitySettings[userId],
      canUserParticipate: visibilitySettings[userId],
    }));

    const newDiscussion = {
      creatorUserId: params.userid,
      title: ImeDiskusije,
      description: OpisDiskusije,
      apartmentBuildingId: params.buildingId,
      visibilities: visibilities,
    };

    try {
      const response = await fetch(
        "https://webovci.onrender.com/api/discussions/addNew",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(newDiscussion),
        }
      );

      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }

      const result = await response.json();
      console.log("Discussion added successfully:", result);
      await fetchData();
      setDiskusije((prevDiscussions) => [
        ...prevDiscussions,
        { ...newDiscussion, id: result.id, show: true }, 
      ]);
    } catch (error) {
      console.error("Error adding discussion:", error);
    }
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
            <p>ukupan broj članova: {data.numberOfIndividualApartments}</p>
          </div>
          <button onClick={toggleDrugi}>
            {pokaziDrugi ? "Sakrij" : "Pokaži više"}
          </button>
        </div>
        <div className="dodavanje_diskusije" onClick={toggleDodavanjeDiskusije}>
          <p>Dodajte diskusiju</p>
          <hr></hr>
          <FaPlus size={100} opacity={0.7} />
        </div>
        <div className="diskusije">
          <p>NALAZIS SE U DISKUSIJAMA ZGRADE {data.id}</p>
          <hr></hr>
          <div className="sve_diskusije">
            {diskusije.map((discussion) => {
              if (discussion.show) {
                return (
                  <div key={discussion.id} className="diskusija">
                    <Link
                      className="odabirDiskusijeLinkk"
                      to={`${location.pathname}/discussions/${discussion.id}`}
                    >
                      <div className="diskusija">
                        <h3>{discussion.title} </h3>
                        <p> {discussion.description}</p>
                      </div>
                    </Link>
                  </div>
                );
              } else {
                return (
                  <div>
                    <h3>Naslov: Ne možete vidjeti naslov ove diskusije</h3>
                  </div>
                );
              }
            })}
          </div>
        </div>
        <div className="members_list">
          <p>popis članova zgrade</p>
          <hr></hr>
          <div className="members_list_p">
            {clanovi.map((item) => {
              return (
                <p key={item.id}>
                  {item.firstName} {item.lastName} - uloga: {item.userRole}
                </p>
              );
            })}
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
                <input
                  type="text"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                ></input>
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
                <input
                  type="text"
                  value={ImeDiskusije}
                  onChange={(e) => setImeDiskusije(e.target.value)}
                ></input>
              </label>
              <label>
                opis nove diskusije:
                <input
                  type="text"
                  value={OpisDiskusije}
                  onChange={(e) => setOpisDiskusije(e.target.value)}
                ></input>
              </label>
              <br />
              <h3>Odaberi korisnike koji mogu vidjeti diskusiju:</h3>
              <div>
                {clanovi.map((user) => (
                  <div key={user.id}>
                    <input
                      type="checkbox"
                      checked={visibilitySettings[user.id] || false}
                      onChange={() => handleVisibilityChange(user.id)}
                    />
                    {user.firstName} {user.lastName}
                  </div>
                ))}
              </div>

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
