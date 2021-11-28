package com.GMarinero.EnsolversTest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMarinero.EnsolversTest.entities.Folder;
import com.GMarinero.EnsolversTest.repositories.FolderDAO;

@Service
public class FolderServiceImp implements FolderService{
	
	@Autowired
	private FolderDAO folderDAO;
	
	@Override
	public Folder createFolder(Folder folder) throws Exception {
		try {
			folder = folderDAO.save(folder);
			return folder;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Folder> findFolderById(Long id) throws Exception {
		try {
			Optional<Folder> optionalFolder = folderDAO.findById(id); 
			return optionalFolder;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Folder> findAllFolders() throws Exception {
		try {
			List<Folder> folders = folderDAO.findAll(); 
			return folders;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public Folder updateFolder(Long id, Folder folder) throws Exception {
		try {
			Optional<Folder> optionalFolder = folderDAO.findById(id);
			Folder folderUpdate = optionalFolder.get(); 
			folderUpdate = folderDAO.save(folder);
			return folderUpdate;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean deleteFolder(Long id) throws Exception {
		try {
			if(folderDAO.existsById(id)) { 	
				folderDAO.deleteById(id);
				return true;
			}else {								
				throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
