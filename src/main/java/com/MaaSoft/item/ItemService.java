package com.MaaSoft.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MaaSoft.chainType.ChainTypeDao;
import com.MaaSoft.chainType.ChainTypeEntity;
import com.MaaSoft.machineType.MachineTypeDao;
import com.MaaSoft.machineType.MachineTypeEntity;

@Service
public class ItemService {
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

}
