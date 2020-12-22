import React, { Component } from "react";
import { Link } from "react-router-dom";

export default class sveikinimoKortele extends Component {
  render() {
    return (
      <div className="col-4 my-3 d-flex justify-content-center">
        <div className="card" style={{ width: "18rem" }}>
          <img className="img-thumbnail" src={} alt="error loading photo" />
          <div className="card-body text-center">
            <h4 className="card-title">
              {this.props.sveikinimas.pilnasVardas}
            </h4>
            <p className="card-text">{this.props.sveikinimas.tekstas}</p>
            <p className="card-text">
              {this.props.sveikinimas.sveikinimoVieta}
            </p>
            <Link
              to={"/about/" + this.props.sveikinimas.id}
              className="btn btn-primary"
            >
              About Product
            </Link>
          </div>
        </div>
      </div>
    );
  }
}
