//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [autod, setAutod] = useState([]);
  const markRef = useRef();
  const pikkusRef = useRef();
  const massRef = useRef();
  const aastaRef = useRef();
  const [autokomponendid, setAutokomponendid] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/autokomponendid")
      .then(response => response.json())
      .then(json => {
        setAutokomponendid(json);
      })
  }, []);

  // Reacti hookid: use eesliidesega, neid peab importima. Reacti erikood
  // Springis annotatsioonid: @RestController, @GetMapping. neid peab importima. Springi erikood.

  // uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/api/autod")
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
        setKogus(json.length);
        setAutod(json);
      }) // body
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/api/autod/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        // console.log(json);
        if (json.error) {
          alert("Auto on autokomponendis kasutusel!"); // toastify
          return;
        }
        setKogus(json.length);
        setAutod(json);
      })
  }

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (markRef.current.value.trim() === "") {
      return;
    }
    const auto = {
      "mark": markRef.current.value,
      "pikkus": pikkusRef.current.value,
      "mass": massRef.current.value,
      "aasta": aastaRef.current.value
    }
    fetch("http://localhost:8080/api/autod", 
    {
      "method": "POST", 
      "body": JSON.stringify(auto), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setAutod(json);
      })
  }

  // function lisa2() {
  //   if (nimiRef.current.value.trim() === "") {
  //     return;
  //   }
  //   fetch("http://localhost:8080/api/toiduained/" 
  //         + nimiRef.current.value + "/"
  //         + valkRef.current.value + "/"
  //         + rasvRef.current.value + "/"
  //         + sysivesikRef.current.value, 
  //   {
  //     "method": "POST"
  //   })
  //     .then(response => response.json()) 
  //     .then(json => {
  //       setKogus(json.length);
  //       setToiduained(json);
  //     })
  // }

  function kustutaTK(primaarivoti) {
    fetch("http://localhost:8080/autod/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        if (json.error) {
          alert("Toidukomponent on toidus kasutusel!"); // toastify
          return;
        }
        setAutokomponendid(json);
      })
  }

  const taNimiRef = useRef(); // inputi luger, mis loeb HTMLst mida kirjutati
  const kogusRef = useRef();

  function lisaTK() {
    const lisatavTK = {
      "auto": {"nimetus": taNimiRef.current.value},
      "kogus": kogusRef.current.value
    }
    fetch("http://localhost:8080/autokomponendid", 
    {
      "method": "POST", 
      "body": JSON.stringify(lisatavTK),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        // setToidukomponendid(json);
        // window.location.reload();
        fetch("http://localhost:8080/autokomponendid")
        .then(response => response.json())
        .then(json => {
          setAutokomponendid(json);
        })
      })
  }

  return (
    <div className="App">
      <div>
        Mul on {kogus} autot
        <br /><br />
        
        <label>Auto mark ja number</label> <br/>
        <input ref={markRef} type="text" /> <br />
        <label>Auto pikkus sentimeetrites</label> <br/>
        <input ref={pikkusRef} type="text" /> <br />
        <label>Auto mass kilogrammides</label> <br/>
        <input ref={massRef} type="text" /> <br />
        <label>Auto aasta</label> <br/>
        <input ref={aastaRef} type="text" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br />

        {autod.map(t => <div>{t.mark} | {t.pikkus} | {t.mass} | {t.aasta} <button onClick={() => kustuta(t.mark)}>x</button> </div> )}
      </div>
      <hr />
      <label>Auto mark (Täpne mark andmebaasist)</label> <br/>
      <input ref={taNimiRef} type="text" /> <br />
      <label>Kogus</label> <br/>
      <input ref={kogusRef} type="text" /> <br />
      <button onClick={() => lisaTK()}>Sisesta</button> <br />

      {autokomponendid.map(tk => <div>{tk.id} | {tk.auto?.mark} | {tk.auto?.pikus} | {tk.kogus} | <button onClick={() => kustutaTK(tk.id)}>x</button> </div> )}

    </div>
  );
}

export default App;
