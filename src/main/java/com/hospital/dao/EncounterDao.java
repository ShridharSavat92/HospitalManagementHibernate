package com.hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospital.dto.Branch;
import com.hospital.dto.Encounter;

public class EncounterDao 
{
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("shridhar");
	static EntityManager entityManager = factory.createEntityManager();
	static EntityTransaction transaction = entityManager.getTransaction();
	
	public static void saveEncounter(int id,Encounter encounter)
	{
		Branch branch=BranchDao.getBranchById(id);
		if(branch!=null) {
		transaction.begin();
		entityManager.persist(encounter);
		transaction.commit();
		System.out.println("Encounter data inserted!");
		}else {
			System.out.println("Branch does not exist");
		}
		
	}
	
	

}
