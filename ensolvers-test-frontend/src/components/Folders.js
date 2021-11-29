import React, {useEffect, useState} from "react";
import "../styles/folders.css";
import axios from "axios";
function Folders(props) {

	const getURL = "http://localhost:9000/ensolvers/API/folders/";
	const [post, setPost] = React.useState(null);
		React.useEffect(() => {
			axios.get(getURL).then((response) => {
			setPost(response.data);
			});
		}, []);

  		if (post == null) return null;
		  const listFolders = post.map((folder) =>{
			return(
			<tr className="table_rows">
				<td> {folder.id} </td>
				<td> {folder.name} </td>
				<td> <p> {folder.description} </p> </td>
				<td><a href="remove">Delete</a></td>
			</tr>)});
		

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
						{listFolders}
					</table>
					</span>
				</ol>
			</span>
    	</div>
	);
}
export default Folders;