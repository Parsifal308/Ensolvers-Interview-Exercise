package com.GMarinero.EnsolversTest.services;

import java.util.List;
import java.util.Optional;

import com.GMarinero.EnsolversTest.entities.Folder;

public interface FolderService {
	public Folder createFolder(Folder folder) throws Exception;
	public Optional<Folder> findFolderById(Long id) throws Exception;
	public List<Folder> findAllFolders() throws Exception;
	public Folder updateFolder(Long id, Folder folder) throws Exception;
	public boolean deleteFolder(Long id) throws Exception;
}
