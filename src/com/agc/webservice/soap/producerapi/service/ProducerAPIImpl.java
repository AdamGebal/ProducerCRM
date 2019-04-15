package com.agc.webservice.soap.producerapi.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.agc.database.Transaction;
import com.agc.entity.Producer;
import com.agc.entity.ProducerCode;
import com.agc.producerapi.ProducerAPI;
import com.agc.producercodedto.ProducerCodeDTO;
import com.agc.producerdto.ProducerDTO;

public class ProducerAPIImpl implements ProducerAPI {
	
	private final static Logger logger = Logger.getLogger(ProducerAPIImpl.class); 

	@Override
	public boolean createProducer(ProducerDTO producerDTO) {
		
		producerDTO.getPublicID();
		producerDTO.getName();
		Producer producer = new Producer(producerDTO.getPublicID(), producerDTO.getName(), producerDTO.getEmail());
		
		Transaction.saveEntity(producer);
		
		for(ProducerCodeDTO pcDTO : producerDTO.getProducerCodeDTO()) {
			ProducerCode producerCode = new ProducerCode(pcDTO.getPublicID(), pcDTO.getCode());
			producer.addProducerCode(producerCode);
			Transaction.saveEntity(producerCode);
		}
		
		logger.info("Producer " + producer.getName() + " saved to the database");
		
		return true;
	}

	@Override
	public ProducerDTO getProducer(String producerPublicID) {
		System.out.println("======================GetProducer====================");
		return null;
	}

}
