package com.GMarinero.EnsolversTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GMarinero.EnsolversTest.entities.Folder;

@Repository
public interface FolderDAO  extends JpaRepository<Folder, Long>{

}
