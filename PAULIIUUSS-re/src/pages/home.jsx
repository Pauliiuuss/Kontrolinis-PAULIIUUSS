import React, { Component } from "react";
import NavBar from "../components/navBar";
import SveikinimuSarasas from "../components/sveikinimuSarasas";

export default class home extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <NavBar />
          <SveikinimuSarasas />
        </div>
      </div>
    );
  }
}
