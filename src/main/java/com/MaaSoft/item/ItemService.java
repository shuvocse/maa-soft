package com.MaaSoft.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MaaSoft.chainType.ChainTypeDao;
import com.MaaSoft.chainType.ChainTypeEntity;
import com.MaaSoft.machineType.MachineTypeDao;
import com.MaaSoft.machineType.MachineTypeEntity;
import com.MaaSoft.voucher.VoucherDao;
import com.MaaSoft.voucher.VoucherEntity;

@Service
public class ItemService {
	@Autowired
	private VoucherDao voucherDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ChainTypeDao chainTypeDao;
	@Autowired
	private MachineTypeDao machineTypeDao;

	public ItemEntity saveItem(ItemEntity itemEntity) {
		ItemEntity i= itemDao.saveItem(itemEntity);
		ChainTypeEntity ch= chainTypeDao.getChainTypeById(i.getChainTypeEntity().getChainId());
		MachineTypeEntity mc =machineTypeDao.getMachineTypeById(i.getMachineTypeEntity().getMachineId());
		if(ch!=null){
			i.getChainTypeEntity().setChainName(ch.getChainName());
		}
		if(mc!=null){
			i.getMachineTypeEntity().setMachineName(mc.getMachineName());
		}
		return i;
		
	}

	public void deleteItem(ItemEntity itemEntity) {
		 itemDao.deleteItem(itemEntity);
	}

	public List<ItemEntity> getAllItemByVId(int id) {
		
		List<ItemEntity> ie=itemDao.getAllItemByVId(id);
		
		/*for(ItemEntity i : ie){
			i.getEstCutPoint();
			double point = (i.getEstCutPoint() % 10);
			double roti = ((i.getEstCutPoint()/10)%6);
			double ana = (((i.getEstCutPoint()/10)/6)%16);
			double vori =(((i.getEstCutPoint()/10)/6)/16);
			
		}*/
		return ie;
	}

	public int getAllItemTotalByVId(int id) {
		List<ItemEntity> ie=itemDao.getAllItemByVId(id);
		int totalWeight= 0;
		for(ItemEntity i : ie){
			totalWeight=totalWeight+i.getTotalWeight();
		}
		VoucherEntity v= voucherDao.getVoucherById(id);
		int t=v.getTotalWeight()-totalWeight;
		return t;
	}

}
