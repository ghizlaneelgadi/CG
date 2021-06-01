package com.axway.cg.serviceImp;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.axway.cg.domain.Certification;
import com.axway.cg.service.CerifService;
import java.util.Collection;

@Service
public class CertifServiceImp implements CerifService {
	
	private Long certifId = 1L;
	private Long Id = 2L;
	private Long IdCertif = 3L;
	private Long Identi = 4L;
	private Long I_cr = 5L;
	private Map<Long, Certification> certifMap = new HashMap<Long, Certification>();
	
	{
		Certification certif = new Certification();
		certif.setId_Cert(certifId);
		certif.setState("Not expired");
		certif.setExp_Date("15-02-2022");
		certif.setTime_left(30L);
		certifMap.put(certif.getId_Cert(), certif);
		
		Certification certi = new Certification();
		certi.setId_Cert(Id);
		certi.setState("Not expired");
		certi.setExp_Date("15-02-2022");
		certi.setTime_left(35L);
		certifMap.put(certi.getId_Cert(), certi);
		
		Certification cert = new Certification();
		cert.setId_Cert(IdCertif);
		cert.setState("Not expired");
		cert.setExp_Date("15-02-2022");
		cert.setTime_left(5L);
		certifMap.put(cert.getId_Cert(), cert);
		
	
		
		Certification crt = new Certification();
		crt.setId_Cert(Identi);
		crt.setState("Not expired");
		crt.setExp_Date("15-02-2022");
		crt.setTime_left(3L);
		certifMap.put(crt.getId_Cert(), crt);
		
		Certification cr = new Certification();
		cr.setId_Cert(I_cr);
		cr.setState("Not expired");
		cr.setExp_Date("15-02-2022");
		cr.setTime_left(3L);
		certifMap.put(cr.getId_Cert(), cr);
		
		
	}

	@Override
	public Collection<Certification> findAll() {
		return certifMap.values();
	}

	@Override
	public Certification findById(Long Id_Cert) {
		return certifMap.get(Id_Cert);
	}

	@Override
	public Certification save(Certification cert) {
		Long newcertifId = ++certifId;
		cert.setId_Cert(newcertifId);
		certifMap.put(cert.getId_Cert(), cert);
		return certifMap.get(newcertifId);
	}
}
