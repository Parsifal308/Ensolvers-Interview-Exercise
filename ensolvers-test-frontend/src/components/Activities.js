import React, {useEffect, useState} from "react";
import "../styles/Activities.css";
import axios from "axios";

function Activities(props) {

	const getURL = "http://localhost:9000/ensolvers/API/activities/";
	const [post, setPost] = React.useState(null);
		React.useEffect(() => {
			axios.get(getURL).then((response) => {
			setPost(response.data);
			});
		}, []);

  		if (post == null) return null;
		  const listActivities = post.map((activity) =>{
			return(
			<tr className="table_rows">
				<td> {activity.id} </td>
				<td> {activity.name} </td>
				<td> {activity.detail} </td>
				<td> {activity.person.name} </td>				
				<td> {activity.date_created} </td>
				<td> {activity.date_started} </td>
				<td> {activity.date_finished} </td>
				<td> {activity.folder.name} </td>
				<td><input type="checkbox"></input><a>Done</a></td>
				<td><a href="remove">Delete</a></td>
			</tr>)});
		
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
								{listActivities}
							</table>
						</span>
					</ol>
				</span>
        	</div>
	);
}

export default Activities;