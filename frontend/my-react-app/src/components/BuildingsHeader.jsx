import React from 'react'
const BuildingsHeader = () => {
  const shoot = () => {
    let odabir=window.confirm("Jeste li sigurni da se želite log-outat");
    if(odabir){
      window.location.href=`/login`
    }
    else{}
  }
  
  return (
        
    <div className="header" >
      <h1>StanBlog</h1>
      <button onClick={shoot} className='botun'>
        Odjavi se
      </button>
    </div>
  )
}

export default BuildingsHeader