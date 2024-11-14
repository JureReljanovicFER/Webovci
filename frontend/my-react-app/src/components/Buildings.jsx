import { useState, useEffect } from "react";
import BuildingsChoice from "./BuildingsChoice";
import { useLocation } from "react-router-dom";
const Buildings = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [testData,setTestData] = useState([]);
    const location = useLocation();
    const id=location.pathname.replace(/^\/|\/buildings$/g, '')

 
    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch("http://localhost:8000/ApartmentBuildings");
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


    useEffect(() => {
      const fetchDataTest = async () => {
          try {
              const res = await fetch("https://webovci.onrender.com/api/apartment-buildings/"+id);

              const testata = await res.json();
              setTestData(testdata);
          } catch (error) {
              console.log("Error fetching data:", error);
          } finally {
              setLoading(false);
          }
      };
      fetchDataTest();
  }, []);
  
   console.log(testData)




    if (loading) return <p>Loading...</p>;

    return (
        <>
            <BuildingsChoice data={data}/>
        </>
    );
};

export default Buildings;
