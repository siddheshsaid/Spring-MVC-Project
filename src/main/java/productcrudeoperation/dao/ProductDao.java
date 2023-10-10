package productcrudeoperation.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudeoperation.model.Product;

@Component
public class ProductDao {
    //IT WILL MAKE OBJECT OF HIBERNATETEMPLATE AND INJECT IT INTO
	//THIS CLASS WE CAN USE IT WHEN WE WANT
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//create method
	@Transactional
	public void createProduct(Product product) {
		
		//WE ADD THIS saveOrUpdate()IF ID IS PRESENT IN PRODUCT IT WILL UPDATE CURRENT ID AND IF NOT IT WILL SAVE NEW ID 
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	// loadall products-IT WILL GET LIST OF ALL OBJECTS INSIDE PRIDUCT TABLE
	public List<Product> getProducts(){
		List<Product> products=this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
//	
	@Transactional
	//delete the single product
	public void deleteProduct(int pid) {
		Product p=this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
	}
	
	//get single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class,pid);//can use load also instead of get
	}
	
}
