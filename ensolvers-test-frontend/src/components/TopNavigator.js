import React, { Component } from "react";
import {Route, NavLink, HashRouter, Routes} from "react-router-dom";
import Activities from "./Activities";
import Persons from "./Persons";
import Folders from "./Folders";
import "../styles/topNavigator.css";
import Home from "./Home";

class TopNavigator extends Component {
  	render() {
    	return (
			<HashRouter>
				<div id="navComp">
					<a class="active" href="#home"><NavLink to="/home">Home</NavLink></a>
					<a href="#activities"><NavLink to="/persons">Persons</NavLink></a>
					<a href="#folders"><NavLink to="/activities">Activities</NavLink></a>
					<a href="#persons"><NavLink to="/folders">Folders</NavLink></a>
				</div>
				<div className="content">
				<Routes>
					<Route path="/home" element={<Home/>}/>
					<Route path="/persons" element={<Persons/>}/>
					<Route path="/activities" element={<Activities/>}/>
					<Route path="/folders" element={<Folders/>}/>
				</Routes>
			</div>
			</HashRouter>
		);
  	}
}
export default TopNavigator;