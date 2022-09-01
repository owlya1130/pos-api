//package com.example;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.bll.member.MemberLevelSvc;
//import com.example.bll.member.MemberSvc;
//import com.example.bll.payment.PaymentSvc;
//import com.example.bll.product.ProductCatagorySvc;
//import com.example.bll.product.ProductSvc;
//import com.example.bll.product.bo.ProductDetailBO;
//import com.example.bll.store.StoreSvc;
//import com.example.bll.vender.VenderSvc;
//import com.example.dal.config.entity.MemberLevel;
//import com.example.dal.config.entity.Payment;
//import com.example.dal.config.entity.ProductCatagory;
//import com.example.dal.member.entity.Member;
//import com.example.dal.product.entity.Product;
//import com.example.dal.product.entity.ProductBarcode;
//import com.example.dal.product.entity.ProductPrice;
//import com.example.dal.product.entity.ProductVender;
//import com.example.dal.store.entity.Store;
//import com.example.dal.vender.entity.Vender;
//
//@SpringBootTest
//class PosApplicationTests {
//
//	@Autowired
//	VenderSvc venderSvc;
//	@Autowired
//	StoreSvc storeSvc;
//	@Autowired
//	PaymentSvc paymentSvc;
//	@Autowired
//	MemberLevelSvc memberLevelSvc;
//	@Autowired
//	ProductCatagorySvc productCatagorySvc;
//	@Autowired
//	ProductSvc productSvc;
//	@Autowired
//	MemberSvc memberSvc;
//
////	@Test
//	void newVender() {
//		List<Vender> venders = venderSvc.findAll();
//		if(venders.size() == 0) {
//			Vender vender = new Vender();
//			vender.setVenderId("001");
//			vender.setName("三怡長榮");
//			Vender vender2 = new Vender();
//			vender2.setVenderId("002");
//			vender2.setName("炳祥");
//			Vender vender3 = new Vender();
//			vender3.setVenderId("003");
//			vender3.setName("摩米");
//			venderSvc.save(vender);		
//			venderSvc.save(vender2);		
//			venderSvc.save(vender3);
//		}
//	}
//
////	@Test
//	void newStore() {		
//		List<Store> stores = storeSvc.findAll();
//		if(stores.size() == 0) {
//			Store store = new Store();
//			store.setStoreId("001");
//			store.setName("北門店");
//			Store store2 = new Store();
//			store2.setStoreId("002");
//			store2.setName("復國店");
//			Store store3 = new Store();
//			store3.setStoreId("003");
//			store3.setName("左營店");
//			Store store4 = new Store();
//			store4.setStoreId("004");
//			store4.setName("工學店");
//			storeSvc.save(store, productSvc.findAll());
//			storeSvc.save(store2, productSvc.findAll());
//			storeSvc.save(store3, productSvc.findAll());
//			storeSvc.save(store4, productSvc.findAll());
//		}		
//	}
//
////	@Test
//	void newPayment() {		
//		List<Payment> payments = paymentSvc.findAll();
//		if(payments.size() == 0) {
//			Payment payment = new Payment();
//			payment.setPaymentId("001");
//			payment.setName("現金");
//			payment.setDefault(true);
//			Payment payment2 = new Payment();
//			payment2.setPaymentId("002");
//			payment2.setName("信用卡");
//			Payment payment3 = new Payment();
//			payment3.setPaymentId("003");
//			payment3.setName("會員點數");
//			Payment payment4 = new Payment();
//			payment4.setPaymentId("004");
//			payment4.setName("儲值金");
//			paymentSvc.save(payment);
//			paymentSvc.save(payment2);
//			paymentSvc.save(payment3);
//			paymentSvc.save(payment4);
//		}		
//	}
//
////	@Test
//	void newLevel() {
//		List<MemberLevel> levels = memberLevelSvc.findAll();
//		if(levels.size() == 0) {
//			MemberLevel level = new MemberLevel();
//			level.setLevelId("001");
//			level.setName("一般售價");
//			level.setDefault(true);
//			MemberLevel level2 = new MemberLevel();
//			level2.setLevelId("002");
//			level2.setName("員工價");
//			MemberLevel level3 = new MemberLevel();
//			level3.setLevelId("003");
//			level3.setName("批發價");
//			memberLevelSvc.save(level);		
//			memberLevelSvc.save(level2);		
//			memberLevelSvc.save(level3);	
//			levels = memberLevelSvc.findAll();
//		}
//	}
//	
////	@Test
//	void newProductCatagory() {
//		List<ProductCatagory> catagorys = productCatagorySvc.findAll();
//		if(catagorys.size() == 0) {
//			ProductCatagory catagory = new ProductCatagory();
//			catagory.setCatagoryId("001");
//			catagory.setName("牧草");
//			productCatagorySvc.save(catagory);
//		}
//	}
//	
////	@Test
//	void newProduct() {
//		List<Product> products = productSvc.findAll();
//		if(products.size() == 0) {
//			Product product = new Product();
//			product.setProductId("T1");
//			product.setName("提摩西一割");
//			product.setCatagoryUid(
//					productCatagorySvc.findByCatagoryId("001")
//						.getCatagoryUid());
//			
//			ProductPrice price = new ProductPrice();
//			price.setLevelUid(memberLevelSvc.findByLevelId("001").getLevelUid());
//			price.setPrice(95);			
//			ProductPrice price2 = new ProductPrice();
//			price2.setLevelUid(memberLevelSvc.findByLevelId("002").getLevelUid());
//			price2.setPrice(90);		
//			ProductPrice price3 = new ProductPrice();
//			price3.setLevelUid(memberLevelSvc.findByLevelId("003").getLevelUid());
//			price3.setPrice(75);
//			
//			ProductBarcode barcode = new ProductBarcode();
//			barcode.setBarcode("448997");
//			
//			ProductVender vender = new ProductVender();
//			vender.setVenderUid(venderSvc.findByVenderId("001").getVenderUid());
//			ProductVender vender2 = new ProductVender();
//			vender2.setVenderUid(venderSvc.findByVenderId("002").getVenderUid());
//			ProductDetailBO bo = new ProductDetailBO(
//					product, 
//					Arrays.asList(price, price2, price3), 
//					Arrays.asList(barcode), 
//					Arrays.asList(vender, vender2), 
//					Arrays.asList());
//			productSvc.save(bo, storeSvc.findAll());
//		}
//	}
//	
////	@Test
//	void updateProduct() {
//		List<Product> products = productSvc.findAll();
//		ProductDetailBO bo = productSvc.findByProductId(products.get(0).getProductId());
//		bo.getBarcodes().remove(0);
//		ProductBarcode barcode = new ProductBarcode();
//		barcode.setBarcode("newBarcode4");
//		bo.getBarcodes().add(barcode);
//		productSvc.update(bo);
//	}
//	
////	@Test
//	void newMember() {
//		List<Member> members = memberSvc.findAll();
//		if(members.size() == 0) {
//			Member member = new Member();
//			member.setMemberId("001");
//			member.setName("會員1");
//			member.setLevelUid(memberLevelSvc.findByLevelId("001").getLevelUid());
//			member.setMobileNo("0987654321");
//			Member member2 = new Member();
//			member2.setMemberId("002");
//			member2.setName("會員2");
//			member2.setLevelUid(memberLevelSvc.findByLevelId("002").getLevelUid());
//			member2.setMobileNo("0987654322");
//			Member member3 = new Member();
//			member3.setMemberId("003");
//			member3.setName("會員3");
//			member3.setLevelUid(memberLevelSvc.findByLevelId("003").getLevelUid());
//			member3.setMobileNo("0987654323");
//			memberSvc.save(member);		
//			memberSvc.save(member2);		
//			memberSvc.save(member3);	
//		}
//	}
//}
