package com.example.bll.product;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bll.product.bo.ProductDetailBO;
import com.example.dal.product.ProductBarcodeDao;
import com.example.dal.product.ProductCombinationDao;
import com.example.dal.product.ProductDao;
import com.example.dal.product.ProductPriceDao;
import com.example.dal.product.ProductVenderDao;
import com.example.dal.product.entity.Product;
import com.example.dal.product.entity.ProductBarcode;
import com.example.dal.product.entity.ProductCombination;
import com.example.dal.product.entity.ProductPrice;
import com.example.dal.product.entity.ProductVender;
import com.example.dal.store.entity.Store;

@Service
public class ProductSvcImpl implements ProductSvc {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductPriceDao productPriceDao;
	@Autowired
	private ProductBarcodeDao productBarcodeDao;
	@Autowired
	private ProductVenderDao productVenderDao;
	@Autowired
	private ProductCombinationDao productCombinationDao;
	
	@Autowired
	private ProductQuantitySvc productQuantitySvc;
	
	@Override
	@Transactional
	public ProductDetailBO save(ProductDetailBO productDetailBO, List<Store> storeEntitys) {
		Product productEntity = productDao.save(productDetailBO.getProduct());
		
		if(storeEntitys != null) {
			for(Store storeEntity: storeEntitys) {
				productQuantitySvc.setDefault(productEntity.getProductUid(), storeEntity.getStoreUid());
			}
		}
		
		for(ProductPrice price: productDetailBO.getPrices()) {
			price.setProductUid(productEntity.getProductUid());
		}
		productPriceDao.saveAll(productDetailBO.getPrices());

		if(storeEntitys != null) {
			productDetailBO.getBarcodes().add(new ProductBarcode(productEntity.getProductUid(), productEntity.getProductId()));
		}		
		for(ProductBarcode barcode: productDetailBO.getBarcodes()) {
			barcode.setProductUid(productEntity.getProductUid());
		}
		productBarcodeDao.saveAll(productDetailBO.getBarcodes());
		
		for(ProductVender vender: productDetailBO.getVenders()) {
			vender.setProductUid(productEntity.getProductUid());
		}
		productVenderDao.saveAll(productDetailBO.getVenders());
		
		if(productDetailBO.getCombinations() != null) {
			for(ProductCombination combination: productDetailBO.getCombinations()) {
				combination.setProductUid(productEntity.getProductUid());
			}
			productCombinationDao.saveAll(productDetailBO.getCombinations());
		}
		
		return findByProductUid(productEntity.getProductUid());
	}

	@Override
	@Transactional
	public ProductDetailBO update(ProductDetailBO productDetailBO) {
		ProductDetailBO productDetailEntity = findByProductUid(productDetailBO.getProduct().getProductUid());
					
		List<Integer> priceUids = 
				productDetailBO
					.getPrices()
					.stream()
					.map(ProductPrice::getPriceUid)
					.collect(Collectors.toList());

		List<Integer> barcodeUids = 
				productDetailBO
					.getBarcodes()
					.stream()
					.map(ProductBarcode::getBarcodeUid)
					.collect(Collectors.toList());

		List<Integer> venderUids = 
				productDetailBO
					.getVenders()
					.stream()
					.map(ProductVender::getVenderUid)
					.collect(Collectors.toList());

		List<Integer> combinationUids = 
				productDetailBO
					.getCombinations()
					.stream()
					.map(ProductCombination::getCombinationUid)
					.collect(Collectors.toList());
		
		productDetailEntity
			.getPrices()
			.stream()
			.map(ProductPrice::getPriceUid)
			.filter(eUid -> !priceUids.contains(eUid))
			.forEach(eUid -> productPriceDao.deleteById(eUid));
		productDetailEntity
			.getBarcodes()
			.stream()
			.map(ProductBarcode::getBarcodeUid)
			.filter(eUid -> !barcodeUids.contains(eUid))
			.forEach(eUid -> productBarcodeDao.deleteById(eUid));
		productDetailEntity
			.getVenders()
			.stream()
			.map(ProductVender::getVenderUid)
			.filter(eUid -> !venderUids.contains(eUid))
			.forEach(eUid -> productVenderDao.deleteById(eUid));
		productDetailEntity
			.getCombinations()
			.stream()
			.map(ProductCombination::getCombinationUid)
			.filter(eUid -> !combinationUids.contains(eUid))
			.forEach(eUid -> productCombinationDao.deleteById(eUid));
		
		return save(productDetailBO, null);
	}

	@Override
	@Transactional
	public void delete(Integer productUid) {
		productDao.findById(productUid).get().setDeleted(true);
	}

	@Override
	public ProductDetailBO findByProductUid(Integer productUid) {
		Product productEntity = productDao.findById(productUid).get();
		List<ProductPrice> prices = productPriceDao.findByProductUid(productEntity.getProductUid());
		List<ProductBarcode> barcodes = productBarcodeDao.findByProductUid(productEntity.getProductUid());
		List<ProductVender> venders = productVenderDao.findByProductUid(productEntity.getProductUid());
		List<ProductCombination> combinations = productCombinationDao.findByProductUid(productEntity.getProductUid());
		
		return new ProductDetailBO(productEntity, prices, barcodes, venders, combinations);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findByBarcode(String barcode) {
		Integer productUid = productBarcodeDao.findByBarcode(barcode).getProductUid();
		return productDao.findById(productUid).get();
	}

}
