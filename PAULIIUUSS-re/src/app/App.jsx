import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Home from "../pages/home";

import NotFound from "../pages/notFound";

export default class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path="/PAULIIUUSS">
            <Home />
          </Route>
          <Route path="/pridetiSveikinima"></Route>
          <Route>
            <NotFound />
          </Route>
        </Switch>
      </Router>
    );
  }
}
