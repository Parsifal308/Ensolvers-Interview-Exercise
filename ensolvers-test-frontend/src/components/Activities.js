import React, { Component } from "react";
import "../styles/Activities.css";

class Activities extends Component {
 
	constructor(props){
		super(props)
		this.state={
			id:0,
			name: "",
			detai:"",
			created:"",
			started:"",
			finished:"",
			isDone:false,
			fk_person:0,
			fk_folder:0
		} 
	}
	
	render() {
    	return (
			<div id="infoPanel" class="header">
				<span id="seachBar">
					<input id="searchInput"></input>
					<button>Search</button>
				</span>
				<span id="activitiesList">
					<ol>
						<span className="dataPanel">
							<h2 className="activityText">ACTIVITIES</h2>
							<table id="table">
								<tr className="table_columns">
									<th id="table_id">ID</th>
									<th id="table_name">Name</th>
									<th id="table_detail">Detail</th>
									<th id="table_person">Person Assigned</th>
									<th id="table_dateCreated">Created</th>
									<th id="table_dateStarted">Started</th>
									<th id="table_dateFinished">Finished</th>
									<th id="table_folderName">Folder</th>

								</tr>
								<tr className="table_rows">
									<td>01</td>
									<td>Programar</td>
									<td>Programar test de Ensolvers</td>
									<td>Guillermo Marinero</td>
									<td>27/11/2021</td>
									<td>27/11/2021</td>
									<td></td>
									<td>Programming Tasks</td>
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

export default Activities;