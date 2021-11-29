import React, { Component } from "react";
import "../styles/folders.css";

class Folders extends Component {
	constructor(props){
		super(props)
		this.state={
			id:0,
			name:"",
			description:""
		}
	}

  	render() {
    	return (
			<div id="infoPanel" class="header">
			<span id="seachBar">
				<input id="searchInput"></input>
				<button>Search</button>
			</span>
			<span id="foldersList">
				<ol>
					<span className="dataPanel">
					<h2 className="foldersText">FOLDERS</h2>
					<table id="foldersTable">
						<tr className="table_columns">
							<th id="table_id">ID</th>
							<th id="table_name">Name</th>
							<th id="table_lastname">Description</th>
						</tr>
						<tr className="table_rows">
							<td>01</td>
							<td> Programming Tasks </td>
							<td> <p> All the programming tasks scheduled for this week </p> </td>
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
export default Folders;