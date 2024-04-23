import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [tooted, setTooted] = useState([]);
  // const nimiRef = useRef();
  // const valkRef = useRef();
  // const rasvRef = useRef();
  // const sysivesikRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/tooted")
      .then(response => response.json())
      .then(body => {
        setTooted(body);
      })
  }, []);

  // function kustuta(primaarivoti) {
  //   fetch("http://localhost:8080/api/toiduained/" + primaarivoti, {"method": "DELETE"})
  //     .then(response => response.json()) 
  //     .then(json => {
  //       setKogus(json.length);
  //       setToiduained(json);
  //     })
  // }

  // function lisa() {
  //   if (nimiRef.current.value.trim() === "") {
  //     return;
  //   }
  //   const toiduaine = {
  //     "nimetus": nimiRef.current.value,
  //     "valk": valkRef.current.value,
  //     "rasv": rasvRef.current.value,
  //     "sysivesik": sysivesikRef.current.value
  //   }
  //   fetch("http://localhost:8080/api/toiduained", 
  //   {
  //     "method": "POST", 
  //     "body": JSON.stringify(toiduaine), 
  //     "headers": {"Content-Type": "application/json"}
  //   })
  //     .then(response => response.json()) 
  //     .then(json => {
  //       setKogus(json.length);
  //       setToiduained(json);
  //     })
  // }


  return (
    <div className="App">
      <div>
        
        {/* <label>Toiduaine nimi</label> <br/>
        <input ref={nimiRef} type="text" /> <br />
        <label>Toiduaine valk</label> <br/>
        <input ref={valkRef} type="text" /> <br />
        <label>Toiduaine rasv</label> <br/>
        <input ref={rasvRef} type="text" /> <br />
        <label>Toiduaine süsivesik</label> <br/>
        <input ref={sysivesikRef} type="text" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br /> */}

        {tooted.map(t => 
          <div>{t.id} | {t.nimi} | {t.hind} | {t.aktiivne + 0} 
            {/* <button onClick={() => kustuta(t.nimetus)}>x</button>  */}
          </div> )}
      </div>
    </div>
  );
}

export default App;