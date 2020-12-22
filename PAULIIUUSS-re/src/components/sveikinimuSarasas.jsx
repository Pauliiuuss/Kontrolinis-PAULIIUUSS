import React, { Component } from "react";
import Sveikinimas from "../components/sveikinimoKortele";
import Axios from "axios";

export default class sveikinimuSarasas extends Component {
  constructor(props) {
    super();
    this.state = {
      sveikinimai: [],
    };
  }

  componentDidMount() {
    Axios.get("http://localhost:8081/sveikinimas")
      .then((response) => {
        this.setState({ sveikinimai: response.data });
      })
      .catch((err) => {
        console.log(err);
      });
  }

  render() {
    const { sveikinimai } = this.state;
    if (sveikinimai.length > 0) {
      return (
        <div className="container">
          <div className="row">
            {sveikinimai.map((sv) => {
              return <Sveikinimas key={sv.id} product={sv} />;
            })}
          </div>
        </div>
      );
    } else {
      return <div>Loading...</div>;
    }
  }
}
