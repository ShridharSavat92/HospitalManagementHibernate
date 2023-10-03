package com.hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospital.dto.Address;
import com.hospital.dto.Branch;
import com.hospital.dto.Hospital;

public class BranchDao 
{
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("shridhar");
	static EntityManager entityManager = factory.createEntityManager();
	static EntityTransaction transaction = entityManager.getTransaction();
	
	public static void saveBranch(int id , Branch branch)
	{
		
		Hospital hospital = HospitalDao.getHospitalById(id);
		if(hospital != null)
		{
			transaction.begin();
			branch.setHospital(hospital);
			entityManager.persist(branch);
			transaction.commit();
			System.out.println("Branch data inserted!!");
		}
		else
		{
			System.out.println("Hospital does not exist");
		}
		
	}
	
	public static Branch getBranchById(int id) {
		return entityManager.find(Branch.class, id);
	}

}
