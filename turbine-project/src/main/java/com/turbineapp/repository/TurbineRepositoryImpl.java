package com.turbineapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.turbineapp.entity.TurbineEntity;

@Repository
public class TurbineRepositoryImpl implements TurbineRepository {

	@Autowired
	public EntityManagerFactory entityManagerFactory;

	public TurbineRepositoryImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}

	@Override
	public boolean save(TurbineEntity entity) {

		EntityManager manager = this.entityManagerFactory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();

		return false;
	}

	@Override
	public TurbineEntity findById(int id) {
		System.out.println("Find By Id In Repository..."+id);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		TurbineEntity fromDb = manager.find(TurbineEntity.class, id);
		manager.close();
		return fromDb;
	} 

	@Override
	public List<TurbineEntity> findByComapny(String companyName) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByCompanyName");
			query.setParameter("com", companyName);
			List<TurbineEntity> list = query.getResultList();
			return list;
		} finally {
			manager.close();
		}

	}

	@Override
	public boolean update(TurbineEntity entity) {

		System.out.println("Running update in Repository "+entity);
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(entity);
			entityTransaction.commit();
		} finally {
			entityManager.close(); 
		}
		return true;
	}	
	
	@Override
	public TurbineEntity deleteById(int id) {
		
		System.out.println("Delete By Id ..."+id);
		
		EntityManager entityManager =  this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			TurbineEntity entity = entityManager.find(TurbineEntity.class, id);
			if (entity!=null) {
			     entityTransaction.begin();
			     entityManager.remove(entity);
			     entityTransaction.commit();
			     return entity; 
			}
		} finally {
			entityManager.close();
		}
		return TurbineRepository.super.deleteById(id);
	}
}
