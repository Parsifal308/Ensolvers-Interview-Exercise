import React, {useEffect, useState}  from "react";
import "../styles/persons.css";
import axios from "axios";

function Persons(props) {
	const url = "http://localhost:9000/ensolvers/API/persons/";

	const [post, setPost] = React.useState(null);
		React.useEffect(() => {
			axios.get(url).then((response) => {
			setPost(response.data);
			});
		}, []);

  		if (post == null) return null;
		  const listPersons = post.map((person) =>{
			return(
			<tr className="table_rows">
				<td> {person.id} </td>
				<td> {person.name} </td>
				<td> {person.lastName} </td>
				<button > Delete </button>
			</tr>)});
		
		return(
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
								<th id="table_name">NOMBRE</th>
								<th id="table_lastname"> APELLIDO </th>
							</tr>
							{listPersons}
						</table>
						</span>
					</ol>
				</span>
    		</div>
		);
}
export default Persons;