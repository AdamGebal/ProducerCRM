package com.agc.webservice.soap.producerapi.service;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.agc.database.Transaction;
import com.agc.entity.Producer;
import com.agc.entity.ProducerCode;
import com.agc.exception.EntityNotFoundException;
import com.agc.producerapi.ProducerAPI;
import com.agc.producercodedto.ProducerCodeDTO;
import com.agc.producerdto.ProducerDTO;

public class ProducerAPIImpl implements ProducerAPI {
	
	private final static Logger logger = Logger.getLogger(ProducerAPIImpl.class); 

	@Override
	public boolean createProducer(ProducerDTO producerDTO) {	
		Producer producer = new Producer();
		producer.setName(producerDTO.getName());
		producer.setEmail(producerDTO.getEmail());
		producer.setPublicID(producerDTO.getPublicID());
			
		Transaction.saveEntity(producer);
		logger.info("Producer " + producer.getName() + " saved to the database");

		return true;
	}

	@Override
	public ProducerDTO getProducer(String producerPublicID) {
		Producer producer = Transaction.getEntityBasedOnPublicID(Producer.class, producerPublicID);
		ProducerDTO producerDTO = new ProducerDTO();
		producerDTO.setPublicID(producer.getPublicID());
		producerDTO.setName(producer.getName());
		producerDTO.setEmail(producer.getEmail());
		return producerDTO;
	}

	@Override
	public boolean createProducerCode(ProducerCodeDTO producerCodeDTO) {
		ProducerCode producerCode = new ProducerCode();
		producerCode.setCode(producerCodeDTO.getCode());
		producerCode.setPublicID(producerCodeDTO.getPublicID());
		producerCode.setCommissionRate(producerCodeDTO.getCommissionRate());
		String producerPublicID = producerCodeDTO.getProducerPublicId();
		Producer producer = Transaction.getEntityBasedOnPublicID(Producer.class, producerPublicID);
		if(producer != null) {
			producer.addProducerCode(producerCode);
		} else {
			throw new EntityNotFoundException(Producer.class, producerPublicID);
		}
		
		String parentProducerCodePublicID = producerCodeDTO.getParentProducerCodePublicId();
		if(parentProducerCodePublicID != null) {
			ProducerCode parentProducerCode = Transaction.getEntityBasedOnPublicID(ProducerCode.class, parentProducerCodePublicID);
			if(parentProducerCode != null) {
				parentProducerCode.addChildProducerCode(producerCode);
			} else {
				throw new EntityNotFoundException(ProducerCode.class, parentProducerCodePublicID);
			}
		}
		
		Transaction.saveEntity(producerCode);
		
		return true;
	}

}
