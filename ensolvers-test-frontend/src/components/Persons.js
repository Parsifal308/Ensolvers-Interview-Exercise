import React, { Component } from "react";
import "../styles/persons.css";

class Persons extends Component {
	constructor(props){
		super(props)
		this.state = {
			id: 0,
			name: "",
			lastname: "",
		}
	
	}		

  	render() {
    	return (
			<div id="infoPanel" class="header">
				<span id="seachBar">
					<input id="searchInput"></input>
					<button>Search</button>
				</span>
				<span id="personsList">
					<ol>
						<span className="dataPanel">
						<h2 className="personsText">PERSONS</h2>
						<table id="personsTable">
							<tr className="table_columns">
								<th id="table_id">ID</th>
								<th id="table_name">Name</th>
								<th id="table_lastname">Lastname</th>
							</tr>
							<tr className="table_rows">
								<td>01</td>
								<td>Guillermo</td>
								<td>Marinero</td>
								<td><input type="checkbox"></input><a>Done</a></td>
								<td><a href="remove">Delete</a></td>
							</tr>
						</table>
						</span>
					</ol>
				</span>
    		</div>
		);
  	}
}
export default Persons;