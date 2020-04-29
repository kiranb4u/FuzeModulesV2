package com.po.reservation.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.po.reservation.bean.AddContainerDetailsRequest;
import com.po.reservation.bean.AddContainerDetailsResponse;
import com.po.reservation.bean.ReuseProjectDetailsRequest;
import com.po.reservation.bean.ReuseProjectDetailsResponse;

/**
 * @author Sreelekha
 *
 */

@Service
@PropertySource("classpath:global.properties")
public class SoapConsumer {
	private static Logger logger = LoggerFactory.getLogger(SoapConsumer.class);

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Value("${SOAP_BASE_URL}")
	private String soapBaseUrl;

	private WebServiceTemplate webServiceTemplate;

	// consume the reUseProjectDetails From soap application

	public ReuseProjectDetailsResponse reUseProjectDetails(ReuseProjectDetailsRequest reuseProjectDetailsRequest) {
		logger.info("Entering in SoapConsumer class in reUseProjectDetails method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		ReuseProjectDetailsResponse reuseProjectDetailsResponse = null;
		try {
			reuseProjectDetailsResponse = (ReuseProjectDetailsResponse) webServiceTemplate
					.marshalSendAndReceive(soapBaseUrl + "/reuseProjectDetails", reuseProjectDetailsRequest);
		} catch (Exception e) {
			logger.info("Exception  in  reUseProjectDetails method" + e.getMessage());
		}
		return reuseProjectDetailsResponse;
	}

}
