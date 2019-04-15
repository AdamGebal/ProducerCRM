package com.agc.webservice.soap.producerapi.service;

import java.util.ArrayList;
import java.util.List;

import com.agc.database.Transaction;
import com.agc.entity.Producer;
import com.agc.entity.ProducerCode;
import com.agc.producerapi.ProducerAPI;
import com.agc.producercodedto.ProducerCodeDTO;
import com.agc.producerdto.ProducerDTO;

public class ProducerAPIImpl implements ProducerAPI {

	@Override
	public boolean createProducer(ProducerDTO producerDTO) {
		
		producerDTO.getPublicID();
		producerDTO.getName();
		Producer producer = new Producer(producerDTO.getPublicID(), producerDTO.getName(), producerDTO.getEmail());
		List<ProducerCode> producerCodes = new ArrayList<>();
		for(ProducerCodeDTO pcDTO : producerDTO.getProducerCodeDTO()) {
			ProducerCode producerCode = new ProducerCode(pcDTO.getPublicID(), pcDTO.getCode());
			producerCodes.add(producerCode);
		}
		
		Transaction.saveEntity(producer);
		
		return true;
	}

	@Override
	public ProducerDTO getProducer(String producerPublicID) {
		System.out.println("======================GetProducer====================");
		return null;
	}

}
