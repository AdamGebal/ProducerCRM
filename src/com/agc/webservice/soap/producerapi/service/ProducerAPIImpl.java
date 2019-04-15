package com.agc.webservice.soap.producerapi.service;

import com.agc.producerapi.ProducerAPI;
import com.agc.producerdto.ProducerDTO;

public class ProducerAPIImpl implements ProducerAPI {

	@Override
	public boolean createProducer(ProducerDTO producer) {
		System.out.println("======================CreateProducer====================");
		return false;
	}

	@Override
	public ProducerDTO getProducer(String producerPublicID) {
		System.out.println("======================GetProducer====================");
		return null;
	}

}
