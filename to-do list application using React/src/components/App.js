import logo from './logo.svg';
import './App.css';

import React from "react";
import ReactDOM from "react-dom";
//component file
import TodoContainer from "./components/CovidContainer";
ReactDOM.render(<TodoContainer />, document.getElementById("root"));



function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to HEELOOO.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
         HELLLLLLLO!
         </a>
      </header>
    </div>
  );
}

export default App;
